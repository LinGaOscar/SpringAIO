package com.oscar.nicholas.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "book2")
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String author;
    private String description;
    private String name;
    private Integer status;
}