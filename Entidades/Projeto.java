package Entidades;

import java.time.LocalDateTime;
import java.util.LinkedList;
//import java.time.LocalDate;

import Interface.Project;

public class Projeto implements Project{

    private String nomeProjeto;
    public Status status;
    private String descricao;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private LinkedList <Pessoa> profissionais;
    private LinkedList <Atividades> tasks;
    private Pessoa coordenador;

    public Projeto(){
        this.nomeProjeto = null;
        this.status = Status.CRIADO;
        this.descricao = null;
        this.dataInicial = null;
        this.dataFinal = null;
        this.profissionais = new LinkedList<Pessoa>();
        this.tasks = new LinkedList<Atividades>();
        this.coordenador = null;
    }
    public Projeto(String nome, String descricao, LocalDateTime dataInicio,LocalDateTime dataPrazo, Pessoa coordenador){
        this.setCoodernador(coordenador);
        this.setDataInicio(dataInicio);
        this.setDataFinal(dataPrazo);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setStatus();
        this.profissionais = new LinkedList<Pessoa>();
        this.tasks = new LinkedList<Atividades>();
    }
    //############################## MÉTODOS GETTERS ######################################################
    @Override
    public String getNome(){

        return this.nomeProjeto;
    }
    @Override
    public String getDescricao(){

        return this.descricao;
    }
    @Override
    public LocalDateTime getDataInicio(){

        return this.dataInicial;
    }
    @Override
    public LocalDateTime getDataPrazo(){

        return this.dataFinal;
    }
    @Override
    public String getNomeResponsavel(){

        return this.coordenador.getNome();
    }
    public Usuarios getCoordenador(){

        return this.coordenador;
    }
    public LinkedList <Pessoa> getProfissionais()
    {
            return this.profissionais;

    }
    public Enum<Status> getStatus(){

        return this.status;
    }
    public LinkedList <Atividades> getTasks(){

        return this.tasks;
    }


    //######################## MÉTODOS SETTERS #############################
    @Override
    public void setDescricao(String descricao){

        this.descricao = descricao;
    }
    @Override
    public void setDataInicio(LocalDateTime dataInicial){

        this.dataInicial = dataInicial;

    }
    @Override
    public void setDataFinal(LocalDateTime dataFinal){

        this.dataFinal = dataFinal;
    }
    public void setCoodernador(Pessoa coordenador){

        this.coordenador = coordenador;
    }
    public void setStatus(){
        this.status = Status.CRIADO;
    }
    @Override
    public void setProfissionais(Pessoa profissional){

        this.profissionais.add(profissional);
    }
    public void setStatusIniciado(){

        this.status = Status.INICIADO;
    }
    public void setStatusAndamento(){
        this.status = Status.EM_ANDAMENTO;
    }
    public void setStatusFinalizado(){
        this.status = Status.FINALIZADO;
    }
    public void setTasks(Atividades task){

        this.tasks.add(task);
    }
    @Override
    public void setNome(String nome){

        this.nomeProjeto = nome;
    }

    public String toString(){

        return "Nome do Projeto: " + this.getNome() + "\nDescrição: " + this.getDescricao() + "\nStatus: " + this.getStatus() +  "\nData de inicio: " + this.getDataInicio() + "\nData de a ser Encerrado/Encerramento: " +this.getDataPrazo() + "\nCoordenador: " + this.getNomeResponsavel();
    }
}
