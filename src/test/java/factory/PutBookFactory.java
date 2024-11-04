package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.AlterBook;
import pojo.CreateBook;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PutBookFactory {

    public static AlterBook alterarBook() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        AlterBook alterBook = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/putV1Book.json"),AlterBook.class);
        return alterBook;
    }

    public static AlterBook alterandoBookComSucesso() throws IOException {
        AlterBook alterandoLivro = alterarBook();
        alterandoLivro.setUserId("65420547-d040-4e4f-854c-752fe5204f92");
        alterandoLivro.setIsbn("9781449331818");
        return alterandoLivro;
    }

 }
