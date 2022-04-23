package com.company.Controller;

import com.company.UserManager.UserManager;
import com.company.util.InputManager.InputManager;
import com.company.Library.LibraryOptions;

public class Controller {
    private final InputManager inputManager;
    private final LibraryOptions libraryOptions;
    private final UserManager authManager;

    public Controller(
            InputManager inputManager,
            LibraryOptions options,
            UserManager userManager
    ) {
        this.inputManager = inputManager;
        this.libraryOptions = options;
        this.authManager = userManager;
    }

    // startApplication -> main function of the application
    public void startApplication() {
        while (true) {
            boolean isExit = loginSection();
            if (isExit) {
                break;
            }
            if (authManager.getIsAuthenticated()) {
                libraryOptions.startListingOptions();
                authManager.logout();
            }
        }
    }

    private boolean loginSection() {
        String listing = """
                Welcome. Please make a selection.\s
                Your options:\s
                1. Login
                2. Register
                3. Exit
                To make the chose insert the number of the option.""";

        int selection = inputManager.getIntWithDescription(listing);

        switch (selection) {
            case 1 -> authManager.login();
            case 2 -> authManager.register();
            case 3 -> { return true; }
            default -> {}
        }
        return false;
    }
}
