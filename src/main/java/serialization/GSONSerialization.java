package serialization;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GSONSerialization implements Serializable {
    @Override
    public void bookSerialize(Book book) throws IOException {
        try (Writer writer = new FileWriter("bookJSON.json")) {
            Gson gson = new Gson();
            gson.toJson(book, writer);
        }
    }

    @Override
    public Book bookDeserialize() throws IOException {
        try (FileReader reader = new FileReader("bookJSON.json")) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Book.class);
        }
    }
}
