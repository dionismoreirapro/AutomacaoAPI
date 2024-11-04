package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.CreateBook;

import java.io.FileInputStream;
import java.io.IOException;

public class CreateBookFactory {

    public static CreateBook criarBook() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateBook book = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/postv1Book.json"),CreateBook.class);
        return book;
    }

    public static CreateBook criarBookComSucesso() throws IOException {

        CreateBook criandoBook = criarBook();
        criandoBook.setUserId("65420547-d040-4e4f-854c-752fe5204f92");
        criandoBook.getCollectionOfIsbns().get(0).setIsbn("9781449325862");
        return criandoBook;
    }
}
