package config;

import factory.UsuarioLoginFactory;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UsuarioAdministrador;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

@DisplayName("Obtendo Token")
public class PegandoToken {

    private String token;

    public String setup() throws IOException {
        Configuracoes configuracoes = ConfigFactory.create(Configuracoes.class);

        baseURI = configuracoes.baseURI();
        basePath = configuracoes.basePath();

        UsuarioAdministrador usuarioAdministrador = UsuarioLoginFactory.criarUsuarioAdministradorValido();

        this.token = given()
                .contentType(ContentType.JSON)
                .body(usuarioAdministrador)
        .when()
                .post("/v1/GenerateToken")
        .then()
                .extract().path("token");
        return token;
    }
}
