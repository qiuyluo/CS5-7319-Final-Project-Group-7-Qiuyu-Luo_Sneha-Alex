package com.example.demo.entity;

import jakarta.persistence.*;


/**
 * @author LUO, QIUYU
 * @version 1.0
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String topic;
    private String coverImage;

    protected Book() {
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTopic() {
        return topic;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

}
