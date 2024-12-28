package Entidades;

import java.time.LocalDateTime;
import java.util.LinkedList;

import Interface.Project;

public class Atividades implements Project{
    private String nomeAtividade;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LinkedList<Pessoa> profissionais;
    private Pessoa responsavel;


    //################################      METODOO CONSNTRUTOS ###############################################

    public Atividades(){
        this.nomeAtividade = null;
        this.descricao = null;
        this.dataInicio = null;
        this.dataFim = null;
        this.profissionais = new LinkedList<Pessoa>();
        this.responsavel = null;
    }
    public Atividades(String nome, String descircao, LocalDateTime dataInicio, LocalDateTime dataPrazo, Pessoa responsavel){

        this.setDataFinal(dataPrazo);
        this.setDataInicio(dataInicio);
        this.setNome(nome);
        this.setDescricao(descircao);
        this.setResponsavel(responsavel);
    }
    //#################################     METODOS GETTERS #######################################################
    @Override
    public String getDescricao(){

        return this.descricao;
    }
    @Override
    public LocalDateTime getDataInicio(){

        return this.dataInicio;
    }
    @Override
    public LocalDateTime getDataPrazo(){

        return this.dataFim;
    }
    public String getNomeResponsavel(){

        return responsavel.getNome();
    }
    @Override
    public String getNome(){

        return this.nomeAtividade;
    }

    //##################################### METODOS SETTERS ##################################################
    public void setDescricao(String descricao){

        this.descricao = descricao; 
    }
    public void setDataInicio(LocalDateTime dataInicio){

        this.dataInicio = dataInicio;
    }
    public void setDataFinal(LocalDateTime dataFinal){

        this.dataFim = dataFinal;
    }
    public void setResponsavel(Pessoa responsavel){

        this.responsavel = responsavel;
    }
    public void setProfissionais(Pessoa profissionais){

        this.profissionais.add(profissionais);

    }
    @Override
    public void setNome(String nomeAtividade){

        this.nomeAtividade = nomeAtividade;
    }
    public String toString(){

        return "Nome da Atividade: " + this.getNome() + "\nDescricao: " + this.getDescricao() + "\nData de inicio: " +this.getDataInicio() + "\nData limite da atividade: " + this.getDataPrazo() + "\nResponsavel pela atividade: " + this.getNomeResponsavel();
    }
}
