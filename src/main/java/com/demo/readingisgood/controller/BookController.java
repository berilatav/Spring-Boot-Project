package com.demo.readingisgood.controller;

import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.dto.BookDto;
import com.demo.readingisgood.request.CreatingBookRequest;
import com.demo.readingisgood.request.UpdatingBookRequest;
import com.demo.readingisgood.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Tag(name = "Book API Documentation")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @Operation(summary = "New Book Adding Method")
    public void createBook(@RequestBody CreatingBookRequest creatingBookRequest) {
        bookService.createBook(creatingBookRequest);
    }

    @PutMapping
    @Operation(summary = "Book Updating Method")
    public void updateBook(@RequestBody UpdatingBookRequest updatingBookRequest) throws Exception {
        bookService.updateBook(updatingBookRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Book Deleting Method")
    public void deleteBook(@PathVariable long id) throws Exception {
        bookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = " Book With Id Method")
    public ResponseEntity<Book> getBook(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping("/list")
    @Operation(summary = "Create Book List Method")
    public void createBooks(@RequestBody List<CreatingBookRequest> creatingBookRequest) {
        bookService.createBooks(creatingBookRequest);
    }

    @PutMapping("/update-list")
    @Operation(summary = "UpdateBook List Method")
    public void updateBooks(@RequestBody List<UpdatingBookRequest> updatingBookRequest) throws Exception{
        bookService.updateBooks(updatingBookRequest);
    }

    @GetMapping("/by-name")
    @Operation(summary = "BookByAuthorName Method")
    public List<BookDto> getBookByAuthorName(@RequestParam String authorName){
        return bookService.getBookByAuthor(authorName);
    }

    @GetMapping("/all-book-list")
    @Operation(summary = " All Book List Method")
    public List<BookDto> getAll() throws Exception{
        return bookService.getAll();
    }

}



