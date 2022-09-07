package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

public class Criar {

     public Projeto criarProjetos()
    {
        Sistema menuSistema = new Sistema();
        Scanner teclaScanner = new Scanner(System.in);
        Projeto projeto = new Projeto();

        menuSistema.printCriarProjetoDescricao();
        String descricao = teclaScanner.nextLine();

        projeto.setDescricao(descricao);

        menuSistema.printCriarProjetoDataInicial();
        String dataInicial = teclaScanner.nextLine();
        
        menuSistema.printCriarProjetoDataFinal();
        String dataFinal = teclaScanner.nextLine();

        projeto.setdataInicial(dataInicial);
        projeto.setDataFinal(dataFinal);

        projeto.setStatus("Em criação");


        

        return projeto;

        
        
    }
    public Usuarios criarUsuario()
    {
        Sistema menuSistema = new Sistema();
        Scanner tecladoScanner = new Scanner(System.in);
        Usuarios user = new Usuarios();


        menuSistema.printCriarUsuarioNome();
        String nome = tecladoScanner.nextLine();
        user.setNome(nome);

        menuSistema.printCriarUsuarioTipo();
        String tipo = tecladoScanner.nextLine();
        user.setTipo(tipo);

        menuSistema.printCriarUsuarioEmail();
        String email = tecladoScanner.nextLine();
        user.setEmail(email);

        menuSistema.printCriarUsuarioPassword();
        String password = tecladoScanner.nextLine();
        user.setPassword(password);

        menuSistema.printCriarUsuarioPossuiBolsa();
        int opcao = tecladoScanner.nextInt();

        switch(opcao){

            case 1:
                user.setPossuiBolsa(true);

                menuSistema.printCriarBolsa();
                double bolsa = tecladoScanner.nextDouble();
                user.setBolsa(bolsa);

                menuSistema.printCriarUsuarioPeriodoBolsa();
                String periodoBolsa = tecladoScanner.nextLine();
                user.setPeriodoBolsa(periodoBolsa);

                break;
            case 2:

                user.setPossuiBolsa(false);
                user.setBolsa(0.0);
                break;
        }


        try {
            Thread.sleep(0);     // Espera 1 segundo para ver a mágica acontecer
            new ProcessBuilder("clear").inheritIO().start().waitFor();      // Para linux (acho que para mac também)
        } catch(Exception e) {
            e.printStackTrace();
        }


        return user;
    }

    public Atividades criarAtividade(){

        Atividades atividade = new Atividades();
        Sistema menu = new Sistema();
        Scanner teclaScanner = new Scanner(System.in);

        menu.printCriarAtividadeDescricao();
        String descricao = teclaScanner.nextLine();
        atividade.setDescricao(descricao);

        menu.printCriarAtividadeDataInicial();
        String dataInicio = teclaScanner.nextLine();
        atividade.setDataInicio(dataInicio);

        menu.printCriarAtividadeDataFinal();
        String dataFinal = teclaScanner.nextLine();
        atividade.setDataFinal(dataFinal);

        menu.printCriarAtividadeResponsavel();

        return atividade;
    }
    
}
