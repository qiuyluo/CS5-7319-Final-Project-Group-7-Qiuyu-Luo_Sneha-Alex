package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.List;


/**
 * @author LUO, QIUYU
 * @version 1.0
 */

public class Book {

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



    public Book(Long id, String title, String author, String genre, String topic) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.topic = topic;
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
