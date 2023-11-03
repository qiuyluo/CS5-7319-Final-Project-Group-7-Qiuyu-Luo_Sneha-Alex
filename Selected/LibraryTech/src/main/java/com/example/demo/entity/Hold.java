package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */
@Entity
@Table(name = "holds")
public class Hold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Date holdDate;    // Date when the hold was placed
    private boolean isReadyToPickup;

    public Hold() {
    }


    public Hold(User user, Book book) {
        this.user = user;
        this.book = book;
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
