package com.example.tddtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockManagementTest {

    // Stub (without using Mockito) : Used to test data
    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalIsbnDataService testWebService = new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "of Mice and Men", "J. Steinbeck");
            }
        };

        ExternalIsbnDataService testDatabaseService = new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {

                return null;
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        stockManager.setDatabaseService(testDatabaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    // Stub (with Mockito) : Used to test data
    @Test
    public void testCanGetACorrectLocatorCodeWithMockito() {
        ExternalIsbnDataService databaseService = mock(ExternalIsbnDataService.class);
        ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);

        when(webService.lookup(anyString())).
                thenReturn(new Book("0140177396", "of Mice and Men", "J. Steinbeck"));
        when(databaseService.lookup(anyString())).thenReturn(null);

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    // Mock : Used to test behaviour
    @Test
    public void databaseIsUsedIfDataIsPresent() {
        ExternalIsbnDataService databaseService = mock(ExternalIsbnDataService.class);
        ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);

        when(databaseService.lookup("0140177396")).
                thenReturn(new Book("0140177396", "abc", "abc"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService).lookup("0140177396");
        verify(webService, never()).lookup(anyString());
    }

    // Mock : Used to test behaviour
    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        ExternalIsbnDataService databaseService = mock(ExternalIsbnDataService.class);
        ExternalIsbnDataService webService = mock(ExternalIsbnDataService.class);

        when(databaseService.lookup("0140177396")).thenReturn(null);
        when(webService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(databaseService).lookup("0140177396");
        verify(webService).lookup("0140177396");
    }

}
