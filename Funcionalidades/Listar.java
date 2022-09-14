package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

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
                System.out.println("ID: " +projeto.getId());
                System.out.println("Nome do projeto: " +projeto.getNomeProjeto());
                System.out.println("Status: " +projeto.getStatus());
                System.out.println("Descrição: " +projeto.getDescricao());
                System.out.println("Data de inicio: " +projeto.getDataInicio());
                System.out.println("Data de termino: " +projeto.getDataTermino());

                try{
                    System.out.println("Coordenador: " +projeto.getCoordenadorNome());

                }catch(Exception y){

                    System.out.println("Não existe coordenador para o projeto ainda");
                }
                System.out.println("!-------------------------------------------------------!");
            }
        }
        else{

            System.out.println("Digite o nome do projeto que queira consultar: ");
            String nome = scan.nextLine();

            for(Projeto projeto : projetos){

                if(projeto.getNomeProjeto().equals(nome)){
                    System.out.println("!---------------------      PROJETO      -------------------!");
                    System.out.println("!-------------------------------------------------------!");
                    System.out.println("ID: " +projeto.getId());
                    System.out.println("Nome do projeto: " +projeto.getNomeProjeto());
                    System.out.println("Status: " +projeto.getStatus());
                    System.out.println("Descrição: " +projeto.getDescricao());
                    System.out.println("Data de inicio: " +projeto.getDataInicio());
                    System.out.println("Data de termino: " +projeto.getDataTermino());

                    try{
                        System.out.println("Coordenador: " +projeto.getCoordenadorNome());

                    }catch(Exception y){

                        System.out.println("Não existe coordenador para o projeto ainda");
                    }
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

            System.out.println("ID: " +user.getID());
            System.out.println("Nome: " +user.getNome());
            System.out.println("Tipo: " +user.getTipo());
            System.out.println("Nível de acesso: " +user.getAcessLevel());
            System.out.println("Email: "+user.getEmail());
        }
    }

    public void listarAtividades(LinkedList<Atividades> atividades){



        System.out.println("!@--------------    ATIVIDADES CADASTRADAS  --------------@!");
        for(Atividades atvd : atividades){
            System.out.println("!-------------------------------------------------------!");
            System.out.println("ID: " +atvd.getID());
            System.out.println("Nome da atividade : " +atvd.getNomeAtvd());
            System.out.println("Descrição: " +atvd.getDescricao());
            System.out.println("Prazo: " +atvd.getDataFim());
            
            try{
                System.out.println("Responsavél: " +atvd.getName());

            }catch(Exception y){

                System.out.println("Não existem ainda responsável pela atividade");
            }

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
            System.out.println("ID: " +projeto.getId());
            System.out.println("Nome do projeto: " +projeto.getNomeProjeto());
            System.out.println("Status: " +projeto.getStatus());
            System.out.println("Descrição: " +projeto.getDescricao());
            System.out.println("Data de inicio: " +projeto.getDataInicio());
            System.out.println("Data de termino: " +projeto.getDataTermino());
            
            try{
                System.out.println("Coordenador: " +projeto.getCoordenadorNome());

            }catch(Exception y){

                System.out.println("Não existe coordenador para o projeto ainda");
            }
            System.out.println("!-------------------------------------------------------!");
            try{
                System.out.println("!---------------------      PROJETO : " +projeto.getNomeProjeto() + "   -------------------!");
                listarUsuarios(projeto.getProfissionais());
            }catch(Exception y){

                System.out.println("Não existem usuarios associados a esse projeto");
            }
            System.out.println("!-------------------------------------------------------!");
            try{
                listarAtividades(projeto.getTasks());
            }catch(Exception y){

                System.out.println("Não existem Atividades associadas a esse projeto");
            }



    }
    public void listarAtividade(Atividades atvd){

            System.out.println("!-----------------      ATVIDADE :" +atvd.getNomeAtvd() + "     ------------------------!");
            System.out.println("!-------------------------------------------------------!");
            System.out.println("ID: " +atvd.getID());
            System.out.println("Nome da atividade : " +atvd.getNomeAtvd());
            System.out.println("Descrição: " +atvd.getDescricao());
            System.out.println("Prazo: " +atvd.getDataFim());
            try{
                System.out.println("Responsavél: " +atvd.getName());

            }catch(Exception y){

                System.out.println("Não existem ainda responsável pela atividade");
            }
    }

    public void listarUser(Usuarios user){

        System.out.println("!#-#-#-#-#-#-#-     USUARIO        !#-#-#-#-#-#-#- ");


        System.out.println("!---------------------------------------------------------!\n");

        System.out.println("ID: " +user.getID());
        System.out.println("Nome: " +user.getNome());
        System.out.println("Tipo: " +user.getTipo());
        System.out.println("Nível de acesso: " +user.getAcessLevel());
        System.out.println("Email: "+user.getEmail());
        System.out.println("Valor bolsa: " +user.getBolsa());
    }

    public void listarprojeto(Projeto projeto){

            System.out.println("!---------------------      RPROJETO     -------------------!");
            System.out.println("!-------------------------------------------------------!");
            System.out.println("ID: " +projeto.getId());
            System.out.println("Nome do projeto: " +projeto.getNomeProjeto());
            System.out.println("Status: " +projeto.getStatus());
            System.out.println("Descrição: " +projeto.getDescricao());
            System.out.println("Data de inicio: " +projeto.getDataInicio());
            System.out.println("Data de termino: " +projeto.getDataTermino());
            
            try{
                System.out.println("Coordenador: " +projeto.getCoordenadorNome());

            }catch(Exception y){

                System.out.println("Não existe coordenador para o projeto ainda");
            }
            System.out.println("!-------------------------------------------------------!");
    }

}

/*try {
            Thread.sleep(1);     // Espera 1 segundo para ver a mágica acontecer
            new ProcessBuilder("clear").inheritIO().start().waitFor();      // Para linux (acho que para mac também)
        } catch(Exception e) {
            e.printStackTrace();
        }
            System.out.println("!---------------------      RELATORIO DO PROJETO     -------------------!");
            System.out.println("!-------------------------------------------------------!");
            System.out.println("ID: " +projeto.getId());
            System.out.println("Nome do projeto: " +projeto.getNomeProjeto());
            System.out.println("Status: " +projeto.getStatus());
            System.out.println("Descrição: " +projeto.getDescricao());
            System.out.println("Data de inicio: " +projeto.getDataInicio());
            System.out.println("Data de termino: " +projeto.getDataTermino());
            
            try{
                System.out.println("Coordenador: " +projeto.getCoordenadorNome());

            }catch(Exception y){

                System.out.println("Não existe coordenador para o projeto ainda");
            }
            System.out.println("!-------------------------------------------------------!");
            try{
                listarUsuarios(projeto.getProfissionais());
            }catch(Exception y){

                System.out.println("Não existem usuarios associados a esse projeto");
            }
            System.out.println("!-------------------------------------------------------!");
            try{
                listarAtividades(projeto.getTasks());
            }catch(Exception y){

                System.out.println("Não existem Atividades associadas a esse projeto");
            }



        } */
