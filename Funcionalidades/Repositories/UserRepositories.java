package Funcionalidades.Repositories;

import Entidades.Ruler;
import Entidades.Usuarios;
import Interface.Cadastro;
import Interface.Repository;

import java.util.*;

public class UserRepositories implements Repository<Cadastro> {

    private static List<Cadastro> users;

    UserRepositories(){
        users = new LinkedList<>();
    }
    @Override
    public Cadastro create(Cadastro newUser) {

        users.add(newUser);
        return newUser;
    }

    @Override
    public Cadastro edit(Map<String, String> informationsToEdit, String targetEmail) {

        Usuarios userToEdit = null;
        for(Cadastro user:  users){
            if(user.getEmail().equalsIgnoreCase(targetEmail) && user instanceof Usuarios){

                String email = informationsToEdit.get("email") != null ? informationsToEdit.get("email") : user.getEmail();
                String password = informationsToEdit.get("password") != null ? informationsToEdit.get("password") : user.getEmail();
                String acessLevel = informationsToEdit.get("accesLevel") != null ? informationsToEdit.get("accessLevel") : user.getAcessLevel();


                ((Usuarios) user).setPassword(password);
                ((Usuarios) user).setEmail(email);
                ((Usuarios) user).setAcceslevel(acessLevel);
                userToEdit = (Usuarios) user;

                break;

            }
        }

        if(userToEdit == null) throw new RuntimeException("Usuário não encontrado");

        return  userToEdit;

    }

    @Override
    public Cadastro remove() {
        return null;
    }

    @Override
    public Cadastro listAll() {
        return null;
    }

    @Override
    public Cadastro searchOne() {
        return null;
    }
}
