package com.example.users.service;

import com.example.users.model.Book;
import com.example.users.model.User;
import com.example.users.repository.BookRepository;
import com.example.users.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book addBookToUser(int userId, Book book) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + userId));
        Book book1 = new Book(book.getId(), book.getName(), book.getRelease_date());
        book1.setUser(user);


        return bookRepository.save(book1);
    }
}