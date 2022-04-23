package com.company;

import com.company.UserManager.UserManager;
import com.company.UserManager.UserManagerImpl;
import com.company.Controller.Controller;
import com.company.util.InputManager.InputManager;
import com.company.util.InputManager.InputManagerImpl;
import com.company.Library.LibraryOptions;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManagerImpl();
        UserManager authManager = new UserManagerImpl(inputManager);
        LibraryOptions options = new LibraryOptions(inputManager, authManager);

        Controller controller = new Controller(inputManager, options, authManager);
        controller.startApplication();
    }
}
