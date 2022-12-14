package Classes;

import java.util.LinkedList;

public class Atividades {
    private int id;
    private String nomeAtividade;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private LinkedList<Usuarios> profissionais;
    private Usuarios responsavel;


    //################################      METODOO CONSNTRUTOS ###############################################

    public Atividades(){

        this.id = 0;
        this.nomeAtividade = null;
        this.descricao = null;
        this.dataInicio = null;
        this.dataFim = null;
        this.profissionais = new LinkedList<Usuarios>();
        this.responsavel = null;
    }
    //#################################     METODOS GETTERS #######################################################
    public int getID(){

        return this.id;
    }
    public String getDescricao(){

        return this.descricao;
    }
    public String  getDataInicial(){

        return this.dataInicio;
    }
    public String getDataFim(){

        return this.dataFim;
    }
    public String getName(){

        return responsavel.getNome();
    }
    public String getNomeAtvd(){

        return this.nomeAtividade;
    }

    //##################################### METODOS SETTERS ##################################################333
    public void SetID(int id){

        this.id = id;
    }
    public void setDescricao(String descricao){

        this.descricao = descricao; 
    }
    public void setDataInicio(String dataInicio){

        this.dataInicio = dataInicio;
    }
    public void setDataFinal(String dataFinal){

        this.dataFim = dataFinal;
    }
    public void setResponsavel(Usuarios responsavel){

        this.responsavel = responsavel;
    }
    public void setProfissionais(Usuarios profissionais){

        this.profissionais.add(profissionais);

    }
    public void setNomeAtividae(String nomeAtividade){

        this.nomeAtividade = nomeAtividade;
    }
}
