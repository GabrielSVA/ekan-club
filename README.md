Projeto Desenvolvido com Springboot, Springdata JPA e sistema de segurança com Spring security.

Nesse projeto foi usado os conceitos padrões de arquitetura e desenvolvimento  de um sistema monolítico
(API única). Os recursos utilizados para o desenvolvimento foram Springboot, SpringData JPA e SpringSecurity, para o banco
de dados, foi utilizado o Postgres.

A aplicação consiste em um CRUD, onde podemos
1 - listar todos os beneficiários cadastrados 
2 - listar um beneficiário específico (beneficiário cadastrado por ID)
3 - listar os documentos de um usuário cadastrado (selecionado por ID de usuário)
4 - Alterar os dados tanto pessoais como de documentos do usuário
5 - Criar um novo usuário
6 - Deletar um usuário já cadastrado.

No Sistema de segurança utilizamos o SpringSecurity, por meio desse, se faz necessário o uso de autenticação e autorização para fazer
requisição na api. 

Abaixo segue os scripts de requisição para o uso dos endpoints que foram listados.


    

