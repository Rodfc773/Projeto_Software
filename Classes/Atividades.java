package Classes;

import java.util.LinkedList;
import java.util.Scanner;

public class Atividades {
    
    public int id;
    public String descricao;
    public String data_inicio;
    public String data_fim;
    public LinkedList<Usuarios >responsavel;
    public LinkedList <Usuarios> profissionais;

    public void criar(int id){

        this.id = id;

        System.out.println("Digite a Descrição da atividade: ");
        Scanner tecaladoScanner = new Scanner(System.in);

        descricao = tecaladoScanner.nextLine();

        System.out.println("Digite a Data de inicio da atividade: ");
        data_inicio = tecaladoScanner.nextLine();

        System.out.println("Digite o Prazo da atividade: ");
        data_fim = tecaladoScanner.nextLine();

    }
}
