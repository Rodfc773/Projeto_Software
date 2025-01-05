package Funcionalidades;

import Interface.Cadastro;

import java.util.List;

public class SessionManagement {

    public static Cadastro login(String userEmail, String password, List<Cadastro> users){

        for(Cadastro user: users){

            if(user.getEmail().equalsIgnoreCase(userEmail) && user.getPassword().equals(password)) {return  user;}
        }
        return null;
    }

    public static Cadastro logout(){

        return null;
    }
}
