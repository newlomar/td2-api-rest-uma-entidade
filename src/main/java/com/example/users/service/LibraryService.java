package com.example.users.service;

import com.example.users.model.User;
import com.example.users.model.Book;
import com.example.users.repository.UserRepository;
import com.example.users.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public LibraryService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public User addUserWithBooks(int id, String name,int age, String email, List<Book> books) {
        User user = new User(id, name, age, email);

        for (Book book : books) {
            user.addBook(book);
        }

        return userRepository.save(user); // Save user and associated books
    }

    public Optional<Book> findBooksByAuthor(Integer id) {
        return bookRepository.findById(id);
    }
}