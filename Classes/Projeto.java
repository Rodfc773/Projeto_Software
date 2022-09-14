package Classes;

import java.util.LinkedList;
//import java.time.LocalDate;

public class Projeto {

    private int id;
    private String nomeProjeto;
    public Status status = Status.CRIADO;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private LinkedList <Usuarios> profissionais;
    private LinkedList <Atividades> tasks;
    private Usuarios coordenador;

    public Projeto(){
        this.id = 0;
        this.nomeProjeto = null;
        this.status = Status.CRIADO;
        this.descricao = null;
        this.dataInicial = null;
        this.dataFinal = null;
        this.profissionais = new LinkedList<Usuarios>();
        this.tasks = new LinkedList<Atividades>();
        this.coordenador = null;
    }
    //############################## MÉTODOS GETTERS ######################################################
    public int getId(){

        return this.id;
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
    public Usuarios getCoordenador(){

        return this.coordenador;
    }
    public LinkedList <Usuarios> getProfissionais()
    {
            return this.profissionais;

    }
    public Enum getStatus(){

        return this.status;
    }
    public String getNomeProjeto(){

        return this.nomeProjeto;
    }
    public LinkedList <Atividades> getTasks(){

        return this.tasks;
    }


    //######################## MÉTODOS SETTERS #############################
    public void setID(int id){

        this.id = id;
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
    public void setStatus(){
        this.status = Status.CRIADO;
    }
    public void setProfissionais(Usuarios profissional){

        this.profissionais.add(profissional);
    }
    public void setStatusIniciado(){

        this.status = Status.INICIADO;
    }
    public void setStatusAndamento(){
        this.status = Status.ANDAMENTO;
    }
    public void setStatusFinalizado(){
        this.status = Status.FINALIZADO;
    }
    public void setNomeProjeto(String nomeProjeto){
        this.nomeProjeto = nomeProjeto;
    }
    public void setTasks(Atividades task){

        this.tasks.add(task);
    }
}
