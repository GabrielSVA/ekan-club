Projeto Desenvolvido com Springboot, Springdata JPA e sistema de segurança com Spring security.

Nesse projeto foi usado os conceitos padrões de arquitetura e desenvolvimento  de um sistema monolítico
(API única). Os recursos utilizados para o desenvolvimento foram Springboot, SpringData JPA e SpringSecurity, para o banco
de dados, foi utilizado o Postgres, outro recurso adicionado foi o lombook pra diminuir um tanto a verbosidade das classes modelo.


Para rodar a aplicação será necessário que tenha um banco de dados instalado em sua máquina, o postgres seria o recomendado para o projeto em questão,
com a ressalva que antes de mais nada será necessário criar o schema com o nome **ekan_clube_db**;  ao rodar a aplicação, o SpringData JPA irá automaticamente construir as tabelas necessárias para o funcionamento.

A aplicação consiste em um CRUD, onde podemos
1 - listar todos os beneficiários cadastrados 
2 - listar um beneficiário específico (beneficiário cadastrado por ID)
3 - listar os documentos de um usuário cadastrado (selecionado por ID de usuário)
4 - Alterar os dados tanto pessoais como de documentos do usuário
5 - Criar um novo usuário
6 - Deletar um usuário já cadastrado.

link da documentação dos endpoints: http://localhost:8080/swagger-ui/index.html#/

Conforme mencionado acima, utilizamos o SpringSecurity, por meio desse, se faz necessário o uso de autenticação e autorização para fazer
requisição na api. Os meios de acesso são:

Ao utilizar o postman acesse a URL: http://localhost:8080/auth/register

O acesso de registro de usuário é totalmente livre de restrição, você poderá criar um usuário com o seguinte JSON

-- --------------------------
{
"login": "Pedro Silva",
"password": "12345",
"role": "USER"
}
-- -------------------------
ou 
-- -------------------------
{
"login": "Ekan Club",
"password": "12345",
"role": "ADMIN"
}
-- ------------------------
 Posteriormente poderá fazer o login com um dos  Json de exemplo acima através da seguinte URL : http://localhost:8080/auth/login
 
Após o Login, você terá o retorno de um Bearer Token onde poderá fazer a requisição de todos os usuários através da URL: http://localhost:8080/ekan-club/beneficiarios

Apenas administradores podem inserir um novo usuário na base de dados, para fazer o teste você poderá utilizar o seguinte JSON (MODELO)

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

Para Fazer um update, segue o exemplo:
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


Salvar, Deletar apenas administradores podem fazer tal ação, as demais requisições são de livre acesso para os demais usuários.










    

