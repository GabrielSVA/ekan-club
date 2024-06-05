# Projeto Desenvolvido com Spring Boot, Spring Data JPA e Spring Security

Este projeto foi desenvolvido seguindo os conceitos padrões de arquitetura e desenvolvimento de um sistema monolítico (API única). Os recursos utilizados para o desenvolvimento foram Spring Boot, Spring Data JPA e Spring Security. Para o banco de dados, foi utilizado o PostgreSQL. Outro recurso adicionado foi o Lombok para diminuir a verbosidade das classes modelo.

## Configuração e Execução

Para rodar a aplicação, é necessário ter um banco de dados PostgreSQL instalado na máquina. Antes de iniciar a aplicação, crie um schema com o nome **ekan_clube_db**. Ao iniciar a aplicação, o Spring Data JPA irá automaticamente construir as tabelas necessárias para o funcionamento.

## Funcionalidades

A aplicação consiste em um CRUD, onde podemos:

1. Listar todos os beneficiários cadastrados.
2. Listar um beneficiário específico (por ID).
3. Listar os documentos de um usuário cadastrado (selecionado por ID de usuário).
4. Alterar os dados pessoais e de documentos do usuário.
5. Criar um novo usuário.
6. Deletar um usuário já cadastrado.

Atenção: Utilize o postman para um teste mais assertivo da aplicação.

## Documentação dos Endpoints

Acesse a documentação dos endpoints em [Swagger UI](http://localhost:8080/swagger-ui/index.html#/).

## Autenticação e Autorização
A aplicação utiliza Spring Security para autenticação e autorização de usuários. Os meios de acesso são:

- Para registrar um novo usuário, acesse a URL: http://localhost:8080/auth/register. O acesso ao registro de usuário é livre de restrição. Você pode criar um usuário com o seguinte JSON:
  ```json
  {
    "login": "Pedro Silva",
    "password": "12345",
    "role": "USER"
  }
  ```
  ou 
```json
    {
    "login": "ekan-club",
    "password": "12345",
    "role": "ADMIN"
    }
  ```

 Posteriormente poderá fazer o login com um dos  Json de exemplo acima através da seguinte URL : http://localhost:8080/auth/login
 
Após o Login, você terá o retorno de um Bearer Token onde poderá fazer a requisição de todos os usuários através da URL: http://localhost:8080/ekan-club/beneficiarios

Apenas administradores podem inserir um novo usuário na base de dados, para fazer o teste você poderá utilizar o seguinte JSON (MODELO)

```json
{
  "nome": "João da Silva",
  "telefone": "11987654321",
  "dataNascimento": "1990-05-15",
  "dataInclusao": "2024-06-05",
  "dataAtualizacao": "2024-06-05",
  "documentos": [
    {
      "tipoDocumento": "RG",
      "descricao": "Registro Geral",
      "dataInclusao": "2024-06-05",
      "dataAtualizacao": "2024-06-05"
    },
    {
      "tipoDocumento": "CPF",
      "descricao": "Cadastro de Pessoas Físicas",
      "dataInclusao": "2024-06-05",
      "dataAtualizacao": "2024-06-05"
    }
  ]
}
```


Para Fazer um update, segue o exemplo:

```json
{
"nome": "João da Silva Atualizado",
"telefone": "11987654322",
"dataNascimento": "1990-05-15",
"dataInclusao": "2024-06-05",
"dataAtualizacao": "2024-06-06",
"documentos": [
{
"id": 1,
"tipoDocumento": "RG",
"descricao": "Registro Geral Atualizado",
"dataInclusao": "2024-06-05",
"dataAtualizacao": "2024-06-06"
},
{
"id": 2,
"tipoDocumento": "CPF",
"descricao": "Cadastro de Pessoas Físicas Atualizado",
"dataInclusao": "2024-06-05",
"dataAtualizacao": "2024-06-06"
}
]
}
```

Salvar, Deletar apenas administradores podem fazer tal ação, as demais requisições são de livre acesso para os demais usuários.










    

