package com.example.sairaasiainteriors.Models;

public class AddMemberModel {

    public String fullname, username, email;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddMemberModel() {
    }

    public AddMemberModel(String fullname, String username, String email) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
    }
}
