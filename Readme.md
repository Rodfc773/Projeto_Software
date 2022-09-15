# Repositorio para a disciplina de projeto de software

## Software de  gerenciamento de projetos


### Como rodar a aplicação: 

  * __Para rodar a maior parte das funcionalidades vai ser nescessário estar logado na conta inicial, a conta Administrador, caso não seja feito o login, as principaus funcionalidades emitiram um erro__

  * Login da conta admin = Admin@gmail.com
  * Senha da conta  admin = Adminprojetos 


### Funcionalidades:

### 1. Criar/Retirar:

* A conta admin só poderá criar usuários;

* A conta admin pode usar qualquer funcionalidade de remover;

* Para criação de projeto/atividades é nescessário a criação de uma conta/login de uma conta do tipo Professor ou Pesquisador;

* No caso, ao criar um projeto, conta do tipo professor/pesquisador será alocada como coordenador desse projeto;

* Ao criar  uma atividade é , será nescessário associar um responsável pela funcionalidade 3;

* Não é possível Remover a conta admin;

### 2. Editar informações: 

*  Somente o coordenador do projeto pode alterar informações do projeto em si;
*  Qualquer conta com o nivel de acesso de ADMIN pode alterar informações sobre os usuários/atividades;
*  A alteração de usuários é feita na funcionalidade 1.3 : Criar/Remover usuarios, nas opções de administrador;

### 3. Associar: 

* Somente contas de ususarios de nivel acesso admin podem usar a função associar;

* Caso uma das partes associadas não esteja cadastrada, o programa dará um erro ou não inmprimira nada na tela;

### 4. Alterar status de um projeto:

* Somente o coordenador do projeto poderá alterar seu status

* As alterações são do tipo: CRIADO --> INICIADO, INICIADO --> ANDAMENTO, ANDAMENTO --> FINALIZADO;

### 5. Consultar:

* Qualquer conta tem a permissão para fazer a consultar;

* As consultas podem ser feitas de forma listando todos os objetos ex: listar todas atividades cadastradas;
        
* As consulta também podem ser feitas de forma sobre um único projeto  ou atvidade/usuario(faltando implementação);

### 6. Relátorio:

* Qualquer conta tem a permissão de pedir um relatório de um projeto

* A funcionalidade ira imprimir na tela dados mais detalhados sobre o projeto, como atividade cadastradas para esse projeto e os usuarios associados;

### 7. Intercâmbio entre usuarios:

* A função ainda não foi desenvolvida;

### 8. Sistema de pagamento de bolsas:

*  Para realizar o pagamento de bolsa de um aluno é nescessario está logado e em uma conta do nivel de acesso Admin;

    
### 9. Login:

    * A funcionalidade permiti o login através do email e senha;
    * Após o sucesso de login, o usuario ficará na conta logada até que se faça login denovo;
    * A opção de deslogar ainda está sendo feita;

### 10. Undo/Redo:

* Função ainda não foi implementada;




