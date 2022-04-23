package com.company.UserManager;

import com.company.util.InputManager.InputManager;

public class UserManagerImpl implements UserManager {

    private final InputManager inputManager;

    private int currentUserId = 0;
    public Boolean getIsAuthenticated() {
        return currentUserId != 0;
    }

    @Override
    public User getUser() {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).id == currentUserId) {
                return userList.get(i);
            }
        }
        return null;
    }

    @Override
    public void listUserBorrowedBooks() {
        getUser().listBorrowedBooks();
    }

    public UserManagerImpl(InputManager inputManager) {
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
                currentUserId = user.id;
                break;
            }
        }
        if (!loginSuccessful){
            System.out.println("Login failed!");
        }
    }

    @Override
    public void register() {
        String username = inputManager.getStringWithDescription("Enter new username: ");
        String password = inputManager.getStringWithDescription("Enter new password: ");
        User newUser = new User(username, password);
        userList.add(newUser);
        currentUserId = newUser.id;
    }

    @Override
    public void logout() {
        currentUserId = 0;
    }
}
