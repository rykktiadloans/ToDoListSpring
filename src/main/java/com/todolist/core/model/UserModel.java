package com.todolist.core.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * The class that corresponds to the model of a user
 */
@Entity
@Table(name="users")
public class UserModel {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String role;
    private boolean enabled;
    @OneToMany(mappedBy = "userModel", cascade = CascadeType.REMOVE)
    private List<ListModel> lists;

    /**
     * Empty constructor
     */
    public UserModel() {}

    /**
     * The complete constructor
     * @param username User's username
     * @param password User's password
     * @param role User's role
     * @param enabled Whether the account is enabled or not
     */
    public UserModel(String username, String password, String role, boolean enabled){
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    /**
     * Returns user's id
     * @return User's id
     */
    public Long getId() {
        return id;
    }

    /**
     * Get user's username
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set user's username
     * @param username User's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get user's password
     * @return User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set user's password
     * @param password User's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get user's roles
     * @return User's roles
     */
    public String getRole() {
        return role;
    }

    /**
     * Set user's roles
     * @param role User's roles
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Return whether or not the account is enabled
     * @return User's status
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set whether the account is enabled or not
     * @param enabled The new status
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Get the lists that the user owns
     * @return User's lists
     */
    public List<ListModel> getLists() {
        return lists;
    }

    /**
     * Set the lists that the user owns
     * @param lists User's lists
     */
    public void setLists(List<ListModel> lists) {
        this.lists = lists;
    }
}
