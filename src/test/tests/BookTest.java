package tests;

import org.junit.Test;
import serialization.Book;
import serialization.Chapter;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void createWIthNegativePage() throws Exception {
        Book book = new Book((short)-10, "The Book", "Me");
        assertEquals((short)0, book.getPageCount());
    }
    @Test
    public void equalsEmpty() throws Exception {
        Book book = new Book();
        Book bookSame = new Book();
        assertEquals(true, book.equals(bookSame));
    }
    @Test
    public void equals() throws Exception {
        Book book = new Book((short)914, "The Book", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));}});
        Book bookSame = new Book((short)914, "The Book", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));}});
        assertEquals(true, book.equals(bookSame));
    }
    @Test
    public void notEquals() throws Exception {
        Book book = new Book((short)914, "The Book", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));}});
        Book bookNotSame = new Book((short)914, "The Book 2", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));}});
        assertEquals(false, book.equals(bookNotSame) & book.equals(new Object()));
    }
    @Test
    public void notEqualsWithChapters() throws Exception {
        Book book = new Book((short)914, "The Book", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));
                                           add(new Chapter((short)5, "Chapter1", "It was..!"));}});
        Book bookNotSame = new Book((short)914, "The Book", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));
                                           add(new Chapter((short)5, "Chapter1", "It is..!"));}});
        assertEquals(false, book.equals(bookNotSame));
    }
    @Test
    public void testEmptyClone() throws Exception {
        Book book = new Book();
        Book bookCloned = book.clone();
        assertEquals(true, book.equals(bookCloned));
    }
    @Test
    public void testClone() throws Exception {
        Book book = new Book((short)644, "Chapter5", "To be continued",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));}});
        Book bookCloned = book.clone();
        assertEquals(true, book.equals(bookCloned));
    }
    @Test
    public void testToString() throws Exception {
        Book book = new Book((short)192, "The Book", "Me",
                new ArrayList<Chapter>() {{add(new Chapter((short)2, "Intro", "Hi!"));}});
        assertEquals("'The Book' written by Me, 1 chapter(s)", book.toString());
    }
}