package com.SpringMan.MongoDB.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.SpringMan.MongoDB.Entity.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student , String>{
    Student findByEmail(String email);
}
