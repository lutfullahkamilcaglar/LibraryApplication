package com.company.AuthManager;

import com.company.util.InputManager.InputManager;

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
        User userInput = new User(username, password);
        boolean loginSuccessful = false;
        for (User user : userList) {
            if (user.checkCredentials(userInput)){
                loginSuccessful = true;
                break;
            }
        }
        if (loginSuccessful){
            isAuthenticated = true;
        } else {
            System.out.println("Login failed!");
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
