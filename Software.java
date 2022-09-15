import java.util.LinkedList;
import java.util.Scanner;


import Classes.Atividades;
import Classes.Projeto;
import Classes.Ruler;
import Classes.Usuarios;
import Funcionalidades.AlterarStatus;
import Funcionalidades.Associar;
import Funcionalidades.Criar;
import Funcionalidades.Editar;
import Funcionalidades.Listar;
import Funcionalidades.Payment;
import Funcionalidades.Retirar;
import Funcionalidades.Runner;
import Funcionalidades.Sistema;

public class Software {

    public static void main(String[] args) {

       Sistema menu = new Sistema();
       Usuarios admin = new Usuarios();
       admin.setID(1);
       Usuarios login = new Usuarios();
       login = null;


       LinkedList <Projeto> projetos = new LinkedList<Projeto>();
       LinkedList <Atividades> atividades = new LinkedList<Atividades>();
       Scanner tecladoScanner = new Scanner(System.in);

       Runner run = new Runner();

       run.users.add(admin);

       while(true){

            menu.printSistema();

            int opcao = tecladoScanner.nextInt();

            try{

                switch (opcao){

                    case 0:
                        tecladoScanner.close();
                        System.exit(0);
                        break;
                    case 1:

                        Criar criacao = new Criar();
                        Retirar remover = new Retirar();

                        menu.printCriar();

                        int opcao2 = tecladoScanner.nextInt();

                        tecladoScanner.nextLine();

                        switch (opcao2){

                            case 1:

                                Projeto projeto = new Projeto();

                               projeto = criacao.criarProjetos(login);

                                if(projeto != null){

                                    projeto.setID(projetos.size());
                                    projetos.add(projeto);

                                }
                                else{
                                    System.out.println("Não foi possivel criar o projeto");
                                }


                               break;
                            case 2:

                                Atividades atividade = new Atividades();
                                atividade = criacao.criarAtividade(login);

                                if(atividade != null){

                                    atividade.SetID(atividades.size());

                                    atividades.add(atividade);

                               }
                               else{
                                    System.out.println("Não foi possivel criar a Atividade");
                                }
                                break;
                            case 3:

                                run.Runner(login);

                                break;
                            case  4:

                                if(login.type == Ruler.ADMIN && login != null){
                                    projetos =  remover.retirarProjetos(projetos);
                                }
                                else{
                                    System.out.println("É nescessário está logado em uma conta de Acess level de Admin");
                                }
                                break;
                            case 5:

                                if(login.type == Ruler.ADMIN && login != null){
                                    atividades = remover.retirarAtividades(atividades);
                                }
                                else{
                                    System.out.println("É nescessário está logado em uma conta de Acess level de Admin");
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:

                        Editar edicao = new Editar();

                        menu.printEditar();

                        int oP= tecladoScanner.nextInt();

                        switch(oP){

                            case 1:

                                try{
                                    if(login.type == Ruler.ADMIN && login != null){

                                        projetos = edicao.editarProjeto(projetos, login);
                                    }
                                }catch(Exception y){

                                    System.out.println("É nescessário está logado em uma conta de Acess level de Admin");
                                }
                               
                                break;
                            case 2:

                            try{
                                if(login.type == Ruler.ADMIN && login != null){

                                    atividades = edicao.editarAtividades(atividades);
                                }
                            }catch(Exception y){

                                System.out.println("É nescessário está logado em uma conta de Acess level de Admin");
                            }
                                break;
                            default:

                                break;

                        }

                        break;
                    case 3:
                        try{
                            if(login.type != Ruler.ADMIN){

                                System.out.println("Para associar é nescessário está logado em uma conta de Acess level Admin");
                                break;
                            }
                            menu.printAssociar();
                            Associar function = new Associar();
    
                            int option = tecladoScanner.nextInt();
                            tecladoScanner.nextLine();
    
                            switch(option){
    
                                case 1:
    
                                    projetos = function.usersToProject(projetos, run.users);
    
    
                                    break;
                                case 2:
                                    projetos = function.taskToProject(projetos, atividades);
    
                                    break;
                                case 3:
                                    atividades = function.userTotask(atividades, run.users);
                                    break;
                        }
                    }catch(Exception y){

                            System.out.println("!------- ----------------       ERROR !     ----------------\nUsario não conectado, por favor faça login");
                        }

                        break;
                    case 4:

                        try{

                            if(login.type != Ruler.ADMIN){

                                System.out.println("Para alterar o status é nescessário está logado em uma conta de Acess level Admin");
                                break;
                            }
                            else{

                                AlterarStatus status = new AlterarStatus();

                                projetos = status.mudarStatus(projetos, login);
                            }
                        }catch(Exception y){

                            System.out.println("!------- ----------------       ERROR !     ----------------\nUsario não conectado, por favor faça login");
                        }

                        break;
                        
                    case 5:
                        try{
                            if(login != null){

                                int op;
                        menu.printListar();
                        Listar func = new Listar();

                         op = tecladoScanner.nextInt();
                         tecladoScanner.nextLine();

                            switch(op){

                            case 1:

                                func.listarProjetos(projetos);
                                break;
                            case 2:
                                func.listarAtividades(atividades);
                                break;
                            case 3:
                                func.listarUsuarios(run.users);
                                break;
                            }
                        }
                        }catch(Exception y){

                            System.out.println("!------------   ERROR ----------------!");
                            System.out.println("!------------   Não tem nenhuma conta logado --------------!\n");
                        }
                        break;
                    case 6:
                        System.out.println("Digite o nome do projeto para imprimir seu relatorio: ");
                        tecladoScanner.nextLine();
                        String nome = tecladoScanner.nextLine();
                        Listar rel = new Listar();

                        for(Projeto projeto : projetos){

                            if(projeto.getNomeProjeto().equals(nome)){

                                rel.relatorio(projeto);
                                break;
                            }
                        }
                        break;
                    case 7:

                        break;
                    case 8:
                            Payment pagamento = new Payment();

                            try{
                                if(login != null && login.type == Ruler.ADMIN){

                                    pagamento.paymentBolsa(run.users, tecladoScanner);
                                }
                                else{
                                    System.out.println("O usuario que irá realizar o pagamento da bolsa tem que ter nivel de acesso de admin9");
                                }
                            }catch(Exception y){

                                System.out.println("Não existe nenhuma conta conectada");
                            }
                        break;
                    case 9:

                        login =  run.login();

                        System.out.println(login == null ? "Nenhum Usuário encontrado com esse login" : "Login bem sucedido!"); 

                        break;
                    case 10:

                        break;
                        default:
                            System.out.println("!----------- ERRO, DIGITE UMA OPÇÃO VÁLIDA ---------------!");
                            break;
                    }
                
                }
            catch(Exception y){

                System.out.println(y);
            }
       }
    }

}
