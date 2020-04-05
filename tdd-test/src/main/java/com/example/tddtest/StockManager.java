package com.example.tddtest;

class StockManager {

    private ExternalIsbnDataService webService;
    private ExternalIsbnDataService databaseService;

    void setWebService(ExternalIsbnDataService webService) {
        this.webService = webService;
    }

    public void setDatabaseService(ExternalIsbnDataService databaseService) {
        this.databaseService = databaseService;
    }

    String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        if (book == null) {
            book = webService.lookup(isbn);
        }
        return isbn.substring(isbn.length() - 4) +
                book.getAuthor().substring(0, 1) +
                book.getTitle().split(" ").length;
    }
}
