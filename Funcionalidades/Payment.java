package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Usuarios;

public class Payment {
    
    public void paymentBolsa(LinkedList<Usuarios> users, Scanner scan){

        System.out.println("Digite o email do aluno que será feito o pagamento de bolsa: ");
        String email = scan.nextLine();

        for(Usuarios user : users){



            if(user.getEmail().equals(email)){

                if(user.getPossuiBolsa() == false){

                    System.out.println("O usuário: " +user.getNome() + "Não possui bolsa ");
                    break;
                }

                System.out.println("Pagamento de bolsa no valor: " +user.getBolsa() + ", Foi realizado com sucesso ao aluno: " +user.getNome());

                break;
            }
        }
    }
}
