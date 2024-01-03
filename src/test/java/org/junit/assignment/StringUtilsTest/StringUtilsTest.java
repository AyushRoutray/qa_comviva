package org.junit.assignment.StringUtilsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.assignment.StringUtils.StringUtils;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        StringUtils utils = new StringUtils();

        // Test with a normal string
        assertEquals("olleh", utils.reverse("hello"));

        // Test with an empty string
        assertEquals("", utils.reverse(""));

        // Test with a string containing a single character
        assertEquals("a", utils.reverse("a"));
    }

    @Test
    public void testIsPalindrome() {
        StringUtils utils = new StringUtils();

        // Test with a palindrome
        assertTrue(utils.isPalindrome("radar"));

        // Test with a non-palindrome
        assertFalse(utils.isPalindrome("hello"));

        // Test with an empty string
        assertTrue(utils.isPalindrome(""));

        // Test with a single-character string
        assertTrue(utils.isPalindrome("a"));
    }

    @Test
    public void testConcatenate() {
        StringUtils utils = new StringUtils();

        // Test concatenation of two non-empty strings
        assertEquals("HelloWorld", utils.concatenate("Hello", "World"));

        // Test concatenation with an empty string
        assertEquals("Hello", utils.concatenate("Hello", ""));

        // Test concatenation with two empty strings
        assertEquals("", utils.concatenate("", ""));
    }

    @Test
    public void testCountOccurrences() {
        StringUtils utils = new StringUtils();

        // Test counting occurrences of a character in a non-empty string
        assertEquals(2, utils.countOccurrences("hello", 'l'));

        // Test counting occurrences of a character not present in the string
        assertEquals(0, utils.countOccurrences("hello", 'z'));

        // Test counting occurrences in an empty string
        assertEquals(0, utils.countOccurrences("", 'a'));

        // Test counting occurrences of a character in a string with a single character
        assertEquals(1, utils.countOccurrences("a", 'a'));
    }
    
    @Test
    public void testReverseEmptyString() {
        // Reversing an empty string should result in an empty string
        StringUtils utils = new StringUtils();
        assertEquals("", utils.reverse(""));
    }

    @Test
    public void testIsPalindromeEmptyString() {
        // An empty string is a palindrome
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome(""));
    }

    @Test
    public void testConcatenateEmptyStrings() {
        // Concatenating two empty strings should result in an empty string
        StringUtils utils = new StringUtils();
        assertEquals("", utils.concatenate("", ""));
    }

    @Test
    public void testCountOccurrencesEmptyString() {
        // Counting occurrences of a character in an empty string should be zero
        StringUtils utils = new StringUtils();
        assertEquals(0, utils.countOccurrences("", 'a'));
    }

    @Test
    public void testReverseSingleCharacterString() {
        // Reversing a single-character string should result in the same character
        StringUtils utils = new StringUtils();
        assertEquals("a", utils.reverse("a"));
    }

    @Test
    public void testIsPalindromeSingleCharacterString() {
        // A single-character string is a palindrome
        StringUtils utils = new StringUtils();
        assertTrue(utils.isPalindrome("a"));
    }

    @Test
    public void testConcatenateWithNull() {
        // Concatenating a string with null should result in the non-null string
        StringUtils utils = new StringUtils();
        assertEquals("Hellonull", utils.concatenate("Hello", null));
    }

    @Test
    public void testCountOccurrencesNoMatch() {
        // Counting occurrences of a character not present in the string should be zero
        StringUtils utils = new StringUtils();
        assertEquals(0, utils.countOccurrences("hello", 'z'));
    }

    @Test
    public void testCountOccurrencesMultipleMatches() {
        // Counting occurrences of a character with multiple matches
        StringUtils utils = new StringUtils();
        assertEquals(3, utils.countOccurrences("hello world", 'l'));
    }

    @Test
    public void testCountOccurrencesCaseInsensitive() {
        // Counting occurrences of a character in a case-insensitive manner
        StringUtils utils = new StringUtils();
        assertEquals(0, utils.countOccurrences("Hello world", 'h'));
    }
}
