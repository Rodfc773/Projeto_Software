package Entidades;

import java.time.LocalDateTime;
import java.util.Scanner;


public class Pessoa extends Usuarios{

    private String cpf;
    protected String nome;
    private String tipo;
    //Variavel para identificar qual o tipo de usuario: aluno de graduação, mestrado e etc......
    protected Boolean pBolsa;
    private Double bolsa;
    private LocalDateTime periodoBolsa;


    public Pessoa(){

        this.cpf = null;
        this.nome = null;
        this.tipo = "Gerente do Sistema";
        this.pBolsa = false;
        this.bolsa = 0.0;
        this.periodoBolsa = null;

    }
    public Pessoa(String email,String password, String nome, String tipo, Scanner scan){

        this.setAcceslevel(tipo);
        this.setEmail(email);
        this.setPassword(password);
        this.setNome(nome);
        this.setTipo(tipo);
        this.setpBolsa();
        this.setBolsa();
        this.setPeriodoBolsa(scan);

    }
//      METODOS GETTERS
    @Override
    public String getEmail(){

        return this.email;
    }
    @Override
    public String getPassword(){

        return this.password;
    }
    public String getNome(){

        return this.nome;
    }
    public String getTipo(){

        return this.tipo;
    }
    public String getCPF(){

        return this.cpf;
    }
    public Boolean getTemBolsa(){

        return this.pBolsa;

    }
    public  Double getBolsa(){

        return this.bolsa;
    }

    public LocalDateTime getPeriodoBolsa(){

        return this.periodoBolsa;
    }
    // METODOS SETTERS

    @Override
    public void setEmail(String email){

        this.email = email;
    }
    @Override
    public void setPassword(String password){

        this.password = password;
    }
    public void setNome(String nome){

        this.nome = nome;
    }
    public void setTipo(String tipo){

        this.tipo = tipo;
    }
    public void setpBolsa(){

        System.out.println("O usário: " + this.getEmail() + ", de nome: " +this.getNome() +"\nPossui bolsa?(0: NAO || 1 : SIM): ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        scan.nextLine();

        if(option == 1)this.pBolsa = true;
        else this.pBolsa = false;
    }
    public void setBolsa(){
        
        if(!(this.pBolsa)) this.bolsa = 0.0;

        else{

            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o valor da bolsa: ");
            this.bolsa = scan.nextDouble();
            scan.nextLine();
        }
    }

    public void setPeriodoBolsa(Scanner scan){

       if(this.getTemBolsa()){

            System.out.println("Digite a duração de meses da bolsa: ");
            int meses = scan.nextInt();
            scan.nextLine();

            this.periodoBolsa = LocalDateTime.now();

            meses += periodoBolsa.getMonthValue();
            int year = this.periodoBolsa.getYear();

            if(meses > 12){

                year += meses/12;
                meses = meses % 12;
            }

            this.periodoBolsa = LocalDateTime.of(year, meses, this.periodoBolsa.getDayOfMonth(), this.periodoBolsa.getHour(), this.periodoBolsa.getMinute(), this.periodoBolsa.getSecond());
        }
    }
    @Override
    public String toString(){

        if(this.getTemBolsa()){

            return "Email: " + this.getEmail() + "\nNivel de acesso: "+this.getAcessLevel() + "\nNome: " +this.getNome() + "\nTipo: " + this.getTipo() + "\nPossui bolsa?: " +this.getTemBolsa() + "\nPrazo da bolsa: " + getPeriodoBolsa();
        }
        else{
        return "Email: " + this.getEmail() + "\nNivel de acesso: "+this.getAcessLevel() + "\nNome: " +this.getNome() + "\nTipo: " + this.getTipo() + "\nPossui bolsa?: " +this.getTemBolsa();
        }

    }
}
