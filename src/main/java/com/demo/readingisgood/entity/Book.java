package com.demo.readingisgood.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Entity
@Table
@Schema(name = "Book Api Model Documentation", description = "Model")
public class Book implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Schema(name = "Unique id field of book object")
     private long id;

     @Column
     @Schema(name = "Name field of book object")
     private String name;

     @Column
     @Schema(name = "Author field of book object")
     private String author;

     @Column
     @Schema(name = "Quantity field of book object")
     private long quantity;

     @CreatedDate
     @Schema(name = "CreatedDate field of book object")
     private LocalDateTime createdDate;

     @LastModifiedDate
     @Schema(name = "LastModifiedDate field of book object")
     private LocalDateTime lastModifiedDate;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.LAZY)
     private List<Order> order;


}
