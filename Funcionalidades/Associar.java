package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Projeto;
import Classes.Usuarios;

public class Associar {

    public LinkedList <Projeto> usersToProject(LinkedList <Projeto> projetos, LinkedList <Usuarios> users){


        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do projeto que queira associar:");
        String nomeProjeto = scan.nextLine();

        System.out.println("Digite o email do usuário que queira associar: ");
        String userEmail = scan.nextLine();

        Usuarios aux = new Usuarios();
        aux = null;
        
        for(Usuarios user : users){

            if(user.getEmail().equals(userEmail)){
                aux = user;
                break;
            }
        }

        for(Projeto projeto : projetos){

            if(aux == null || projetos.contains(projeto.getNomeProjeto().equals(nomeProjeto))){

                System.out.println("Não existe projeto com esse nome/Não existe usuario com esse email");
                return projetos;
            }

            if(projeto.getNomeProjeto().equals(nomeProjeto)){

                projeto.setProfissionais(aux);
                System.out.println("O profissional : " +aux.getNome() + "\nDe email: " +aux.getEmail() + "\nFoi cadastrado com sucesso no projeto: "+projeto.getNomeProjeto());
                break; 
            }
        }
        return projetos;
    }
}
