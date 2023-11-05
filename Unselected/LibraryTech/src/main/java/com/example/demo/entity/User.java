package com.example.demo.entity;


/**
 * @author LUO, QIUYU
 * @version 1.0
 */
public class User {

    private Long id;
    private String userId;  // Unique user ID
    private String password;
    private String role;    // "USER" or "LIBRARIAN"

    protected User() {
    }

    public User(Long id, String userId, String password, String role) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
