package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

public class Retirar {
    
    public LinkedList<Projeto> retirarProjetos(LinkedList<Projeto> projetos){
        

        if(projetos.isEmpty()){

            System.out.println("!------ NÃO EXISTEM PROJETOS CADASTRADOS ---!");
            System.out.println("!------ POR FAVOR CADASTRE UMA ---------------!");

            return projetos;
        }
        Sistema menu = new Sistema();

        menu.printPegarID();
        Scanner teclado = new Scanner(System.in);
        int id = teclado.nextInt();

        projetos.remove(id);

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

            menu.printPegarID();
            Scanner teclado = new Scanner(System.in);
            int id = teclado.nextInt();

            atividades.remove(id);

        return atividades;
        }
    }
    public LinkedList <Usuarios> retirarUsuarios(LinkedList<Usuarios> users){

        if(users.isEmpty()){

            System.out.println("!------ NÃO EXISTEM USUÁRIOS CADASTRADOS ---!");
            System.out.println("!------ POR FAVOR CADASTRE UM ---------------!");
            
            return users;
        }
        Sistema menu = new Sistema();

        menu.printPegarID();
        Scanner teclado = new Scanner(System.in);
        int id = teclado.nextInt();

        if(id == 0){

            System.out.println("Não é possivel excluir o Administrador, por favor escolha outro usuario");

            return users;
        }

        users.remove(id);
        return users;
    }
}
