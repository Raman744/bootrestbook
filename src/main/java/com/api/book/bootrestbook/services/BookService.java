package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    // private static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(1, "Java Complete Reference #1", "Xyz#1"));
    // list.add(new Book(2, "Java Complete Reference #2", "Xyz#2"));
    // list.add(new Book(3, "Java Complete Reference #3", "Xyz#3"));
    // list.add(new Book(4, "Java Complete Reference #4", "Xyz#4"));
    // list.add(new Book(5, "Java Complete Reference #4", "Xyz#5"));

    // }

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id) {
        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b) {
        Book book = bookRepository.save(b);
        return book;
    }

    // delete book
    public void deleteBook(int id) {
        // list = list.stream().filter(book -> {
        // if (book.getId() != id) {
        // return true;
        // } else {
        // return false;
        // }
        // }).collect(Collectors.toList());

        bookRepository.deleteById(id);
    }

    // update the book
    public void updateBook(Book book, int bookId) {
        // list.stream().map(b -> {
        // if (b.getId() == bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        // }

        book.setId(bookId);
        bookRepository.save(book);

    }
}