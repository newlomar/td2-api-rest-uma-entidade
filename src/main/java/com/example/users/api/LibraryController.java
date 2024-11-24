package com.example.users.api;

import com.example.users.dto.BookRequest;
import com.example.users.model.User;
import com.example.users.model.Book;
import com.example.users.service.UserService;
import com.example.users.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private final UserService userService;
    private final BookService bookService;

    public LibraryController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.addUser(user.getId(),user.getName(),user.getAge(), user.getEmail());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> users = bookService.getAllBooks();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestParam String name, @RequestParam int age, @RequestParam String email) {
        User updatedUser = userService.updateUser(id, name, age, email);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest) {
        Book newBook = new Book(bookRequest.getId(),
                bookRequest.getName(),
                bookRequest.getRelease_date());
        Book createdBook = bookService.addBookToUser(
                bookRequest.getUserId(),
                newBook
        );
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users/{id}/books")
    public ResponseEntity<Book> addBookToUser(
            @PathVariable int id,
            @RequestBody BookRequest bookRequest) {
        Book newBook = new Book(bookRequest.getId(),
                bookRequest.getName(),
                bookRequest.getRelease_date());
        Book createdBook = bookService.addBookToUser(
                id,
                newBook
        );
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

}