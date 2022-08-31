package Classes;

import java.io.ObjectInputFilter.Status;
import java.util.LinkedList;
import java.util.Scanner;

public class Projeto {
   
    public int id;
    public String status;
    public String descricao;
    public String data_inicio;
    public String data_termino;
    public LinkedList <Usuarios>profissionais;
    public Usuarios coordenador;

    public void Criar(int id){

        System.clearProperty("clear");
        this.id = id;
        status = "Em processo de criacao";
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a data inicial: ");
        data_inicio = teclado.nextLine();

        System.out.println("Digite a data de termino: ");
        data_termino = teclado.nextLine();

        System.out.println("Digite uma descricao: ");

        descricao = teclado.nextLine();

        System.out.println("Associe um coordenador ao projeto: ");


    }
    
    public void editar(){

        System.out.println("Dejesa editar quais dados?");
        System.out.println("1 : Status");
        System.out.println("2 : Descrição");
        System.out.println("3 : Data de termino");
        System.out.println("4 : Profissionais envolvidos");
        System.out.println("5 : Coordenador");

    }
}      
