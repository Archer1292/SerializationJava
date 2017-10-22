package tests;

import org.junit.Test;
import serialization.Book;
import serialization.Chapter;
import serialization.JSONSerialization;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class JSONSerializationTest {
        @Test
        public void serializationEmpty() throws Exception {
            JSONSerialization tester = new JSONSerialization();
            Book book = new Book();
            tester.bookSerialize(book);
            Book bookDeserialized = tester.bookDeserialize();
            assertEquals(true, book.equals(bookDeserialized));
        }
        @Test
        public void serialization() throws Exception {
            JSONSerialization tester = new JSONSerialization();
            Book book = new Book((short) 644, "Chapter5", "To be continued",
                    new ArrayList<Chapter>() {{
                        add(new Chapter((short) 2, "Intro", "Hi!"));
                    }});
            tester.bookSerialize(book);
            Book bookDeserialized = tester.bookDeserialize();
            assertEquals(true, book.equals(bookDeserialized));
        }
}