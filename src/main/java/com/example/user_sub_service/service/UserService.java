package com.example.user_sub_service.service;

import com.example.user_sub_service.model.User;
import com.example.user_sub_service.model.UserRecord;

import java.util.Optional;

/**
 * CRUD operations for User entity:
 * save - save User;
 * findById - get User by id;
 * update - update user;
 * deleteById - delete user by id.
 */
public interface UserService {
    Optional<User> createUser(User user);

    Optional<User> findUserById(long id);

    Optional<User> updateUser(Long id, UserRecord user);

    Optional<User> deleteUserById(long userId);
}
