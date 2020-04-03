package com.example.tddtest;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsbnValidatorTest {

    @Test
    public void checkValid10DigitIsbn() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkIsbn("0140449116");

        // Junit
        assertTrue("test result", result);

        // assertj
        assertThat(result).isTrue();
    }

    @Test
    public void checkAValid13DigitIsbn() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkIsbn("9781853260087");

        assertTrue("test result", result);
    }

    @Test
    public void tenDigitIsbnNumberEndingInAnXIsValid() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkIsbn("012000030X");

        assertTrue("test result", result);
    }

    @Test
    public void checkAnInValid10DigitIsbn() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkIsbn("0140449117");

        assertFalse(result);
    }

    @Test
    public void checkAnInvalid13DigitISBN() {
        IsbnValidator validator = new IsbnValidator();
        boolean result = validator.checkIsbn("9781853267336");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitIsbnIsNotAllowed() {
        IsbnValidator validator = new IsbnValidator();
        validator.checkIsbn("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericIsbnIsNotAllowed() {
        IsbnValidator validator = new IsbnValidator();
        validator.checkIsbn("helloworld");
    }

}
