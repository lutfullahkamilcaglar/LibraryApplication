package com.company.Library;

import com.company.util.InputManager.InputManager;

public class BookCategories {
    private InputManager inputManager;

    String categories = "Welcome please choose a category:\s" +
            "1. Poetry" +
            "2. Drama " +
            "3. History " +
            "4. Fiction";


    int category = inputManager.getIntWithDescription(categories);

    public void BookCategories() {
        switch (category) {
            case 1 -> poetry();
            case 2 -> drama();
            case 3 -> history();
            case 4 -> fiction();
            default -> System.out.println("Invalid input.");
        }
    }

    void poetry() {

    }

    void drama() {

    }

    void history() {

    }

    void fiction() {

    }

}
