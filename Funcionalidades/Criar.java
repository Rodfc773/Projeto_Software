package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

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
    
        try{
            if(user.getAcessLevel().equals(Ruler.ADMIN) && !(user.getEmail().equals("Admin@gmail.com")) ){
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
    
                projeto.setCoodernador(user);
            }
            else{
    
                System.out.println("Por favor logue em uma conta de Pesquisador ou Professor:");
                projeto = null;
                return projeto;
            }
    
            return projeto;
        }catch(Exception y){

            System.out.println("!---        ERROR       ----!\nNão existe nenhuma conta Logada\n");

            return null;
        }

    }
    public Atividades criarAtividade(Usuarios login){

        Atividades atividade = new Atividades();
        try{
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
                System.out.println("Por favor logue em uma conta de Pesquisador ou Professor");
                atividade = null;
            }
    
            return atividade;
        }catch(Exception y){

            System.out.println("!---        ERROR       ----!\nNão existe nenhuma conta Logada\n");

            return null;
        }
    }

}
