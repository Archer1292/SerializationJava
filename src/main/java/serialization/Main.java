package serialization;

import java.io.IOException;

public class Main {
    public static void main(String args[]){
        jacksonRun();

    }

    private static void jacksonRun() {
        JacksonSerialization tester = new JacksonSerialization();
        try {
            Book book = new Book((short)200, "myBook", "me");
            book.addChapter(new Chapter((short)1, "Introduction", "bla-bla"));
            book.addChapter((short)3, "Content", "bla-bla");
            tester.bookSerialize(book);

            Book sameBook = tester.bookDeserialize();
            System.out.println(sameBook);

        } catch (IOException e) { e.printStackTrace(); }
    }
}
