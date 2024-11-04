package Modulos.book;


import config.PegandoToken;
import config.URLBooks;
import factory.CreateBookFactory;
import factory.PutBookFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.AlterBook;
import pojo.CreateBook;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

@DisplayName("Teste de API Rest do modulo de book")
public class BookTest extends URLBooks {
    private String token;

    @BeforeEach
    public void setup() throws IOException {
       this.token = new PegandoToken().setup();
    }

    @Test
    @DisplayName("Cadastro de livro já existente")
    public void cadastrandoUmLivroComSucesso() throws IOException {
        CreateBook criarBook = CreateBookFactory.criarBookComSucesso();
       Response response = given()
                .header("accept", "application/json")
                .header("authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(criarBook)
        .when()
                .post(baseURI+basePath + "/v1/Books");
        response.then()
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .contentType(ContentType.JSON)
                .body("message", equalTo("ISBN already present in the User's Collection!"));

    }
    @Test
    @DisplayName("Buscando um livro pelo isbn")
    public void buscarLivroPorIsbn(){
   Response response =  given()
            .queryParam("ISBN", "9781449325862")
            .header("accept", "application/json")
            .header("authorization", "Bearer " + token)
            .contentType(ContentType.JSON)
    .when()
            .get(baseURI+basePath+"/v1/Book");
    response.then()
                .statusCode(HttpStatus.SC_OK)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .contentType(ContentType.JSON)
                .body("isbn", equalTo("9781449325862"))
                .body("publisher", equalTo("O'Reilly Media"))
                .body("pages", equalTo(234));
                //Só fiz algumas validações
    }
    @Test
    @DisplayName("Alterando um book pelo ISBN")
    public void alterandoBookPeloISBN() throws IOException {
        AlterBook alterarBook = PutBookFactory.alterandoBookComSucesso();
        Response response = given()
                .pathParam("UUID", "9781449337711")
                .header("accept", "application/json")
                .header("authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(alterarBook)
        .when()
                .delete(baseURI+basePath +"/v1/Books");
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .contentType(ContentType.JSON)
                .body("userId",equalTo("65420547-d040-4e4f-854c-752fe5204f92"))
                .body("username",equalTo("Test4"));
    }
    @Test
    @DisplayName("Deletando um book pelo UserId")
    public void deletarBookPeloUserId() throws IOException {
        AlterBook alterarBook = PutBookFactory.alterandoBookComSucesso();
        Response response = given()
                .queryParam("UserId", "65420547-d040-4e4f-854c-752fe5204f92")
                .header("accept", "application/json")
                .header("authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
        .when()
                .delete(baseURI+basePath +"/v1/Books");
        response.then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    @DisplayName("Cadastro de livro")
    public void cadastrarUmLivroExistente() throws IOException {
        CreateBook criarBook = CreateBookFactory.criarBookComSucesso();
       Response response =  given()
                .header("accept", "application/json")
                .header("authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(criarBook)
        .when()
                .post(baseURI+basePath + "/v1/Books");
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
