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

        jsonWrite(book);
        book = jsonRead();
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

    private static void jsonWrite(Book book) {
        JSONSerialization tester = new JSONSerialization();
        try {
            tester.bookSerialize(book);
        }
        catch (IOException e) { e.printStackTrace(); }
    }
    private static Book jsonRead() {
        JSONSerialization tester = new JSONSerialization();
        Book book = new Book();
        try {
            book = tester.bookDeserialize();
        }
        catch (IOException e) { e.printStackTrace(); }
        return book;
    }
}
