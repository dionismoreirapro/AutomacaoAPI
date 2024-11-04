package config;

import org.aeonbits.owner.ConfigFactory;

public  class URLBooks {
    protected static Configuracoes configuracoes;
    protected static String baseURI;
    protected static String basePath;

    static {
        configuracoes = ConfigFactory.create(Configuracoes.class);
        baseURI = configuracoes.baseURI();
        basePath = configuracoes.basePathBook();
    }
}
