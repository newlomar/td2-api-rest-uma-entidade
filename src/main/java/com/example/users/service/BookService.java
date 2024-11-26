package com.example.books.service;

import com.example.users.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> bookList;

    public BookService() {
        bookList = new ArrayList<>();

        Book book1 = new Book(1, "José", 23, "jose@gmail.com");
        Book book2 = new Book(2, "Joao", 23, "joao@gmail.com");
        Book book3 = new Book(3, "Joyce", 23, "joyce@gmail.com");
        Book book4 = new Book(4, "Luis", 25, "luis@gmail.com");

        bookList.addAll(Arrays.asList(book1, book2, book3, book4));
    }

    public Optional<Book> getBookById(Integer id) {
        Optional<Book> optional = Optional.empty();

        for(Book book: bookList) {
            if(id == book.getId()) {
                optional = Optional.of(book);
                return optional;
            }
        }

        return optional;
    }

    public Optional<List<Book>> getAllBooks() {
        Optional<List<Book>> optional = Optional.empty();

        optional = Optional.of(bookList);
        return optional;

    }



    public Optional<Book> createBook(String name, int age, String email) {
        Optional <Book> optional = Optional.empty();

        int id = (bookList.getLast()).getId() + 1;
        Book newBook = new Book(id, name, age, email);
        bookList.add(newBook);

        optional = Optional.of(newBook);

        return optional;
    }

    public Optional<Book> editBook(Book book) {
        Optional <Book> optional = Optional.empty();

        int index=0;
        for(Book currentBook: bookList) {
            if(book.getId() == currentBook.getId()) {
                optional = Optional.of(book);
                bookList.set(index, book);
                return optional;
            }
            index++;
        }
        return optional;
    }

    public void deleteBook(int id) {
        bookList.removeIf(book -> (book.getId() == id));
    }
}