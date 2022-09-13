package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Ruler;
import Classes.Usuarios;

public class Criar {

     public Projeto criarProjetos(Usuarios user)
    {
        Sistema menuSistema = new Sistema();
        Scanner teclaScanner = new Scanner(System.in);
        Projeto projeto = new Projeto();

        if(user.getAcessLevel().equals(Ruler.ADMIN)){
            System.out.println("Digite o nome do projeto: ");
            String nomeProjeto = teclaScanner.nextLine();
            projeto.setNomeProjeto(nomeProjeto);

            menuSistema.printCriarProjetoDescricao();
            String descricao = teclaScanner.nextLine();

            projeto.setDescricao(descricao);

            menuSistema.printCriarProjetoDataInicial();
            String dataInicial = teclaScanner.nextLine();
            menuSistema.printCriarProjetoDataFinal();
            String dataFinal = teclaScanner.nextLine();

            projeto.setdataInicial(dataInicial);
            projeto.setDataFinal(dataFinal);
            projeto.setStatus();

            System.out.println("Deseja cadastrar esse usuario: " +user.getNome() + " Como o coordenador do projeto?(1 : sim e 2 : Não");

            int op = teclaScanner.nextInt();
            teclaScanner.nextLine();

            switch (op){

                case 1:
                    projeto.setCoodernador(user);
                    break;
                case 2:
                    System.out.println("Por favor vá a função associar e cadastre um coordenador pro projeto");
                    break;
                default:
                    System.out.println("Por favor vá a função associar e cadastre um coordenador pro projeto");
                    break;
            }

        }
        else{

            System.out.println("Por favor logue em uma conta de coordenador ou Professor:");
            projeto = null;
            return projeto;
        }

        return projeto;

    }
    public Atividades criarAtividade(Usuarios login){

        Atividades atividade = new Atividades();
        if(login.type == Ruler.ADMIN){
            Sistema menu = new Sistema();
            Scanner teclaScanner = new Scanner(System.in);

            System.out.println("Digite o nome da atividade: ");
            String nomeAtividade = teclaScanner.nextLine();
            atividade.setNomeAtividae(nomeAtividade);

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
        }
        else{
            System.out.println("Por favor logue em uma conta de coordenador ou Professor");
            atividade = null;
        }

        return atividade;
    }

}
