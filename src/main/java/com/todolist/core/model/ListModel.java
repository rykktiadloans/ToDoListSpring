package com.todolist.core.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that corresponds to the list entity
 */
@Entity
@Table(name = "LIST")
public class ListModel {
    @Id
    @GeneratedValue
    private Long id = null;
    @Column(name ="list_name")
    private String listName;
    @Column(name ="checked_list")
    private List<Integer> checkedList;
    @Column(name = "item_list")
    private List<String> itemList;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserModel userModel;

    /**
     * Empty constructor
     */
    public ListModel() {}

    /**
     * Constructor that sets the name of the list
     * @param listName The name of the list
     */
    public ListModel(String listName) {
        this.listName = listName;
    }


    /**
     * Returns the list's name
     * @return List's name
     */
    public String getListName() {
        return listName;
    }

    /**
     * Sets the list name
     * @param listName List's name
     */
    public void setListName(String listName) {
        this.listName = listName;
    }


    /**
     * Gets a list of indexes of items that were completed
     * @return List of completed indexes
     */
    public List<Integer> getCheckedList() {
        return checkedList;
    }

    /**
     * Sets a list of indexes of items that were completed
     * @param checkedList of completed indexes
     */
    public void setCheckedList(List<Integer> checkedList) {
        this.checkedList = checkedList;
    }

    /**
     * Get the list of items
     * @return List of items
     */
    public List<String> getItemList() {
        return itemList;
    }

    /**
     * set the list of items
     * @param itemList List of items
     */
    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    /**
     * Get the id of the list
     * @return List's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id of the list
     * @param id List's id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the owner of the list
     * @return User
     */
    public UserModel getUserModel() {
        return userModel;
    }

    /**
     * Set the owner of the list
     * @param userModel User
     */
    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
