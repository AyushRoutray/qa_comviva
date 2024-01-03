package org.junit.assignment.LibraryTest;

import org.junit.Test;
import org.junit.assignment.Library.Book;
import org.junit.assignment.Library.LibraryCatalog;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        catalog.addBook(book);

        assertTrue(catalog.getBooks().contains(book));
    }

    @Test
    public void testBorrowBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("To Kill a Mockingbird", "Harper Lee");
        catalog.addBook(book);

        assertTrue(book.isAvailable());
        catalog.borrowBook("To Kill a Mockingbird");
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("1984", "George Orwell");
        catalog.addBook(book);

        book.setAvailable(false);
        assertFalse(book.isAvailable());
        catalog.returnBook("1984");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testGetBooks() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book("Brave New World", "Aldous Huxley");

        catalog.addBook(book1);
        catalog.addBook(book2);

        assertEquals(2, catalog.getBooks().size());
        assertTrue(catalog.getBooks().contains(book1));
        assertTrue(catalog.getBooks().contains(book2));
    }

    @Test
    public void testAddAndBorrowBook() {
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("Animal Farm", "George Orwell");

        catalog.addBook(book);
        assertTrue(book.isAvailable());

        catalog.borrowBook("Animal Farm");
        assertFalse(book.isAvailable());
    }
    
    @Test
    public void testBorrowNonexistentBook() {
        // Attempting to borrow a book that doesn't exist in the catalog should do nothing
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.borrowBook("Nonexistent Book");
        assertTrue(catalog.getBooks().isEmpty());
    }

    @Test
    public void testReturnNonexistentBook() {
        // Attempting to return a book that doesn't exist in the catalog should do nothing
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.returnBook("Nonexistent Book");
        assertTrue(catalog.getBooks().isEmpty());
    }

    @Test
    public void testReturnBorrowedBook() {
        // Borrow a book, return it, and ensure it is marked as available again
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Hobbit", "J.R.R. Tolkien");
        catalog.addBook(book);

        catalog.borrowBook("The Hobbit");
        assertFalse(book.isAvailable());

        catalog.returnBook("The Hobbit");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowBookTwice() {
        // Borrowing a book twice without returning it in between should not affect its availability
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("Dune", "Frank Herbert");
        catalog.addBook(book);

        catalog.borrowBook("Dune");
        assertFalse(book.isAvailable());

        catalog.borrowBook("Dune");
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBookTwice() {
        // Returning a book twice without borrowing it in between should not affect its availability
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Catcher in the Rye", "J.D. Salinger");
        catalog.addBook(book);

        catalog.returnBook("The Catcher in the Rye");
        assertTrue(book.isAvailable());

        catalog.returnBook("The Catcher in the Rye");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testAddAndBorrowMultipleBooks() {
        // Add multiple books, borrow one, and ensure the correct book is marked as unavailable
        LibraryCatalog catalog = new LibraryCatalog();
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Brave New World", "Aldous Huxley");
        Book book3 = new Book("Fahrenheit 451", "Ray Bradbury");

        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        catalog.borrowBook("Brave New World");
        assertFalse(book2.isAvailable());
        assertTrue(book1.isAvailable());
        assertTrue(book3.isAvailable());
    }
    
    @Test
    public void testAddNullBook() {
        // Adding a null book to the catalog should not affect the existing books
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = null;

        catalog.addBook(book);

        assertFalse(catalog.getBooks().isEmpty());
    }

    @Test
    public void testBorrowBookAndCheckCatalog() {
        // Borrow a book and check if the catalog reflects the correct availability status
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        catalog.addBook(book);

        assertTrue(book.isAvailable());
        catalog.borrowBook("The Lord of the Rings");
        assertFalse(book.isAvailable());
    }

    @Test
    public void testReturnBookAndCheckCatalog() {
        // Return a book and check if the catalog reflects the correct availability status
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        catalog.addBook(book);

        catalog.borrowBook("The Great Gatsby");
        assertFalse(book.isAvailable());
        catalog.returnBook("The Great Gatsby");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testReturnNonBorrowedBook() {
        // Returning a book that has not been borrowed should not affect its availability
        LibraryCatalog catalog = new LibraryCatalog();
        Book book = new Book("The Cat in the Hat", "Dr. Seuss");
        catalog.addBook(book);

        assertTrue(book.isAvailable());
        catalog.returnBook("The Cat in the Hat");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowAndReturnMultipleBooks() {
        // Borrow multiple books, return one, and ensure the correct book is marked as available
        LibraryCatalog catalog = new LibraryCatalog();
        Book book1 = new Book("Pride and Prejudice", "Jane Austen");
        Book book2 = new Book("The Alchemist", "Paulo Coelho");
        Book book3 = new Book("The Da Vinci Code", "Dan Brown");

        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        catalog.borrowBook("Pride and Prejudice");
        catalog.borrowBook("The Alchemist");
        catalog.returnBook("The Alchemist");

        assertFalse(book1.isAvailable());
        assertTrue(book2.isAvailable());
        assertTrue(book3.isAvailable());
    }
}