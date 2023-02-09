package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;
    private final RoleRepository roleRepository;

    public AdminController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }


    @GetMapping(value = "/admin")
    public String listUsers(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("listUsers", users);
        //return "index";
        return "admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

//    @GetMapping(value = "/admin/new")
//    public ModelAndView newUser() {
//        User user = new User();
//        ModelAndView mav = new ModelAndView("/admin/new");
//        mav.addObject("user", user);
//
//        List<Role> roles = (List<Role>) roleRepository.findAll();
//
//        mav.addObject("allRoles", roles);
//
//        return mav;
//    }
//    @PostMapping(value = "/admin/new")
//    public String createNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "/admin/new";
//        }
//        userService.add(user);
//        return "redirect:/admin";
//    }

    @GetMapping(value = "/admin/new")
    public String newEmptyUser(@ModelAttribute("user") User user,ModelMap model) {
        List<Role> roles = (List<Role>) roleRepository.findAll();
        model.addAttribute("allRoles", roles);
        return "/new";
    }


    @PostMapping()
    public String createNewUser(@ModelAttribute("user")  User user) {
//        if (bindingResult.hasErrors()) {
//            return "/admin/new";
//        }
      //  List<User> users = userService.listUsers().stream().toList();
       // var a=users.contains(user.getUsername());
      //  if(!a){
            userService.add(user);
            return "redirect:/admin";
      //  }
//      else{
//            return "/admin/new";
//        }

    }

    @GetMapping("/admin/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        List<Role> roles = (List<Role>) roleRepository.findAll();
        model.addAttribute("allRoles", roles);
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PatchMapping("/admin/edit/{id}")
    public String update(@ModelAttribute("user")  User user,  @PathVariable("id") Long id) {
//        if (bindingResult.hasErrors()) {
//            return "/edit";
//        }
        userService.update(user,id);
        return "redirect:/admin";
    }
//@GetMapping(value = "/admin/new")
//public String Users(ModelMap model) {
//    System.out.println("This");
//    return "/new";
//}
@GetMapping()
public String getstart() {
    return "index";
}
}
