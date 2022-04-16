package com.company.Controller;

import com.company.AuthManager.AuthManager;
import com.company.InputManager.InputManager;
import com.company.Options;

public class Controller {
    private InputManager inputManager;
    private Options options;
    private AuthManager authManager;

    public Controller(InputManager inputManager, Options options, AuthManager authManager) {
        this.inputManager = inputManager;
        this.options = options;
        this.authManager = authManager;
    }

    public void startApplication() {
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
