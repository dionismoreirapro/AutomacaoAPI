package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import pojo.UsuarioAdministrador;

import java.io.FileInputStream;
import java.io.IOException;

public class UsuarioLoginFactory {
    private static Faker fake = new Faker();
    public static UsuarioAdministrador criarUsuarioAdministrador() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioAdministrador usuarioAdm = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/postV1UsuarioLogin.json"),UsuarioAdministrador.class);
        return usuarioAdm;
    }

    public static UsuarioAdministrador criarUsuarioAdministradorValido() throws IOException {
        UsuarioAdministrador usuarioAdmValido = criarUsuarioAdministrador();
        return usuarioAdmValido;
    }

}
