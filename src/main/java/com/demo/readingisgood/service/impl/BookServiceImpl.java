package com.demo.readingisgood.service.impl;

import com.demo.readingisgood.configuration.EnumMessages;
import com.demo.readingisgood.configuration.RestApiException;
import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.dto.BookDto;
import com.demo.readingisgood.repository.BookRepository;
import com.demo.readingisgood.request.CreatingBookRequest;
import com.demo.readingisgood.request.UpdatingBookRequest;
import com.demo.readingisgood.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.demo.readingisgood.configuration.RedisConfiguration.CACHE_METHOD;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;


    public void createBook(CreatingBookRequest creatingBookRequest) {

        Optional<Book> book = bookRepository.findByNameAndAuthor(creatingBookRequest.getName(), creatingBookRequest.getAuthor());
        if (book.isPresent()) {
            throw new RestApiException(EnumMessages.DUPLICATE_BOOK_ERROR);
        }
        else {
            Book createBook = new Book();
            createBook.setName(creatingBookRequest.getName());
            createBook.setAuthor(creatingBookRequest.getAuthor());
            createBook.setQuantity(creatingBookRequest.getQuantity());

            bookRepository.save(createBook);
        }
    }

    public void updateBook(UpdatingBookRequest updatingBookRequest) throws Exception {
        Book updateBook = bookRepository.findById(updatingBookRequest.getId())
                .orElseThrow(() -> new Exception("Book not exist with id: " + updatingBookRequest.getId()));
        if (updatingBookRequest.getName().equals(updateBook.getName()) &&
                updatingBookRequest.getAuthor().equals(updateBook.getAuthor()) && updatingBookRequest.getQuantity()==(updateBook.getQuantity())) {
            throw new RestApiException(EnumMessages.BOOK_ATTRIBUTED_SAME);
        }

        updateBook.setId(updatingBookRequest.getId());
        updateBook.setAuthor(updatingBookRequest.getAuthor());
        updateBook.setQuantity(updatingBookRequest.getQuantity());

        bookRepository.save(updateBook);
    }

    public void deleteBook(long id) throws Exception {


        Book deleteBook = bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book not found with id: " + id));
        bookRepository.delete(deleteBook);
    }

    public Book getById(long id) throws Exception {
        return bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book not found with id: " + id));
    }

    public void createBooks(List<CreatingBookRequest> creatingBookRequest) {
        for (CreatingBookRequest book : creatingBookRequest) {
            Book newBook = new Book();
            newBook.setName(book.getName());
            newBook.setAuthor(book.getAuthor());
            newBook.setQuantity(book.getQuantity());
            bookRepository.save(newBook);
        }
    }

    public void updateBooks(List<UpdatingBookRequest> updatingBookRequest) throws Exception {
        List<Long> notUpdatedBooks = new ArrayList<>();
        for (UpdatingBookRequest book : updatingBookRequest) {
            try {
                updateBook(book);

            } catch (Exception e) {

                notUpdatedBooks.add(book.getId());
            }
        }

        if (notUpdatedBooks != null) {
            String notUpdatedBooksString = notUpdatedBooks.stream().map(String::valueOf).collect(Collectors.joining(","));
            throw new Exception("The books with this" + notUpdatedBooks + "could not be updated.");
        }
    }
        @Cacheable(value=CACHE_METHOD, key="#authorName")
        public List<BookDto> getBookByAuthor (String authorName) {
            List<Book> bookList = bookRepository.findAllByAuthor(authorName);
            return bookList
                    .stream()
                    .map(book -> BookDto.builder()
                            .id(book.getId())
                            .author(book.getAuthor())
                            .name(book.getName())
                            .quantity(book.getQuantity())
                            .build())
                            .collect(Collectors.toList());
        }

        // TODO Bu methodu dto şeklinde yaz ve map, stream
        public List<BookDto> getAll() throws Exception {
            List<Book> bookList = bookRepository.findAll();
            if (bookList.isEmpty()) {
                throw new Exception("There is no current book list.");
            }
           return bookList
            .stream()
                    .map(book -> BookDto.builder()
                            .id(book.getId())
                            .author(book.getAuthor())
                            .name(book.getName())
                            .quantity(book.getQuantity())
                            .build())
                    .collect(Collectors.toList());
        }

}

















