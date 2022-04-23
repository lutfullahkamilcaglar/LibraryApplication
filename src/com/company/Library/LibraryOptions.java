package com.company.Library;

import com.company.UserManager.UserManager;
import com.company.util.InputManager.InputManager;

import java.util.ArrayList;


public class LibraryOptions {

    private final InputManager inputManager;
    private final UserManager userManager;
    private final ArrayList<Book> bookList = new ArrayList<>();

    public LibraryOptions(InputManager inputManager, UserManager userManager) {
        this.inputManager = inputManager;
        this.userManager = userManager;
    }

    public void startListingOptions() {
        while (true) {
            boolean isLogOut = listOptions();
            if (isLogOut) {
                break;
            }
        }
    }

    // list all books da book category secenegi olarak degistir.
    private boolean listOptions() {
        String listing = """
                Welcome. Please make a chose.
                Your options:
                1. List all books
                2. Add a book
                3. Delete a book
                4. Borrow a book
                5. Return a book
                6. List borrowed books
                7. Logout
                To make the chose insert the number of the option.
                """;
        int selection = inputManager.getIntWithDescription(listing);
        boolean isLoggedOut = false;

        switch (selection) {
            case 1 -> listAllBooks();
            case 2 -> addBook();
            case 3 -> deleteBook();
            case 4 -> borrowBook();
            case 5 -> returnBook();
            case 6 -> listBorrowedBooks();
            case 7 -> {
                isLoggedOut = true;
                System.out.println("Logged out");
            }
            default -> System.out.println("There is no such options...");
        }

        return isLoggedOut;
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
        bookList.removeIf(book -> bookId == book.getId());
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

    void listBorrowedBooks() {
        userManager.listUserBorrowedBooks();
    }
    void borrowBook() {
        int bookId = inputManager.getIntWithDescription("Input book id to borrow!");
        bookList.forEach( book -> {
            if(bookId == book.getId()) {
                book.setBorrowed(true);
                userManager.getUser().addOrReturnBooks(book, true);
            }
        });
    }

    void returnBook() {
        int bookId = inputManager.getIntWithDescription("Input book id to return!");
        bookList.forEach( book -> {
            if(bookId == book.getId()) {
                book.setBorrowed(false);
                userManager.getUser().addOrReturnBooks(book, false);
            }
        });
    }

}


