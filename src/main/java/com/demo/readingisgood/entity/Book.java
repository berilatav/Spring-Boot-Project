package com.demo.readingisgood.entity;

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
public class Book implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @Column
     private String name;
     @Column
     private String author;
     @Column
     private long quantity;
     @CreatedDate
     private LocalDateTime createdDate;
     @LastModifiedDate
     private LocalDateTime lastModifiedDate;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.LAZY)
     private List<Order> order;

}
