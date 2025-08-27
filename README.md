# Projeto Bank Payment API 

Esta aplicação é uma **API de Pagamentos** feita a partir de um **desafio técnico** que permite o gerenciamento de **pessoas físicas e jurídicas, contas bancárias, cartões de crédito/débito e pagamentos**.  
Foi desenvolvida em **Java 17+ com Spring Boot**, usando **Spring Data JPA** e **MySQL**.

---

##  Tecnologias utilizadas
- Java 17+
- Spring Boot (Web, Data JPA, Validation)
- MySQL
- Swagger (SpringDoc OpenAPI)
- Gradle

---

##  Variáveis de Ambiente

No `application.properties`, configure as credenciais do banco:

| Variável                      | Descrição                       | Valor Padrão                                    |
|:------------------------------|:--------------------------------|:------------------------------------------------|
| `spring.datasource.url`       | URL do banco de dados MySQL     | `jdbc:mysql://localhost:3306/fadesp?useSSL=false` |
| `spring.datasource.username`  | Usuário do banco                | `root`                                          |
| `spring.datasource.password`  | Senha do banco                  | **Obrigatório**                                 |
| `spring.jpa.hibernate.ddl-auto` | Estrategia de schema (create/update) | `update` |

---

## Documentação da API

A API está documentada via **Swagger**.  
Basta rodar o projeto e acessar:

 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## Endpoints principais

### Pessoa
```http
POST /cadastro/pessoa
```
**Cadastrar pessoa (PF ou PJ).**

Exemplo:
```json
{
  "nome": "João Silva",
  "dataNascimento": "1990-01-01",
  "genero": "MASCULINO",
  "endereco": "Rua ABC, 123",
  "telefone": "1122334455",
  "email": "joao.silva@example.com",
  "cpf": "04143271281",
  "rg": "1234567",
  "estadoCivil": "CASADO",
  "nacionalidade": "BRASILEIRA",
  "nomePai": "José Silva",
  "nomeMae": "Maria Silva",
  "estado": "SP",
  "pais": "Brasil"
}
```

---

### Conta
```http
POST /cadastro/conta
```
**Cadastrar conta associada a uma pessoa.**

Exemplo:
```json
{
  "numeroConta": "1234567890",
  "saldo": 1000.0,
  "tipoConta": "FISICA",
  "cnpj": null,
  "titular": {
    "id": 1
  }
}
```

---

### Cartões
```http
POST /cartao/debito
POST /cartao/credito
```
**Cria cartões vinculados à conta.**

---

### Pagamentos
```http
POST /pagamento/realizar
```
**Realiza pagamento (BOLETO, PIX, CARTÃO_DEBITO, CARTÃO_CREDITO).**

Exemplo:
```json
{
  "codigoDebito": 123456789,
  "cpfCnpjPagador": "04143271281",
  "metodoPagamento": "CARTAO_DEBITO",
  "numeroCartao": "1234567890123456",
  "valorPagamento": 500.0,
  "status": "PENDENTE"
}
```

```http
GET /pagamento/consultar?status=PENDENTE
```
Consulta pagamentos.

```http
POST /pagamento/alterar
```
Altera status de pagamento.

```http
POST /pagamento/excluir
```
Exclui pagamento pendente.

---

## Testes

Você pode usar o **Postman** ou o próprio **Swagger** para testar os endpoints.  
Há também uma coleção Postman pronta no diretório `/postman`.

---

##  Autor

**Valberton Cabral**

- 📧 Email: valberton77@gmail.com
- 🌐 GitHub: [CabralV8](https://github.com/CabralV8)
- 💼 LinkedIn: [linkedin.com/in/valbertoncabral](https://www.linkedin.com/in/valbertoncabral)
