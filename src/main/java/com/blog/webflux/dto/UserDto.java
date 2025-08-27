package com.blog.webflux.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {

    private String userId;

    @NotBlank(message = "Username cannot be blank")
    private String userName;

    @Email(message = "Invalid email format")
    private String userEmailID;

    @NotBlank(message = "Password cannot be blank")
    private String userPassword;

    private String role;

    public UserDto() {}

    public UserDto(String userId, String userName, String userEmailID, String userPassword, String role) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailID = userEmailID;
        this.userPassword = userPassword;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailID() {
        return userEmailID;
    }

    public void setUserEmailID(String userEmailID) {
        this.userEmailID = userEmailID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmailID='" + userEmailID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}