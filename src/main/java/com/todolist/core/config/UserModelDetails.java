package com.todolist.core.config;

import com.todolist.core.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

/**
 * The class that describes the details of a user
 */
public class UserModelDetails implements UserDetails {
    private UserModel user;

    public UserModelDetails(UserModel user) {
        this.user = user;
    }

    /**
     * Get user's ID
     * @return User's ID
     */
    public Long getId(){
        return this.user.getId();
    }

    /**
     * Returns user's authorities
     * @return User's authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Arrays.asList(authority);
    }

    /**
     * Return user's encrypted password
     * @return Encrypted password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Return user's username
     * @return User's username
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Return a value of whether or not the user's account has expired
     * @return Returns true
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Returns the value that corresponds to whether or not the account is locked
     * @return Rturns true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Returns the value that corresponds to whether or not the account's credentials have expired
     * @return Returns true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Is the account enabled?
     * @return Returns true
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
