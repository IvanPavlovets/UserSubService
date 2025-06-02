package com.example.user_sub_service.service;

import com.example.user_sub_service.model.User;
import com.example.user_sub_service.model.UserRecord;
import com.example.user_sub_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> createUser(User user) {
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(this.userRepository.save(user));
        } catch (Exception e) {
            log.error("Feedback save error: {}", e.getMessage());
        }
        return result;
    }

    @Override
    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(Long id, UserRecord userRecord) {
        var findedUser = userRepository.findById(id);
        if (findedUser.isPresent()) {
            User updatedUser = findedUser.get();
            updatedUser.setName(userRecord.name());
            updatedUser.setPassword(userRecord.password());
            updatedUser.setEmail(userRecord.email());
            return this.createUser(updatedUser);
        }
        return findedUser;
    }

    @Override
    public Optional<User> deleteUserById(long userId) {
        var findedUser = userRepository.findById(userId);
        if (findedUser.isPresent()) {
            userRepository.deleteById(userId);
        }
        return findedUser;
    }

}
