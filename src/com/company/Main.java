package com.company;

import com.company.AuthManager.AuthManager;
import com.company.AuthManager.AuthManagerImpl;
import com.company.Controller.Controller;
import com.company.util.InputManager.InputManager;
import com.company.util.InputManager.InputManagerImpl;
import com.company.Library.LibraryOptions;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManagerImpl();
        LibraryOptions options = new LibraryOptions(inputManager);
        AuthManager authManager = new AuthManagerImpl(inputManager);

        Controller controller = new Controller(inputManager, options, authManager);
        controller.startApplication();
    }
}
