package com.company.UserManager;

import java.util.ArrayList;

public interface UserManager {

    ArrayList<User> userList = new ArrayList<>();

    // TODO isAuthenticated should be here

    void login();

    void register();

    void logout();

    Boolean getIsAuthenticated();

    User getUser();

    void listUserBorrowedBooks();
}
