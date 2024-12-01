package com.example.users.service;

import com.example.users.model.User;
import com.example.users.model.Book;
import com.example.users.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User addUser(int id, String name,int age, String email) {
        User user = new User(id, name, age, email);
        return userRepository.save(user);
    }

    @Transactional
    public User addUserWithBooks(int id, String name,int age, String email, List<Book> books) {
        User user = new User(id, name, age, email);

        for (Book book : books) {
            user.addBook(book);
        }

        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    @Transactional
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User updateUser(int userId, String name, int age, String email) {
        // Find the existing user by ID
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        existingUser.setName(name);
        existingUser.setAge(age);
        existingUser.setEmail(email);

        return userRepository.save(existingUser);
    }

}