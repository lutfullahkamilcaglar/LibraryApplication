package com.company.AuthManager;

import com.company.InputManager.InputManager;

public class AuthManagerImpl implements AuthManager {

    private final InputManager inputManager;

    private Boolean isAuthenticated = false;

    public Boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    public AuthManagerImpl(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public void login() {
        String username = inputManager.getStringWithDescription("Enter your username: ");
        String password = inputManager.getStringWithDescription("Enter your password: ");
        User user = new User(username, password);
        boolean loginSuccessful = userList.contains(user);
        if (loginSuccessful){
            isAuthenticated = true;
        }
    }

    @Override
    public void register() {
        String username = inputManager.getStringWithDescription("Enter new username: ");
        String password = inputManager.getStringWithDescription("Enter new password: ");
        User newUser = new User(username, password);
        userList.add(newUser);
        isAuthenticated = true;
    }

    @Override
    public void logout() {
        isAuthenticated = false;
    }
}
