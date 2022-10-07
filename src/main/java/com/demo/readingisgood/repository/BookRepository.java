package com.demo.readingisgood.repository;

import com.demo.readingisgood.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByNameAndAuthor(String name,String author);
    List<Book> findAllByAuthor (String author);
}
