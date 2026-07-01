# MongoDB Student API

A Spring Boot REST API for managing students with MongoDB Atlas.

## Tech Stack

- **Java 21** + **Spring Boot 4.1.0**
- **Spring Data MongoDB** — data access layer
- **MongoDB Atlas** — cloud-hosted database
- **Lombok** — reduces boilerplate
- **spring-dotenv** — loads `.env` for secrets
- **SpringDoc OpenAPI** — Swagger UI at `/swagger-ui.html`

## How the MongoDB Connection Works

The connection chain is:

```
.env                  stores the connection string (git-ignored)
  ↓
application.properties  reads it via ${MONGO_DB} placeholder
  ↓
spring.data.mongodb.uri  →  Spring Data MongoDB auto-configures
  ↓                           MongoClient, MongoTemplate, etc.
MongoDB Atlas cluster
```

### Step-by-step

1. **`.env`** — contains the MongoDB Atlas connection string:
   ```
   MONGO_DB=mongodb+srv://<user>:<password>@<cluster>.mongodb.net/?appName=Cluster0
   ```

2. **`spring-dotenv`** — the dependency `me.paulschwarz:spring-dotenv` loads `.env` values into the runtime environment on startup.

3. **`application.properties`** — references the env variable:
   ```properties
   spring.data.mongodb.uri=${MONGO_DB}
   spring.data.mongodb.database=studentdb
   ```
   Spring Boot's `MongoAutoConfiguration` picks up `spring.data.mongodb.uri` and creates a `MongoClient` connected to Atlas. The `database` property sets the default database name.

4. **`MongoRepository`** — `StudentRepo` extends `MongoRepository<Student, String>`, which Spring Data automatically implements at runtime. All CRUD operations delegate to the configured `MongoClient`.

## Project Structure

```
src/main/java/com/SpringMan/MongoDB/
├── MongoDbApplication.java       — entry point
├── Entity/
│   └── Student.java              — document mapped to "students" collection
├── Repo/
│   └── StudentRepo.java          — MongoDB repository interface
├── Service/
│   └── StudentService.java       — business logic layer
└── Controller/
    └── StudentController.java    — REST endpoints
```

## API Endpoints

| Method | Endpoint             | Description          |
|--------|----------------------|----------------------|
| POST   | `/api/students`      | Create a student     |
| GET    | `/api/students`      | Get all students     |
| GET    | `/api/students/{id}` | Get student by ID    |
| DELETE | `/api/students/{id}` | Delete a student     |

## Running Locally

1. Ensure the `.env` file has a valid MongoDB Atlas connection string.
2. Run with Maven:
   ```sh
   ./mvnw spring-boot:run
   ```
3. Access the app at `http://localhost:8080`.
4. Swagger UI at `http://localhost:8080/swagger-ui.html`.
