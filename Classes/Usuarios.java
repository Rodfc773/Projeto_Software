package Classes;

public class Usuarios {
    private int id;
    private String nome;
    private String tipo;
    //Variavel para identificar qual o tipo de usuario: aluno de graduação, mestrado e etc......
    private Boolean possuiBolsa;
    private Double bolsa;
    private String periodoBolsa;
    private String email;
    private String password;
    public Ruler type = Ruler.DEFAULT;
    public Usuarios(){

        this.id = 0;
        this.nome = "Admin";
        this.tipo = "Administrador";
        this.possuiBolsa = false;
        this.bolsa = 0.0;
        this.periodoBolsa = "None";
        this.email = "Admin@gmail.com";
        this.password = "Adminprojetos";
        this.type = Ruler.ADMIN;
    }

    public int getID(){

        return this.id;

    }
    public String getNome(){

        return this.nome;
    }
    public String getTipo(){

        return this.tipo;
    }
    public Double getBolsa(){

        return this.bolsa;
    }
    public String getPeriodoBolsa(){

        return this.periodoBolsa;
    }
    public String getPassword(){

        return this.password;
    }
    public String getEmail(){

        return this.email;
    }
    public Boolean getPossuiBolsa()
    {
        return this.possuiBolsa;
    }
    public Enum getAcessLevel(){

        return this.type;
    }


    //################ COMEÇO DOS METÓDOS SETTERS ################################


    public void setID(int id){

        this.id = id;
    }

    public void setNome(String nome){

        this.nome = nome;
    }
    public void setBolsa(double bolsa){

        this.bolsa = bolsa;
    }
    public void setPeriodoBolsa(String periodoBolsa){

        this.periodoBolsa = periodoBolsa;
    }
    public void setTipo(String tipo){

        this.tipo = tipo;
    }
    public void setPassword(String password){

        this.password = password;
    }
    public void setEmail(String email){

        if(!email.contains("@")) return;
        this.email = email;
    }
    public void setPossuiBolsa(Boolean possuiBolsa){

        this.possuiBolsa = possuiBolsa;
    }
}
