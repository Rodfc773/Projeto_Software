package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Projeto;
import Classes.Ruler;
import Classes.Status;
import Classes.Usuarios;

public class AlterarStatus {
    
    public   LinkedList <Projeto> mudarStatus(LinkedList <Projeto> projetos, Usuarios user){

        System.out.println("Digite o nome do projeto que sera alterado o status: ");
        Scanner scan = new Scanner(System.in);
        String nome = scan.nextLine();
        for (Projeto projeto : projetos){

            if(projeto.getNomeProjeto().equals(nome)){

                if(projeto.getCoordenador() != user){

                    System.out.println("!-----------------      ERROR       ------------!");
                    System.out.println("!--------- Somente o coordenador do projeto pode alterar o status");
                    return projetos;
                }
                else{

                    if(projeto.status == Status.CRIADO) {

                        System.out.println("!!!! Status alterado com Sucesso !!!");
                        projeto.setStatusIniciado();
                        break;
                    }
                    if(projeto.status == Status.INICIADO){

                        System.out.println("Deseja mudar o status do projeto para \"EM ANDAMENTO \" ?(1 : Sim | 2 : Nao)");
                        int op = scan.nextInt();
                        scan.nextLine();

                        if(op == 1) projeto.setStatusAndamento();

                        break;

                    }
                    if(projeto.status == Status.ANDAMENTO) {
                        System.out.println("!!!! Status alterado com Sucesso !!!");

                        projeto.setStatusFinalizado();
                        break;
                    }
                }
            }

        }

        return projetos;
    }
}
