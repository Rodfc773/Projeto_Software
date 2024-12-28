package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Atividades;
import Entidades.Pessoa;
import Entidades.Projeto;
import Entidades.Usuarios;

public class Listar {

    public void listarProjetos(LinkedList <Projeto> projetos){

        try {
            Thread.sleep(1);     // Espera 1 segundo para ver a mágica acontecer
            new ProcessBuilder("clear").inheritIO().start().waitFor();      // Para linux (acho que para mac também)
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Deseja Listar Todos os projetos?:(1 : Sim | 2 : Nao):");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        scan.nextLine();

        if(option == 1){

            for(Projeto projeto : projetos){
                System.out.println("!---------------------      PROJETOS -------------------!");
                System.out.println("!-------------------------------------------------------!");
                System.out.println(projeto.toString());
                System.out.println("!-------------------------------------------------------!");
            }
        }
        else{

            System.out.println("Digite o nome do projeto que queira consultar: ");
            String nome = scan.nextLine();

            for(Projeto projeto : projetos){

                if(projeto.getNome().equals(nome)){
                    System.out.println("!---------------------      PROJETO      -------------------!");
                    System.out.println("!-------------------------------------------------------!");
                    System.out.println(projeto.toString());
                    System.out.println("!-------------------------------------------------------!");

                    break;
                }
            }
        }
    }
    public void listarUsuarios(LinkedList <Usuarios> users){



        System.out.println("!#-#-#-#-#-#-#-     USUÁRIOS CADASTRADOS         !#-#-#-#-#-#-#- ");
        for(Usuarios user : users){

            System.out.println("!---------------------------------------------------------!\n");
            System.out.println(user.toString());
            
        }
    }

    public void listarAtividades(LinkedList<Atividades> atividades){



        System.out.println("!@--------------    ATIVIDADES CADASTRADAS  --------------@!");
        for(Atividades atvd : atividades){
            System.out.println("!-------------------------------------------------------!");
            System.out.println(atvd.toString());

        }
    }

    public void relatorio(Projeto projeto){

        try {
            Thread.sleep(1);     // Espera 1 segundo para ver a mágica acontecer
            new ProcessBuilder("clear").inheritIO().start().waitFor();      // Para linux (acho que para mac também)
        } catch(Exception e) {
            e.printStackTrace();
        }
            System.out.println("!---------------------      RELATORIO DO PROJETO     -------------------!");
            System.out.println("!-------------------------------------------------------!");
            System.out.println(projeto.toString());
            System.out.println("!-------------------------------------------------------!");
            System.out.println("!---------------------      PROJETO : " +projeto.getNome() + "   -------------------!");
            System.out.println("!-------------------------------------------------------!");
            listarAtividades(projeto.getTasks());
            listarPessoas(projeto.getProfissionais(),projeto.getNome());



    }
    public void listarAtividade(Atividades atvd){

            System.out.println("!-----------------      ATVIDADE :" +atvd.getNome() + "     ------------------------!");
            System.out.println("!-------------------------------------------------------!");
            System.out.println(atvd.toString());
    }

    public void listarUser(Usuarios user){

        System.out.println("!#-#-#-#-#-#-#-     USUARIO        !#-#-#-#-#-#-#- ");


        System.out.println("!---------------------------------------------------------!\n");
        System.out.println(user.toString());
    }

    public void listarprojeto(Projeto projeto){

            System.out.println("!---------------------      PROJETO     -------------------!");
            System.out.println("!-------------------------------------------------------!");
            System.out.println(projeto.toString());
            System.out.println("!-------------------------------------------------------!");
    }


    public void listarPessoas(LinkedList<Pessoa> cadastrado, String nome){


        System.out.println("!--------------- PROFISSIONAIS ------------------------!");
        System.out.println("!--------------- PROJETO : " + nome + "------------------------!");
        for(Pessoa cadastro : cadastrado){

            System.out.println(cadastro.toString());
        }


    }
}