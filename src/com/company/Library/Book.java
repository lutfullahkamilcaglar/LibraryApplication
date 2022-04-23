package com.company.Library;

import java.util.Random;

public class Book {

    private final int id;
    private final String name;
    private final int pageCount;
    private boolean isBorrowed;

    public int getId() {
        return id;
    }

    public Book(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
        this.id = generateId();
        this.isBorrowed = false;
    }

    private int generateId() {
        Random random = new Random();
        return random.nextInt(1000 - 100) + 100;
    }

    public void listBookInfo() {
        String info = String.format("""
                Book:
                id: %d
                name: %s
                page count: %d
                is it borrowed: %b
                """, this.id, this.name, this.pageCount, this.isBorrowed);
        System.out.println(info);
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

