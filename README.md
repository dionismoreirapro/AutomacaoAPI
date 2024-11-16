# Automação com Rest Assured

Este projeto consiste em um conjunto de testes automatizados para a **Book Store API** disponível em [Book Store Demo](https://bookstore.demoqa.com/swagger/#/). O objetivo principal é validar as funcionalidades da API, garantindo que as operações de criação, leitura, atualização e exclusão (CRUD) estejam funcionando conforme o esperado.

## Tecnologias Utilizadas

- **Java**
- **Rest Assured**
- **JUnit**
- **Maven**

## Pré-requisitos

Antes de começar, verifique se você possui as seguintes ferramentas instaladas:

- JDK 11 ou superior
- Maven

## Configuração do Projeto

1. Clone o repositório para sua máquina local:
   ```
   git clone https://github.com/dionismoreirapro/AutomacaoAPI.git
   ```
2. Acesse a pasta do projeto:
   ```
   cd AutomacaoAPI
   ```
3. Instale as dependências do projeto usando o Maven:
    ```
    mvn clean install
    ```
 4. Instalação do Allure report
   siga as instruções detalhadas disponíveis na documentação oficial:  
   👉 [Allure Installation Guide](https://allurereport.org/docs/install/)

## Executando os Testes

Para rodar todos os testes, execute o seguinte comando no diretório do projeto:
  ```
    mvn surefire:test
   ```
Este comando irá compilar o projeto e executar todos os testes automatizados. Os resultados dos testes podem ser verificados no console ou no relatório gerado automaticamente após a execução.   

## Relatórios de Teste
 ```
    allure serve target/surefire-reports
 ```


![Relatorio de teste ]()

## Estrutura do Projeto
O projeto está organizado da seguinte forma:

***src/test/java:*** Contém os testes automatizados que validam as funcionalidades da API.</br>
***pom.xml:*** Arquivo de configuração do Maven, contendo as dependências do projeto.
