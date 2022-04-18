package com.company.Library;

import java.util.Random;

public class Book {

    int id;
    String name;
    int pageCount;

    public Book(String name, int pageCount) {
        this.name = name;
        this.pageCount = pageCount;
        this.id = generateId();
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
                """, this.id, this.name, this.pageCount);
        System.out.println(info);
    }
}

