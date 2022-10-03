package Interface;

import java.time.LocalDateTime;

import Classes.Pessoa;

public interface Project {
    
    public String getNome();
    public String getDescricao();
    public LocalDateTime getDataInicio();
    public LocalDateTime getDataPrazo();
    public String getNomeResponsavel();
    public void setNome(String nome);
    public void setDescricao(String descricao);
    public void setDataInicio(LocalDateTime dataInicio);
    public void setDataFinal(LocalDateTime dataFinal);
    public void setProfissionais(Pessoa profissional);
}
