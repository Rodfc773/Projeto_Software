import java.util.LinkedList;
import java.util.Scanner;


import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;
import Funcionalidades.Criar;
import Funcionalidades.Editar;
import Funcionalidades.Listar;
import Funcionalidades.Login;
import Funcionalidades.Retirar;
import Funcionalidades.Sistema;

public class Software {

    public static void main(String[] args) {
        
       Sistema menu = new Sistema();
       Usuarios admin = new Usuarios();
       LinkedList <Usuarios> users = new LinkedList<Usuarios>();
       LinkedList <Projeto> projetos = new LinkedList<Projeto>();
       LinkedList <Atividades> atividades = new LinkedList<Atividades>();
       Scanner tecladoScanner = new Scanner(System.in);

       users.add(admin);

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

                               projeto = criacao.criarProjetos();

                               projeto.setID(projetos.size());

                               projetos.add(projeto);
    
                               break;
                            case 2:

                                Atividades atividade = new Atividades();
                                atividade = criacao.criarAtividade();

                                atividade.SetID(atividades.size());

                                atividades.add(atividade);

    
                                break;
                            case 3:

                                Usuarios user = new Usuarios();
                                user = criacao.criarUsuario();
                                user.setID(users.size());

                                users.add(user);

                                break;
                            case  4:

                                projetos =  remover.retirarProjetos(projetos);
                                break;
                            case 5:
                                atividades = remover.retirarAtividades(atividades);
                                break;
                            
                            case 6:
                                users = remover.retirarUsuarios(users);
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
                                System.out.println("Digite o ID do projeto que queira editar: ");
                                int id = tecladoScanner.nextInt();

                                try{
                                    Projeto aux = projetos.get(id);

                                    aux = edicao.editarProjeto(aux, users);

                                    projetos.set(id, aux);
                                }catch(Exception y){

                                    System.out.println("Não existe Projeto cadastrado com esse ID");
                                }

                                break;
                            case 2:

                                System.out.println("Digite o ID da atividade que queira editar: ");
                                id = tecladoScanner.nextInt();

                                try{

                                    Atividades auxAtividades = atividades.get(id);

                                    auxAtividades = edicao.editarAtividades(auxAtividades, users);
    
                                    atividades.set(id, auxAtividades);
                                }catch(Exception y){

                                    System.out.println("Não existe Atividade cadastrado com esse ID");
                                }                  
                                break;
                            case 3:

                                System.out.println("Digite o ID do Usuário que queira editar: ");
                                id = tecladoScanner.nextInt();

                                try{

                                    Usuarios auxUsuarios = users.get(id);

                                    auxUsuarios = edicao.editarUser(auxUsuarios, users);

                                    users.set(id, auxUsuarios);
                                }catch(Exception y){

                                    System.out.println("Não existe usuário cadastrado com esse ID");
                                }

                                 break;
                            default:

                                break;


                        }

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        Login login = new Login();

                        boolean verify = login.verificarLogin(users);

                        if(!(verify)){

                            System.out.println("Login Inválido, tente novamente");
                        }

                        break;
                    case 10:

                        break;

                    case 11:
    
                        int op;
                        menu.printListar();
                        Listar func = new Listar();

                         op = tecladoScanner.nextInt();

                        switch(op){

                            case 1:

                                func.listarProjetos(projetos);
                                break;
                            case 2:
                                func.listarAtividades(atividades);
                                break;
                            case 3:
                                func.listarUsuarios(users);
                                 break;
                            }
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
