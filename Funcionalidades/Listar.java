package Funcionalidades;

import java.util.LinkedList;


import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

public class Listar {
    
    public void listarProjetos(LinkedList <Projeto> projetos){

        try {
            Thread.sleep(0);     // Espera 1 segundo para ver a mágica acontecer
            new ProcessBuilder("clear").inheritIO().start().waitFor();      // Para linux (acho que para mac também)
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(Projeto projeto : projetos){

            System.out.println("!-------------------------------------------------------!");
            System.out.println("ID: " +projeto.getId());
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
    public void listarUsuarios(LinkedList <Usuarios> users){

        for(Usuarios user : users){

            System.out.println("ID: " +user.getID());
            System.out.println("Nome: " +user.getNome());
            System.out.println("Tipo: " +user.getTipo());
            System.out.println("Email: "+user.getEmail());
        }
    }

    public void listarAtividades(LinkedList<Atividades> atividades){

        for(Atividades atvd : atividades){

            System.out.println("ID: " +atvd.getID());
            System.out.println("Descrição: " +atvd.getDescricao());
            System.out.println("Prazo: " +atvd.getDataFim());
            
            try{
                System.out.println("Responsavél: " +atvd.getName());

            }catch(Exception y){

                System.out.println("Não existem ainda responsável pela atividade");
            }

        }
    }
}
