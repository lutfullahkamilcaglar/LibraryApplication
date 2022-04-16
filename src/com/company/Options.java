package com.company;

import com.company.InputManager.InputManager;


public class Options {

    private final InputManager inputManager;

    public Options(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public void listOptions() {
        String listing = """
                Welcome. Please make a chose.\s
                Your options:\s
                1. Add a book
                2. Return a book
                3. Delete a book
                4. Borrow a book
                To make the chose insert the number of the option.""";
        System.out.println(listing);

        int selection = inputManager.getInt();

        switch (selection) {
            case 1 -> addBook();
            case 2 -> returnBook();
            case 3 -> deleteBook();
            case 4 -> borrowBook();
            default -> System.out.println("There is no such options...");
        }
    }

    void addBook() {
        System.out.println("You choose Add book option " +
                "\nEnter the name of the book you want to add in your library.");
        String book = inputManager.getString();
        System.out.println(book + " has been added to your library.");
    }

    void returnBook() {
        System.out.println("You choose Return a book option " +
                "\nEnter the name of the book you want to return to you library.");
        String retrnbook = inputManager.getString();
        System.out.println(retrnbook + " has been returned to your library.");
    }

    void deleteBook() {
        System.out.println("You choose Delete a book option" +
                " \nEnter the name of the book you want to delete.");
        String dltbook = inputManager.getString();
        System.out.println(dltbook + " has been deleted.");
    }

    void borrowBook() {
        System.out.println("You choose Borrow a book option" +
                "\nEnter the name of the book you want to borrow.");
        String brrwbook = inputManager.getString();
        System.out.println("You borrowed " + brrwbook + " Please return in 30 days.");
    }
}


