package com.company.AuthManager;

import java.util.ArrayList;

public interface AuthManager {

    ArrayList<User> userList = new ArrayList<>();

    // TODO isAuthenticated should be here

    void login();

    void register();

    void logout();

    Boolean getIsAuthenticated();

}
