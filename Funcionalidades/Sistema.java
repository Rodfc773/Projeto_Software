package Funcionalidades;


public class Sistema {
    public void printSistema(){

        System.out.println("\n\n\n!-------------- SISTEMA DE GERENCIAMENTO DE PROJETOS ---------------!");
        System.out.println("!--------------                                      ---------------!");
        System.out.println("!--------------      FUNCIONALIDADES DO SISTEMA      ---------------!");
        System.out.println("!-------------------------------------------------------------------!");
        System.out.println("!--------------      0 : Encerrar o sistema          ---------------!");
        System.out.println("!--------------      1 : Criar Projetos               ---------------!");
        System.out.println("!--------------      2 : Criar Atividades             ---------------!");
        System.out.println("!--------------      3 : Criar Usuarios                        ------!");
        System.out.println("!--------------      4 : Remover Projetos              --------------!");
        System.out.println("!--------------      5 : Remover Atividades           ---------------!");
        System.out.println("!--------------      6 : Remover Usuarios             ---------------!");
        System.out.println("!--------------      7 : Editar Projetos              ---------------!");
        System.out.println("!--------------      8 : Editar Atividades            ---------------!");
        System.out.println("!--------------      9 : Editar Usuarios               --------------!");
        System.out.println("!--------------     10 : Associar Usuarios a Projetos    ------------!");
        System.out.println("!--------------     11 : Associar Tarefas a Projetos     ------------!");
        System.out.println("!--------------     12 : Associar Usuarios a Atividades  ------------!");
        System.out.println("!--------------     13 : Alterar status de um Projeto    ------------!");
        System.out.println("!--------------     14 : Listar Projetos Cadastrados     ------------!");
        System.out.println("!--------------     15 : Listar Atividades Cadastradas   ------------!");
        System.out.println("!--------------     16 : Listar Usuarios Cadastrados     ------------!");
        System.out.println("!--------------     17 : Mostrar um Relatorio            ------------!");
        System.out.println("!--------------     18 : Pagamento de Bolsas             ------------!");
        System.out.println("!--------------     19 : Login                           ------------!");









    }
    public void printSistemaLogin(){

        System.out.println("\n\n\n!-------------- SISTEMA DE GERENCIAMENTO DE PROJETOS ---------------!");
        System.out.println("!--------------                                      ---------------!");
        System.out.println("!--------------      FUNCIONALIDADES DO SISTEMA      ---------------!");
        System.out.println("!-------------------------------------------------------------------!");
        System.out.println("!--------------      0 : Encerrar o sistema          ---------------!");
        System.out.println("!--------------      1 : Criar Projetos               ---------------!");
        System.out.println("!--------------      2 : Criar Atividades             ---------------!");
        System.out.println("!--------------      3 : Criar Usuarios                        ------!");
        System.out.println("!--------------      4 : Remover Projetos              --------------!");
        System.out.println("!--------------      5 : Remover Atividades           ---------------!");
        System.out.println("!--------------      6 : Remover Usuarios             ---------------!");
        System.out.println("!--------------      7 : Editar Projetos              ---------------!");
        System.out.println("!--------------      8 : Editar Atividades            ---------------!");
        System.out.println("!--------------      9 : Editar Usuarios               --------------!");
        System.out.println("!--------------     10 : Associar Usuarios a Projetos    ------------!");
        System.out.println("!--------------     11 : Associar Tarefas a Projetos     ------------!");
        System.out.println("!--------------     12 : Associar Usuarios a Atividades  ------------!");
        System.out.println("!--------------     13 : Alterar status de um Projeto    ------------!");
        System.out.println("!--------------     14 : Listar Projetos Cadastrados     ------------!");
        System.out.println("!--------------     15 : Listar Atividades Cadastradas   ------------!");
        System.out.println("!--------------     16 : Listar Usuarios Cadastrados     ------------!");
        System.out.println("!--------------     17 : Mostrar um Relatorio            ------------!");
        System.out.println("!--------------     18 : Pagamento de Bolsas             ------------!");
        System.out.println("!--------------     19 : Logout                          ------------!");


    }
    public void printCriar(){

        System.out.println("+-------------------    SISTEMA DE CRIAÇÃO /REMOVER   ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      FUNCIONALIDADES           --------------+");
        System.out.println("+-----------------                                --------------+");
        System.out.println("+-----------------      1 : Criar Projetos        --------------+");
        System.out.println("+-----------------      2 : Criar Atividades      --------------+");
        System.out.println("+-----------------      3 : Criar/Remover Usuários--------------+");
        System.out.println("+-----------------      4 : Remover Projetos      --------------+");
        System.out.println("+-----------------      5 : Remover Atividades    --------------+");

    }

