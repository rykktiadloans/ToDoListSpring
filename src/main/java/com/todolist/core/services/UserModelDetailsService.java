package com.todolist.core.services;

import com.todolist.core.config.UserModelDetails;
import com.todolist.core.model.UserModel;
import com.todolist.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service used to work with the user models
 */
@Service
public class UserModelDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Method that allows to get the user details of the user
     * @param username User's username
     * @return The user's details
     * @throws UsernameNotFoundException Thrown if the user with this name does not exist
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.getUserByUsername(username);
        if(userModel == null){
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UserModelDetails(userModel);
    }
}
