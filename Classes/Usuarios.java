package Classes;

import java.util.Scanner;

public class Usuarios {
    
    int id;
    public String nome;
    public String tipo;
    //Variavel para identificar qual o tipo de usuario: aluno de graduação, mestrado e etc......
    public float bolsa;
    public String periodo_bolsa;

    public void Cadastro(){

        Scanner tecla = new Scanner(System.in);
        System.out.println("Cadastre o nome do usuario: ");
        nome = tecla.nextLine();

        System.out.println("Informe o tipo, ex(Aluno de mestrado): ");
        tipo = tecla.nextLine();

        bolsa = 0.0f;
        periodo_bolsa = null;
    }

    public void coordenador(){

        Scanner tecla = new Scanner(System.in);
        System.out.println("Cadastre o nome do Coordenador: ");
        nome = tecla.nextLine();

        System.out.println("Informe o tipo, ex(Aluno de mestrado): ");
        tipo = tecla.nextLine();

        bolsa = 0.0f;
        periodo_bolsa = null;
    }
}
