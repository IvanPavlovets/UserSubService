package com.example.user_sub_service.controller;

import com.example.user_sub_service.model.User;
import com.example.user_sub_service.model.UserRecord;
import com.example.user_sub_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * контроллер описывает CRUD операции
 * и построен по схеме Rest архитектуры:
 * POST /users/ - создает пользователя.
 * GET /users/{id} - получить пользователь по id.
 * PUT /users/{id} - обновляет пользователя.
 * DELETE /users/{id} - удаляет.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return getResponseEntity(this.userService.createUser(user),
                HttpStatus.CREATED, HttpStatus.CONFLICT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        return getResponseEntity(this.userService.findUserById(id),
                HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRecord userRecord) {
        return getResponseEntity(this.userService.updateUser(id, userRecord),
                HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
        return getResponseEntity(this.userService.deleteUserById(id),
                HttpStatus.OK, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<User> getResponseEntity(Optional<User> user,
                                                   HttpStatus ok, HttpStatus notFound) {
        return new ResponseEntity<User>(
                user.orElse(new User()),
                user.isPresent() ? ok : notFound
        );
    }

}
