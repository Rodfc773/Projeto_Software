package Interface;

import Classes.Ruler;

public interface Cadastro {
    
    public String getEmail();
    public String getPassword();
    public Enum<Ruler> getAcessLevel();
}