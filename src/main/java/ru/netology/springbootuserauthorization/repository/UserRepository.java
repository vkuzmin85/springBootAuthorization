package ru.netology.springbootuserauthorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootuserauthorization.model.Authorities;
import ru.netology.springbootuserauthorization.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    public ConcurrentHashMap<User, List<Authorities>> userAuthorities = new ConcurrentHashMap<>();

    public UserRepository() {
         }
    public List<Authorities> getUserAuthorities(User user) {
        userAuthorities.put(new User("John", "0024"), List.of(Authorities.READ));
        userAuthorities.put(new User("Helen", "0027"), List.of((Authorities.READ), Authorities.WRITE));
        userAuthorities.put(new User("Mike", "0022"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        return userAuthorities.getOrDefault(user, null);


    }
}

