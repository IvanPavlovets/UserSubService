package com.example.user_sub_service.model;

/**
 * User DTO for update endopoint
 * @param name
 * @param password
 * @param email
 */
public record UserRecord(String name, String password, String email) {
}
