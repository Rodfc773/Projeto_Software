package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Usuarios;

public class Login {

    public boolean verificarLogin(LinkedList<Usuarios>users){

        Scanner teclado = new Scanner(System.in);
        Sistema menu = new Sistema();

        menu.printLogin();
        String login = teclado.nextLine();

        System.out.println("Digite a senha: ");
        String password = teclado.nextLine();

        for (Usuarios user : users){

            if(user.getEmail() == login && user.getPassword() == password){

                System.out.println("Seja bem vindo ao sistema " +user.getNome());

                return true;
            }
        } 
        return false; 
    }
    
}
