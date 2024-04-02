package ru.itmentor.spring.boot_security.demo.controllers;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "main";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", userService.getRoles());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                         @RequestParam("role") String[] selectedRoles) {
        userService.createUser(user, selectedRoles);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String updateUserGet(@PathVariable("id") Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        model.addAttribute("allRoles", userService.getRoles());
        return "update";
    }


    @PostMapping("/update/{id}")
    public String updateUserPost(@ModelAttribute("user") User user, @PathVariable("id") Long id, @RequestParam("role") String[] role) {
        user.setId(id);
        userService.updateUser(user, role);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
