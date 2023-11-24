# Projeto_Final_Minsait_Controle_Backend
Uma API Rest para Controle de Contatos, que gerencia um sitema de cadastro de Pessoas. Um dos objetivo da nossa API  é permitir que operações CRUD - com o uso dos métodos HTTP - GET, POST, PUT e DELETE sejam realizadas. A API estará conectada ao banco de dados MySQL. Foi realizado a documentção da API com o OpenAPI - Swagger, facilitando e incluindo declarações claras e didáticas.
Para acessar o Swagger primeiro deve ser inicializado a aplicação e em seguida acessar o site http://localhost:8080/swagger-ui/index.html#/<br>

# Banco_de_Dados_MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/controledecontatos <br>
spring.datasource.username=root <br>
spring.datasource.password=123456789 <br>
spring.jpa.hibernate.ddl-auto=update <br>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect <br>
spring.jpa.show-sql=true <br>
