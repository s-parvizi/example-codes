package com.example.tddtest;

public class Book {

    private String isbn;
    private String title;
    private String author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }
}
