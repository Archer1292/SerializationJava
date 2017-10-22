package serialization;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;

public interface Serializable {
    void bookSerialize(Book book) throws IOException;
    Book bookDeserialize() throws IOException;
}
