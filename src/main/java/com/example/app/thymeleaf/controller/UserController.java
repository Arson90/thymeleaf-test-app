package com.example.app.thymeleaf.controller;

import com.example.app.thymeleaf.model.User;
import com.example.app.thymeleaf.model.UserHTTPRequest;
import com.example.app.thymeleaf.model.UserHTTPResponse;
import com.example.app.thymeleaf.model.UserMapper;
import com.example.app.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/user/{id}")
//    public UserHTTPResponse getUserByID(@PathVariable long id){
//        return userService.getUserById(id);
//    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserHTTPRequest());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String saveUser(@Validated UserHTTPRequest userHTTPRequest, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.saveUser(userHTTPRequest);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateFormById(@PathVariable("id") long id, Model model){
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated User user, BindingResult result) {
       if (result.hasErrors()) {
           user.setId(id);
           return "update-user";
       }
       UserHTTPRequest userHTTPRequest = UserMapper.mapRequest(user);
       userService.updateUserById(id, userHTTPRequest);
       return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id, Model model){
        userService.deleteUserById(id);
        return "redirect:/index";
    }
}
