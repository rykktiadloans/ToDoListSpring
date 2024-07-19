package com.todolist.core.controllers;

import com.todolist.core.config.UserModelDetails;
import com.todolist.core.model.ListModel;
import com.todolist.core.model.UserModel;
import com.todolist.core.repository.ListRepository;
import com.todolist.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.*;

/**
 * The controller that manages list access
 */
@Controller
public class ListController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ListRepository listRepository;

    /**
     * Gets a page with a new empty list on "/new"
     * @param model Model object we use to populate the template
     * @return List template
     */
    @GetMapping("/new")
    public String makeNewList(Model model){
        model.addAttribute("listModel", new ListModel(""));
        return "list";
    }

    /**
     * Saves a list to the database on "/save" with POST method
     * @param listModel The ListModel object we are trying to save
     * @param model The model we use to populate the template
     * @param authentication The authentication object
     * @return Redirect the user to the page that shows the list object, "/list/{id}"
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("listModel") ListModel listModel, Model model, Authentication authentication){
        UserModelDetails userModelDetails = (UserModelDetails) authentication.getPrincipal();
        Optional<UserModel> userModel = this.userRepository.findById(userModelDetails.getId());
        if(userModel.isEmpty()){
            return "redirect:/login";
        }
        listModel.setUserModel(userModel.get());
        userModel.get().getLists().add(listModel);
        this.userRepository.save(userModel.get());
        this.listRepository.save(listModel);
        return "redirect:/list/" + String.valueOf(listModel.getId());
    }

    /**
     * Show a page that views a list on "/list/{id}"
     * @param id The id of the list
     * @param model Model object we use to populate the template
     * @param authentication The authentication object
     * @return List page
     */
    @GetMapping("/list/{id}")
    public String getList(@PathVariable String id, Model model, Authentication authentication){
        Optional<ListModel> listModel = this.listRepository.findById(Long.parseLong(id));
        if(listModel.isEmpty()){
            return "redirect:/new";
        }
        UserModelDetails userModelDetails = (UserModelDetails) authentication.getPrincipal();
        if(!Objects.equals(userModelDetails.getId(), listModel.get().getUserModel().getId())){
            return "redirect:/login";
        }
        model.addAttribute("listModel", listModel.get());
        return "list";


    }

    /**
     * Returns the page that lets us overview all the lists available to the user on "/lists"
     * @param model Model object we use to populate the template
     * @param authentication The authentication object
     * @return Lists view
     */
    @GetMapping("/lists")
    public String listOverview(Model model, Authentication authentication){
        UserModelDetails userModelDetails = (UserModelDetails) authentication.getPrincipal();
        Optional<UserModel> userModel = this.userRepository.findById(userModelDetails.getId());
        if(userModel.isEmpty()){
            return "redirect:/login";
        }
        model.addAttribute("lists", userModel.get().getLists());
        return "lists";

    }

}
