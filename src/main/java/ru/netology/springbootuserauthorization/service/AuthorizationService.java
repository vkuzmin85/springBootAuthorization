package ru.netology.springbootuserauthorization.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootuserauthorization.exceptions.InvalidCredentials;
import ru.netology.springbootuserauthorization.exceptions.UnauthorizedUser;
import ru.netology.springbootuserauthorization.model.Authorities;
import ru.netology.springbootuserauthorization.model.User;
import ru.netology.springbootuserauthorization.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getName()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
