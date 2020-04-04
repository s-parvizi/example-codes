package com.example.tddtest;

class StockManager {

    private ExternalIsbnDataService service;

    void setService(ExternalIsbnDataService service) {
        this.service = service;
    }

    String getLocatorCode(String isbn) {
        Book book = service.lookup(isbn);
        return isbn.substring(isbn.length() - 4) +
                book.getAuthor().substring(0, 1) +
                book.getTitle().split(" ").length;
    }
}
