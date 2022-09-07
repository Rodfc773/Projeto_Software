package Classes;

import java.util.LinkedList;
//import java.time.LocalDate;

public class Projeto {
   
    private int id;
    private String status;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private LinkedList <Usuarios>profissionais;
    private Usuarios coordenador;


    //############################## MÉTODOS GETTERS ######################################################
    public int getId(){

        return this.id;
    }
    public String getStatus(){

        return this.status;
    }
    public String getDescricao(){

        return this.descricao;
    }
    public String getDataInicio(){

        return this.dataInicial;
    }
    public String getDataTermino(){

        return this.dataFinal;
    }
    public String getCoordenadorNome(){

        return this.coordenador.getNome();
    }


    //######################## MÉTODOS SETTERS #############################
    public void setID(int id){

        this.id = id;
    }

    public void setStatus(String status){

        this.status = status;
    }

    public void setDescricao(String descricao){

        this.descricao = descricao;
    }

    public void setdataInicial(String dataInicial){

        this.dataInicial = dataInicial;
        
    }
    public void setDataFinal(String dataFinal){

        this.dataFinal = dataFinal;
    }
    public void setCoodernador(Usuarios coordenador){

        this.coordenador = coordenador;
    }
    public void setProfissionais(Usuarios profissional){

        this.profissionais.add(profissional);
    }
}      
