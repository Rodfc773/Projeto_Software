package Entidades;

import Interface.Cadastro;

public class Usuarios implements Cadastro{
    protected String email;
    protected String password;
    protected Ruler acceslevel;


    public Usuarios(){

        this.email = "Admin@gmail.com";
        this.password = "admin";
        this.acceslevel = Ruler.Admin;

    }
    public Usuarios(String email, String password, String tipo){

        setAcceslevel(tipo);
        setEmail(email);
        setPassword(password);
    }
    @Override
    public String getPassword(){

        return this.password;
    }
    @Override
    public String getEmail(){

        return this.email;
    }
    @Override
    public Enum<Ruler> getAcessLevel(){

        return this.acceslevel;
    }


    //################ COMEÇO DOS METÓDOS SETTERS ################################

    public void setPassword(String password){

        this.password = password;
    }
    public void setEmail(String email){

        if(!email.contains("@")) return;
        this.email = email;
    }
    public void setAcceslevel(String tipo){

        if(tipo.equals("Professor")|| tipo.equals("Pesquisador")){

            this.acceslevel = Ruler.Coordenador;
        }
        else{

            this.acceslevel = Ruler.Aluno;
        }
    }
    @Override

    public String toString(){

        return "Email: " + this.getEmail() + "\nAcessLevel: " + this.getAcessLevel();
    }
}
