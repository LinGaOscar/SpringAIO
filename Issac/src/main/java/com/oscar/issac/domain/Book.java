package com.oscar.issac.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String author;
    private String description;
    private String name;
    private Integer status;
}