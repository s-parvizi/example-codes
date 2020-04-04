package com.example.tddtest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockManagementTest {

    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalIsbnDataService testService = new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "of Mice and Men", "J. Steinbeck");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(testService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }
}
