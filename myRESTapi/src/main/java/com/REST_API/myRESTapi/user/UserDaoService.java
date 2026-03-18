package com.REST_API.myRESTapi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    // DAO is used for implement methods to retrive data

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "John Doe", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Kevin 2Phones", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Pink Guy", LocalDate.now().minusYears(35)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

}
