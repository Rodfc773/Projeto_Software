package Entidades;

public enum Ruler {

    Admin("administrador"), Coordenador("coordenador"),  Aluno("aluno");

    private final String description;

    Ruler(String description){
        this.description =  description;
    }
}
