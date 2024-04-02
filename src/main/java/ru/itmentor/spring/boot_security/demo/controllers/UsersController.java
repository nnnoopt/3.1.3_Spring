package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String userInfo(Model model, Authentication authentication) {
        String auth = authentication.getName();
        User user = userService.getByName(auth);
        model.addAttribute("user", user);
        return "user";
    }
}