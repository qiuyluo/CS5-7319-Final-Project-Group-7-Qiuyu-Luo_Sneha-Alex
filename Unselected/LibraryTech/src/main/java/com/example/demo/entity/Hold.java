package com.example.demo.entity;

import java.util.Date;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

public class Hold {

    private Long id;
    private User user;
    private Book book;
    private Date holdDate;    // Date when the hold was placed
    private boolean isReadyToPickup;

    public Hold() {
    }


    public Hold(Long id, User user, Book book, Date holdDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.holdDate = holdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(Date holdDate) {
        this.holdDate = holdDate;
    }

    public boolean isReadyToPickup() {
        return isReadyToPickup;
    }

    public void setReadyToPickup(boolean readyToPickup) {
        isReadyToPickup = readyToPickup;
    }
}
