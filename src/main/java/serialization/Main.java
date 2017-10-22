package serialization;

import java.io.IOException;

public class Main {
    public static void main(String args[]){
        Book book = new Book((short)200, "myBook", "me");
        book.addChapter(new Chapter((short)1, "Introduction", "bla-bla"));
        book.addChapter((short)3, "Content", "bla-bla");

        jacksonWrite(book);
        book = jacksonRead();
        System.out.println("jack: " + book);

        gsonWrite(book);
        book = gsonRead();
        System.out.println("JSON: " + book);
    }

    private static void jacksonWrite(Book book) {
        JacksonSerialization tester = new JacksonSerialization();
        try {
            tester.bookSerialize(book);
        }
        catch (IOException e) { e.printStackTrace(); }
    }
    private static Book jacksonRead() {
        JacksonSerialization tester = new JacksonSerialization();
        Book book = new Book();
        try {
             book = tester.bookDeserialize();
        }
        catch (IOException e) { e.printStackTrace(); }
        return book;
    }

    private static void gsonWrite(Book book) {
        GSONSerialization tester = new GSONSerialization();
        try {
            tester.bookSerialize(book);
        }
        catch (IOException e) { e.printStackTrace(); }
    }
    private static Book gsonRead() {
        GSONSerialization tester = new GSONSerialization();
        Book book = new Book();
        try {
            book = tester.bookDeserialize();
        }
        catch (IOException e) { e.printStackTrace(); }
        return book;
    }
}
