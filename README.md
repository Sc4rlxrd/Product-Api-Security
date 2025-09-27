# 🛡️ Security API

API REST desenvolvida em **Spring Boot 3**, com autenticação e autorização via **Spring Security + JWT**.  
O projeto implementa controle de acesso baseado em **roles (ADMIN, USER)** para manipulação de produtos.

---

## 📌 Funcionalidades

- Cadastro e autenticação de usuários (login + geração de token JWT).
- Controle de acesso baseado em **roles**:
    - **ADMIN** → pode **criar produtos** e **listar todos**.
    - **USER** → pode apenas **listar produtos**.
- Persistência de dados em **MySQL** rodando no **Docker Compose** (com volumes).
- **Uso de DTOs** para separar a **entrada (Request)** da **saída (Response)**.
- Camada de configuração de segurança isolada (`infra/security`) para **Spring Security + JWT**.

---

## 🛠️ Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.5
- Spring Security + JWT
- Spring Data JPA
- MySQL (Docker + Volumes)
- Lombok
- Maven
- Redis

---

## 🚀 Como executar o projeto

### Pré-requisitos

- **Java 21**
- **Maven 3+**
- **Docker** e **Docker Compose**

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/security-api.git
   cd security-api

## 🔑 Autenticação & Exemplos de Uso

### 1. Registrar Usuário

Crie um novo usuário para ter acesso aos recursos da API.

* **Método:** `POST`
* **Rota:** `/auth/register`
* **Permissão:** Público

**📤 Requisição**

```json
{
  "login": "admin",
  "password": "123456",
  "role": "ADMIN"
}
```
### 2.Login

Autentique-se para obter um token JWT necessário para acessar rotas protegidas.

* **Método:** `POST`
* **Rota:** `/auth/login`
* **Permissão:** Público

📤 Requisição

``` json
{
  "login": "admin",
  "password": "123456"
}
```

**✅ Resposta**

``` json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5MDAwMDAwMCwiZXhwIjoxNjkwMDAzNjAwfQ.abc123"
}
``` 

📌 Importante: O token recebido deve ser enviado no cabeçalho Authorization de todas as requisições para endpoints
protegidos, no formato Bearer <seu_token_jwt>.

### 3. Criar Produto

Adicione um novo produto ao sistema. Esta operação é restrita a usuários com a permissão de ADMIN.

* **Método:** `POST`
* **Rota:** `/products`
* **Permissão:** ADMIN

📤 Requisição

``` json
{
"name": "Notebook Gamer",
"price": 5999.90
}
``` 

**✅ Resposta**

``` json
{
"id": "e7e7c01a-9d6c-4a77-93a7-8bb1a9f60c56",
"name": "Notebook Gamer",
"price": 5999.90
}
```

### 4. Listar Produtos

Visualize a lista completa de produtos disponíveis.

* **Método:** `GET`
* **Rota:** `/products`
* **Permissão:** ADMIN/USER

**✅ Resposta**

``` json
{
[
{
"id": "e7e7c01a-9d6c-4a77-93a7-8bb1a9f60c56",
"name": "Notebook Gamer",
"price": 5999.90
},
{
"id": "f5c21d3b-94f1-4f52-9eaf-7a9c83a12345",
"name": "Mouse Sem Fio",
"price": 149.90
}
]
```

| Método | Rota           | Descrição                | Permissão  |
|--------|----------------|--------------------------|------------|
| POST   | /auth/register | Registrar novo usuário   | Público    |
| GET    | /products      | Listar todos os produtos | ADMIN/USER |
| POST   | /products      | Criar novo produto       | ADMIN      |
| POST   | /auth/login    | Autenticar e gerar token | Público    |   
