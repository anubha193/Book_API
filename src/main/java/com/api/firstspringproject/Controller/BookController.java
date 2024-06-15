package com.api.firstspringproject.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.firstspringproject.bookservices.BookServices;
import com.api.firstspringproject.entities.Books;

@RestController
public class BookController {
    @Autowired
    private BookServices bookServices;

    @GetMapping("/books")
    public ResponseEntity<ArrayList<Books>> getBooks() {
        ArrayList al=bookServices.getAllBooks();
        if(al.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(al));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBook(@PathVariable("id") int id) {
        Books bk= this.bookServices.getBookById(id);
        if(bk==null)
        {
            System.out.println("ok");
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bk));
    }

    @GetMapping("/boos/{name}")
    public Books handler(@PathVariable("name") String name) {
        return bookServices.getBookByName(name);
    }

    @PostMapping("/books")
    public Books handle(@RequestBody Books book) {
        return this.bookServices.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    public Books handler2(@PathVariable("id") int id) {
        return this.bookServices.deleteById(id);
    }

    // updating book object
    @PutMapping("/books/{id}")
    public Books handler3(@RequestBody Books book, @PathVariable("id") int id) {
         this.bookServices.updateBooks(book, id);
         return book;
    }

}
