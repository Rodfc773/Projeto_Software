package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Pessoa;
import Entidades.Usuarios;

public class Payment {
    
    public void paymentBolsa(LinkedList<Usuarios> users, Scanner scan){

        System.out.println("Digite o email do aluno que será feito o pagamento de bolsa: ");
        String email = scan.nextLine();
        Pessoa aluno = new Pessoa();

        for(Usuarios user : users){



            if(user.getEmail().equals(email)){

                aluno = (Pessoa) user;

                break;
            }


        }
        if(aluno.getTemBolsa() == false)System.out.println("O usuário: " +aluno.getNome() + "Não possui bolsa ");

        else System.out.println("Pagamento de bolsa no valor: " +aluno.getBolsa() + ", Foi realizado com sucesso ao Bolsista: " +aluno.getNome());
    }
}
