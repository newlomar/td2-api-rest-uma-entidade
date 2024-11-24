package com.example.users.api;

import com.example.users.model.Book;
import com.example.users.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
public class BookController {

//    private final BookService bookService;
//
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    @GetMapping("/book")
//    public Book getBook(@RequestParam Integer id) {
//        Book book = bookService.getBookById(id);
//
//        return  (Book) book;
//    }
//
//    @GetMapping("/allBooks")
//    public List<Book> getAllBooks() {
//        Optional<List<Book>> book = bookService.getAllBooks();
//
//        return  (List<Book>) book.orElse(null);
//    }
//
//    @PostMapping("/book")
//    public Book createBook(@RequestBody Book book) {
//
//        Optional<Book> newBook =
//               bookService.createBook(book.getName(), book.getRelease_date());
//
//        return (Book) newBook.orElse(null);
//    }

//    @PutMapping("/book")
//    public Book editBook(@RequestBody Book book) {
//
//        Optional<Book> editedBook =
//                bookService.editBook(book);
//
//        return (Book) editedBook.orElse(null);
//    }
//
//    @DeleteMapping("/book")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteBook(@RequestParam int id) {
//        bookService.deleteBook(id);
//    }

}