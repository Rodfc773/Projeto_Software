package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Atividades;
import Classes.Projeto;

public class Retirar {
    public LinkedList<Projeto> retirarProjetos(LinkedList<Projeto> projetos){

        if(projetos.isEmpty()){

            System.out.println("!------ NÃO EXISTEM PROJETOS CADASTRADOS ---!");
            System.out.println("!------ POR FAVOR CADASTRE UMA ---------------!");

            return projetos;
        }
        Sistema menu = new Sistema();

        System.out.println("Digite o nome do Projeto que deseja Retirar: ");
        Scanner teclado = new Scanner(System.in);
        String nomeProjeto = teclado.nextLine();

        for(Projeto projeto : projetos){

            if(projeto.getNome().equals(nomeProjeto)){

                System.out.println("!-------------          Projeto Removido com sucesso            -----------!\n\n");
                projetos.remove(projeto);
                return projetos;
            }
        }
        System.out.println("!-----------            ERROR           ---------!");
        System.out.println("!-----------        Atividade não existe ---------!");

        return projetos;
    }
    public LinkedList <Atividades> retirarAtividades(LinkedList <Atividades> atividades){

        if(atividades.isEmpty()){

            System.out.println("!------ NÃO EXISTEM ATIVIDADES CADASTRADAS ---!");
            System.out.println("!------ POR FAVOR CADASTRE UMA ---------------!");

            return atividades;
        }
        else{
            Sistema menu = new Sistema();

            System.out.println("Digite o nome da atividade que deseja retirar: ");
            Scanner teclado = new Scanner(System.in);
            String nomeAtividade = teclado.nextLine();

            for(Atividades atividade : atividades ){

                if(atividade.getNome().equals(nomeAtividade)){

                    atividades.remove(atividade);
                    System.out.println("!---- -------------       Atividade removida com sucesso        ------------!\n\n");
                    return atividades;
                }
            }
            System.out.println("!-----------            ERROR           ---------!");
            System.out.println("!-----------        Atividade não existe ---------!");

        return atividades;
        }
    }
}
