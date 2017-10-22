package serialization;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GSONSerialization implements Serializable {
    @Override
    public void bookSerialize(Book book) throws IOException {
        try (FileWriter writer = new FileWriter("bookGSON.json")) {
            Gson gson = new Gson();
            gson.toJson(book, writer);
        }
    }

    @Override
    public Book bookDeserialize() throws IOException {
        try (FileReader reader = new FileReader("bookGSON.json")) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Book.class);
        }
    }
}
