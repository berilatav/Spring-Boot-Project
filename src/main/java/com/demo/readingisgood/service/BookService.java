package com.demo.readingisgood.service;

import com.demo.readingisgood.entity.Book;
import com.demo.readingisgood.entity.dto.BookDto;
import com.demo.readingisgood.request.CreatingBookRequest;
import com.demo.readingisgood.request.UpdatingBookRequest;


import java.util.List;


public interface BookService {

    void createBook(CreatingBookRequest creatingBookRequest);

    void updateBook(UpdatingBookRequest updatingBookRequest) throws Exception;

    void deleteBook(long id) throws Exception;

    Book getById(long id) throws Exception;

    void createBooks(List<CreatingBookRequest> creatingBookRequest);

    void updateBooks(List<UpdatingBookRequest> updatingBookRequest) throws Exception;

    List<BookDto> getBookByAuthor (String authorName);

    List<BookDto> getAll() throws Exception;

}