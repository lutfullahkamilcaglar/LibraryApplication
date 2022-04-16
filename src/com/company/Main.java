package com.company;

import com.company.AuthManager.AuthManager;
import com.company.AuthManager.AuthManagerImpl;
import com.company.Controller.Controller;
import com.company.InputManager.InputManager;
import com.company.InputManager.InputManagerImpl;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManagerImpl();
        Options options = new Options(inputManager);
        AuthManager authManager = new AuthManagerImpl(inputManager);

        Controller controller = new Controller(inputManager, options, authManager);
        controller.startApplication();
    }
}
