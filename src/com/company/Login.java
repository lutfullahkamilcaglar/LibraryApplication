package com.company;

import com.company.util.InputManager.InputManager;

public class Login {

    private final InputManager inputManager;

    public Login(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    void login() {


        int attempts = 3;

        String userName = "Kamil";
        String password = "123456";

        System.out.println("Welcome to library.");


        while (true) {
            System.out.print("Username : ");
            String username = inputManager.getString();
            System.out.print("Password : ");
            String passwd = inputManager.getString();

            if (username.equals(userName) && passwd.equals(password)) {
                System.out.println("Welcome " + username);
                break;
            }
            else if (username.equals(userName) && !passwd.equals(password)) {

                System.out.println("Wrong password...");
                attempts -= 1;

                System.out.println("com.company.Login attempts : " + attempts);


            }
            else if (!username.equals(userName) && passwd.equals(password)) {

                System.out.println("Wrong username...");
                attempts -= 1;
                System.out.println("Attempts : " + attempts);


            }
            else {
                System.out.println("Wrong username and password...");

                attempts -= 1;
                System.out.println("Attempts : " + attempts);


            }
            if (attempts == 0){

                System.out.println("3 wrong attempts. Try again.");
                break;
            }
        }
    }
}