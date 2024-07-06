package com.todolist.core.controllers;

import com.todolist.core.model.UserModel;
import com.todolist.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.AuthProvider;

/**
 * Controller that manages user authentication
 */
@Controller
public class LoginController {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Return the login page on "/login"
     * @return The login page
     */
    @GetMapping("/login")
    String login() {
        return "login";
    }

    /**
     * Return the register page on "/register"
     * @return The register page
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * Return the logout confirmation page on "/logout"
     * @return The logout page
     */
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    /**
     * Create a new account and redirect to "/login". Accessible on "/register" with POST method.
     * @param name User's username
     * @param password User's password
     * @return The login page
     */
    @PostMapping("/register")
    public String registerPost(
            @RequestParam(value="username") String name,
            @RequestParam(value="password") String password
    ){
        UserModel userModel = new UserModel(name, this.passwordEncoder.encode(password), "USER", true);
        this.userRepository.save(userModel);

        return "/login";

    }
}
