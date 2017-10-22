package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.*;

public class JacksonSerialization implements Serializable {
    @Override
    public void bookSerialize(Book book) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("bookJackson.json"), book);
    }

    @Override
    public Book bookDeserialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("bookJackson.json"), Book.class);
    }
}
