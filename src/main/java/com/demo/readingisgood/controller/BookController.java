package com.demo.readingisgood.controller;

import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.Customer;
import com.demo.readingisgood.request.CreatingBookRequest;
import com.demo.readingisgood.request.UpdatingBookRequest;
import com.demo.readingisgood.service.BookService;
import com.demo.readingisgood.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public void createBook(@RequestBody CreatingBookRequest creatingBookRequest) {
        bookService.createBook(creatingBookRequest);
    }

    @PutMapping
    public void updateBook(@RequestBody UpdatingBookRequest updatingBookRequest) throws Exception {
        bookService.updateBook(updatingBookRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) throws Exception {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping("/list")
    public void createBooks(@RequestBody List<CreatingBookRequest> creatingBookRequest) {
        bookService.createBooks(creatingBookRequest);
    }

    @PutMapping("/update-list")
    public void updateBooks(@RequestBody List<UpdatingBookRequest> updatingBookRequest) throws Exception{
        bookService.updateBooks(updatingBookRequest);
    }
}



