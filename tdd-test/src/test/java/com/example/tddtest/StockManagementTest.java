package com.example.tddtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StockManagementTest {

    private ExternalIsbnDataService testWebService;
    private StockManager stockManager;
    private ExternalIsbnDataService testDatabaseService;

    @Before
    public void setup() {
        testWebService = mock(ExternalIsbnDataService.class);
        stockManager = new StockManager();
        stockManager.setWebService(testWebService);
        testDatabaseService = mock(ExternalIsbnDataService.class);
        stockManager.setDatabaseService(testDatabaseService);
    }

    // Stub (without using Mockito) : Used to test data
    // just for learning
    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalIsbnDataService webService = new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "of Mice and Men", "J. Steinbeck");
            }
        };

        ExternalIsbnDataService databaseService = new ExternalIsbnDataService() {
            @Override
            public Book lookup(String isbn) {

                return null;
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    // Stub (with Mockito) : Used to test data
    @Test
    public void testCanGetACorrectLocatorCodeWithMockito() {
        when(testWebService.lookup(anyString())).
                thenReturn(new Book("0140177396", "of Mice and Men", "J. Steinbeck"));
        when(testDatabaseService.lookup(anyString())).thenReturn(null);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    // Mock : Used to test behaviour
    @Test
    public void databaseIsUsedIfDataIsPresent() {
        when(testDatabaseService.lookup("0140177396")).
                thenReturn(new Book("0140177396", "abc", "abc"));

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(testDatabaseService).lookup("0140177396");
        verify(testWebService, never()).lookup(anyString());
    }

    // Mock : Used to test behaviour
    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        when(testDatabaseService.lookup("0140177396")).thenReturn(null);
        when(testWebService.lookup("0140177396")).thenReturn(new Book("0140177396", "abc", "abc"));

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);

        verify(testDatabaseService).lookup("0140177396");
        verify(testWebService).lookup("0140177396");
    }

}
