package com.todolist.core.repository;

import com.todolist.core.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * The repository of user objects in the database
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    /**
     * The method that can return a user by their username
     * @param username Username of the user
     * @return The user
     */
    @Query("SELECT u FROM UserModel u WHERE u.username = :username")
    public UserModel getUserByUsername(@Param("username") String username);
}
