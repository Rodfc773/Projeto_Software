package Funcionalidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import Entidades.Atividades;
import Entidades.Pessoa;
import Entidades.Projeto;
import Entidades.Ruler;
import Entidades.Usuarios;

public class Criar {

     public Projeto criarProjetos(Pessoa user)
    {
        Sistema menuSistema = new Sistema();
        Scanner teclaScanner = new Scanner(System.in);
    
        try{
            if(user.getAcessLevel().equals(Ruler.Coordenador)){
                System.out.println("Digite o nome do projeto: ");
                String nomeProjeto = teclaScanner.nextLine();
    
                menuSistema.printCriarProjetoDescricao();
                String descricao = teclaScanner.nextLine();

                menuSistema.printCriarProjetoDataInicial();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime dataInicial = LocalDateTime.parse(teclaScanner.nextLine(), formatter);
                menuSistema.printCriarProjetoDataFinal();
                LocalDateTime dataFinal = LocalDateTime.parse(teclaScanner.nextLine(), formatter);
    
                Projeto projeto = new Projeto(nomeProjeto, descricao, dataInicial, dataFinal, user);
                return projeto;
            }
            else{
    
                System.out.println("Por favor logue em uma conta de Pesquisador ou Professor:");
                Projeto projeto = null;
                return projeto;
            }
    
        }catch(Exception y){

            System.out.println("!---        ERROR       ----!\nNão existe nenhuma conta Logada\n");

            return null;
        }

    }
    public Atividades criarAtividade(Usuarios login){

        
        try{
            if(login.getAcessLevel().equals(Ruler.Coordenador)){
                Sistema menu = new Sistema();
                Scanner teclaScanner = new Scanner(System.in);

                System.out.println("Digite o nome da atividade: ");
                String nomeAtividade = teclaScanner.nextLine();

                menu.printCriarAtividadeDescricao();
                String descricao = teclaScanner.nextLine();

                menu.printCriarAtividadeDataInicial();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime dataInicial = LocalDateTime.parse(teclaScanner.nextLine(), formatter);

                menu.printCriarAtividadeDataFinal();
                LocalDateTime dataPrazo = LocalDateTime.parse(teclaScanner.nextLine(), formatter);
                menu.printCriarAtividadeResponsavel();

                Atividades task = new Atividades(nomeAtividade, descricao, dataInicial, dataPrazo, null);
                return task;


            }
            else{
                Atividades task = new Atividades();
                System.out.println("Por favor logue em uma conta de Pesquisador ou Professor");
                task = null;
                return task;
            }
    
        }catch(Exception y){

            System.out.println("!---        ERROR       ----!\nNão existe nenhuma conta Logada\n");

            return null;
        }
    }

}