    //#######################       MÉTODOS PRINTS EDITAR           ###########################################
    public void printEditar(){

        System.out.println("+-------------------    FUNCIONALIDADE : EDIÇÃO    ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      FUNCIONALIDADES           --------------+");
        System.out.println("+-----------------                                --------------+");
        System.out.println("+-----------------      1 : Editar Projetos        --------------+");
        System.out.println("+-----------------      2 : Editar Atividades      --------------+");

    }
    public void printEditarProjeto(){

        System.out.println("+-------------------    EDIÇÃO : PROJETOS     ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      O QUE DESEJA EDITAR?      --------------+");
        System.out.println("+-----------------                                 -------------+");
        System.out.println("+-----------------      1 : Editar Descrição        -------------+");
        System.out.println("+-----------------      2 : Editar Prazo        -------------+");

    }
    public void printEditarProjetoDescricao(){

        System.out.println("Digite uma nova descrição: ");
    }
    public void printEditarProjetoStatus(){

        System.out.println("Deseja alterar o status do projeto de \"Em criação\"");
        System.out.println("Para: \"Iniciado\"?");
        System.out.println("1 : Sim || 2 : Não");
    }
    public void printEditarProjetoPrazo(){

        System.out.println("Digite o novo prazo pro projeto: ");
    }
    public void printEditarAtividades(){
        System.out.println("+-------------------    EDIÇÃO : ATIVIDADES    ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      O QUE DESEJA EDITAR?      --------------+");
        System.out.println("+-----------------                                -------------+");
        System.out.println("+-----------------      1 : Editar Descrição       -------------+");
        System.out.println("+-----------------      2 : Editar Prazo          -------------+");
        System.out.println("+-----------------      3 : Editar Responsável          -------------+");

    }
    public void printEditarAtividadesDescricao(){

        System.out.println("Digite a nova descrição: ");
    }
    public void printEditarAtividadesPrazo(){
        System.out.println("Digite o novo prazo: ");
    }
    public void printEditarUsuarios(){

        System.out.println("+-------------------    EDIÇÃO : USUÁRIOS     ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      O QUE DESEJA EDITAR?      --------------+");
        System.out.println("+-----------------                                 -------------+");
        System.out.println("+-----------------      1 : Nome                   -------------+");
        System.out.println("+-----------------      2 : Tipo                   -------------+");
        System.out.println("+-----------------      3 : Bolsa                  -------------+");
        System.out.println("+-----------------      4 : Email                  -------------+");
        System.out.println("+-----------------      5 : Senha                  -------------+");



    }
    //###########################          MÉTODOS DE PRINT ASSOCIAR #######################################//

    public void printAssociar(){

        System.out.println("+-------------------    ASSOCIAÇÃO            ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      O QUE DESEJA ASSOCIAR?    --------------+");
        System.out.println("+-----------------                                 -------------+");
        System.out.println("+-----------------      1 : Usuários -->  Projeto    -------------+");
        System.out.println("+-----------------      2 : Atvidades --> projetos  -------------+");
        System.out.println("+-----------------      3 : Profissionais --> Atividades   -------------+");

    }

    //############### MÉTODOS DE CRIAÇÃO DE PROJETOS ####################################
    public void printCriarProjetoDescricao(){

        System.out.println("Digite a descrição do Projeto: ");
    }
    public void printCriarProjetoDataInicial(){

        System.out.println("Digite a data a inicial(ex: 15-08-2001 14:30): ");
    }
    public void printCriarProjetoDataFinal(){

        System.out.println("Digite a data de término do projeto(ex: 15-08-2001 14:30): ");
    }
    public void printCriarProjetoCoordenador(){

        System.out.println("Para designar um orientador, vá pra fucionalidade associar e associe um coordenador!");

    }
    // ############################# MÉTODOS DE PRINTAR A CRIACAO DO USUARIO ##################
    public void printCriarUsuarioEmail(){

        System.out.println("Digite um email para cadastro: ");
    }
    public void printCriarUsuarioNome(){

        System.out.println("Digite o nome do Usuário: ");
    }
    public void printCriarUsuarioTipo(){

        System.out.println("Digite o tipo(Graduação, Mestrado .... etc): ");
    }

    public void printCriarUsuarioPassword(){

        System.out.println("Cadastre uma senha: ");
    }
    public void printCriarUsuarioPossuiBolsa(){

        System.out.println("O usuário possui bolsa?(1 : Sim | 2 : Não)");
    }
    public void printCriarBolsa(){

        System.out.println("Informe o valor da bolsa: ");
    }
    public void printCriarUsuarioPeriodoBolsa(){

        System.out.println("Informe o periodo da bolsa(ex: 14/08/2022 - 16/10/2022): ");
    }

    // ########################### MÉTODOS DE PRINT PARA AS ATIVIDADES ###################################################


    public void printCriarAtividadeDescricao(){

        System.out.println("Informe a descrição da atividade: ");
    }
    public void printCriarAtividadeDataInicial(){

        System.out.println("Informe a data inicial da atividade(Ex: dia - mes - ano hora:minuto): ");
    }
    public void printCriarAtividadeDataFinal(){

        System.out.println("Informe o prazo da atvidade(Ex: Dia - Mes - Ano Hora:Minuto): ");
    }
    public void printCriarAtividadeResponsavel(){

        System.out.println("!--Para cadastrar o responsavél pela atividade por favor vá na funcionalidade associar--!");
    }
    //############################# Método de printar a funcão listar ############################//#endregion

    public void printListar(){

        System.out.println("+-------------------    SISTEMA DE LISTAGEM    ------------------+");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("+-----------------      FUNCIONALIDADES           --------------+");
        System.out.println("+-----------------                                --------------+");
        System.out.println("+-----------------      1 : Listar Projetos        --------------+");
        System.out.println("+-----------------      2 : Listar Atividades      --------------+");
        System.out.println("+-----------------      3 : Listar Usuários        --------------+");
    }
    //################ Métodos print para pegar o ID #################

    public void printPegarID(){

        System.out.println("Digite um ID para retirada: ");
    }

    //################ Métodos print de editar informações #######################//]

    public void printLogin(){

        System.out.println("!-------------------- FUNCIONALIDADE : LOGIN -------------------!");
        System.out.println("Digite um Email: ");
    }
}
