package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/")
//    public String listUsers(ModelMap model) {
//        List<User> users = userService.listUsers();
//        model.addAttribute("listUsers", users);
//        //return "index";
//        return "admin";
//
//    }
//
//    @GetMapping("/user")
//    public String showCurrentUser(@ModelAttribute("user") User user) {
//        var a= userService.getUserById(user.getId());
//        return "/user";
//    }
@GetMapping("/user")
public String show( Model model, Authentication authentication) {
    UserDetails realUser= (UserDetails)authentication.getPrincipal();
    model.addAttribute("user", realUser);
    return "user";
}

//
//    @GetMapping("/new")
//    public String newEmptyUser(@ModelAttribute("user") User user) {
//        return "/new";
//    }
//
//    @PostMapping()
//    public String createNewUser(@ModelAttribute("user") User user) {
//        userService.add(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(ModelMap model, @PathVariable("id") Long id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
//        userService.update(user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect:/";
//    }
//
//
}
