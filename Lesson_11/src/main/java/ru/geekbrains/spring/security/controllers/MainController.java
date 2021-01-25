package ru.geekbrains.spring.security.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.security.entities.User;
import ru.geekbrains.spring.security.services.UserService;

import java.security.Principal;

@RestController
@Profile("dao")
@Slf4j
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/score")
    public String getCurrentScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "Your score: " + user.getScore();
    }

    @GetMapping("/score/inc/{n}")
    public String increaseScore(Principal principal, @PathVariable Integer n) {
        User user = userService.findByUsername(principal.getName()).get();
        userService.increaseScore(user, n);
        return "current score for " + user.getUsername() + " : " + user.getScore();
    }

    @GetMapping("/score/dec/{n}")
    public String decreaseScore(Principal principal, @PathVariable Integer n) {
        User user = userService.findByUsername(principal.getName()).get();
        userService.decreaseScore(user, n);
        return "current score for " + user.getUsername() + " : " + user.getScore();
    }

    @GetMapping("/score/{id}")
    public String showScoreById(@PathVariable Long id) {
        return String.format("User with id = %s has score %s", id, userService.getScoreById(id));
    }
}
