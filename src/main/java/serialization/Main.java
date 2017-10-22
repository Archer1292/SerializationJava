package serialization;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Book bookOriginal = new Book((short)200, "myBook", "me");
        bookOriginal.addChapter(new Chapter((short)1, "Introduction", "bla-bla"));
        bookOriginal.addChapter((short)3, "Content", "bla-bla");

        Book bookCopied = bookOriginal.clone();
        Serializable tester;

        tester = new JacksonSerialization();
        testSerialization(bookOriginal, bookCopied, tester);

        tester = new GSONSerialization();
        testSerialization(bookOriginal, bookCopied, tester);

        tester = new JSONSerialization();
        testSerialization(bookOriginal, bookCopied, tester);
    }

    private static void testSerialization(Book bookOriginal, Book bookCopied, Serializable tester) {
        toFile(tester, bookCopied);
        bookCopied = fromFile(tester);
        if (!bookOriginal.equals(bookCopied))
            System.out.println("ERROR");
    }

    private static void toFile(Serializable tester, Book book) {
        try {
            tester.bookSerialize(book);
        }
        catch (IOException e) { e.printStackTrace(); }}

    private static Book fromFile(Serializable tester) {
        Book book = new Book();
        try {
            book = tester.bookDeserialize();
        }
        catch (IOException | ParseException e) { e.printStackTrace(); }
        return book;}
}
