package com.company.AuthManager;

public class User {

    String username;
    String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkCredentials(User user) {
        return user.username.equals(this.username) && user.password.equals(this.password);
    }
}
