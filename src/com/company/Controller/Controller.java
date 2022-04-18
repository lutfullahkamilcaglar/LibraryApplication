package com.company.Controller;

import com.company.AuthManager.AuthManager;
import com.company.util.InputManager.InputManager;
import com.company.Library.LibraryOptions;

public class Controller {
    private InputManager inputManager;
    private LibraryOptions libraryOptions;
    private AuthManager authManager;

    public Controller(InputManager inputManager, LibraryOptions options, AuthManager authManager) {
        this.inputManager = inputManager;
        this.libraryOptions = options;
        this.authManager = authManager;
    }

    public void startApplication() {
        while (true) {
            loginSection();
            if (authManager.getIsAuthenticated()){
                libraryOptions.startListingOptions();
                authManager.logout();
            }
        }
    }


    private void loginSection() {
        String listing = """
                Welcome. Please make a selection.\s
                Your options:\s
                1. Login
                2. Register
                To make the chose insert the number of the option.""";

        int selection = inputManager.getIntWithDescription(listing);

        if (selection == 1){
            authManager.login();
        } else if (selection == 2) {
            authManager.register();
        }
    }
}
