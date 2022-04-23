package com.company.UserManager;

import com.company.Library.Book;

import java.util.ArrayList;
import java.util.Random;

public class User {

    int id;
    private final String username;
    private final String password;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void listBorrowedBooks() {
        borrowedBooks.forEach(Book::listBookInfo);
    }

    public void addOrReturnBooks(Book book, boolean isBorrow) {
        if (isBorrow){
            borrowedBooks.add(book);
        } else {
            borrowedBooks.remove(book);
        }
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = generateId();
    }

    private int generateId() {
        Random random = new Random();
        return random.nextInt(1000 - 100) + 100;
    }

    public boolean checkCredentials(User user) {
        return user.username.equals(this.username) && user.password.equals(this.password);
    }
}
