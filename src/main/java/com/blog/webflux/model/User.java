package com.blog.webflux.model;

import jakarta.validation.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String userName;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String userEmailID;

    private String userPassword;
    private String role;

    public User() {}

    public User(String userId, String userName, String userEmailID, String userPassword, String role) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailID = userEmailID;
        this.userPassword = userPassword;
        this.role = role;
    }

    // Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserEmailID() { return userEmailID; }
    public void setUserEmailID(String userEmailID) { this.userEmailID = userEmailID; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmailID='" + userEmailID + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}