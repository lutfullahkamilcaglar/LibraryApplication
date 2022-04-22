package com.company.Library;

import com.company.util.InputManager.InputManager;

import java.util.ArrayList;


public class LibraryOptions {

    private final InputManager inputManager;
    private final ArrayList<Book> bookList = new ArrayList<>();

    public LibraryOptions(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    public void startListingOptions() {
        while (true) {
            boolean isLogOut = listOptions();
            if (isLogOut){
                break;
            }
        }
    }
// list all books da book category secenegi olarak degistir.
    private boolean listOptions() {
        String listing = """
                Welcome. Please make a chose.\s
                Your options:\s
                1. List all books 
                2. Add a book
                3. Delete a book
                4. Borrow a book
                5. Return a book
                6. Logout
                To make the chose insert the number of the option.""";
        int selection = inputManager.getIntWithDescription(listing);

        switch (selection) {
            case 1 -> listAllBooks();
            case 2 -> addBook();
            case 3 -> deleteBook();
            case 4 -> borrowBook();
            case 5 -> returnBook();
            case 6 -> System.out.println("Logged out");
            default -> System.out.println("There is no such options...");
        }

        return selection == 6;
    }

    void listAllBooks() {
        bookList.forEach(Book::listBookInfo);
    }

    void addBook() {
        String bookName = inputManager.getStringWithDescription("Input book name: ");
        int pageCount = inputManager.getIntWithDescription("Input book page count: ");
        Book newBook = new Book(bookName, pageCount);
        bookList.add(newBook);
        newBook.listBookInfo();
    }

    void deleteBook() {
        int bookId = inputManager.getIntWithDescription("Input book id to delete!");
        bookList.removeIf(book -> bookId == book.id);
        System.out.println("Book id: " + bookId + " has been deleted!");
        /*bookList.forEach(book -> {
                    if (bookId == book.id) {
                        bookList.remove(book);
                    }
                }
        );

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            // your code here
        }*/
    }

    void borrowBook() {
        System.out.println("You choose Borrow a book option" +
                "\nEnter the name of the book you want to borrow.");
        String brrwbook = inputManager.getString();
        System.out.println("You borrowed " + brrwbook + " Please return in 30 days.");
    }

    void returnBook() {
        System.out.println("You choose Return a book option " +
                "\nEnter the name of the book you want to return to you library.");
        String retrnbook = inputManager.getString();
        System.out.println(retrnbook + " has been returned to your library.");
    }

}


