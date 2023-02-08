package ru.netology.springbootuserauthorization.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.netology.springbootuserauthorization.model.Authorities;
import ru.netology.springbootuserauthorization.model.User;
import ru.netology.springbootuserauthorization.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }
    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
    //public List<Authorities> getAuthorities(@RequestParam("user") User user, @RequestParam("password") String password) {
        return service.getAuthorities(user);
    }

}
