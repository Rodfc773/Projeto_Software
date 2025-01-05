package Funcionalidades;


import Entidades.Ruler;
import Interface.Cadastro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserManagementService {
    private List<Cadastro> users;
    private Cadastro userManager;

    UserManagementService(Cadastro loginAccess){
        users = new LinkedList<>();
        userManager = loginAccess;
    }

    public void addUser(Cadastro newUser){

        if(userManager.getAcessLevel().equals(Ruler.Aluno)){
            throw new RuntimeException("Para acessar esse recurso é nescessário uma conta de nível coordenador");
        }

        Optional<Cadastro> isAlreadyRegistered = findUserByEmail(newUser.getEmail());

        if(isAlreadyRegistered.isPresent()) throw new IllegalArgumentException("O usuário de email: " + newUser.getEmail() + " Já está cadastrado no sistema");

        users.add(newUser);
    }

    public void updateUser(String email, Cadastro updatedUser){
        findUserByEmail(email).ifPresent(user->{
            users.remove(user);
            users.add(updatedUser);
        });
    }
    public boolean removeUser(String userEmailRequested){

        if(userEmailRequested.toLowerCase().contains("admin")){

            throw new RuntimeException("Não é possível remover a conta de administrador");
        }
        return users.removeIf(user -> user.getEmail().equals(userEmailRequested));
    }
    public List<Cadastro> getAllUsers(){
        return new ArrayList<>(users);
    }
    public Optional<Cadastro> findUserByEmail(String email){
        return users.stream().filter(user->user.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public void setUserManager(Cadastro userManager) {
        this.userManager = userManager;
    }

    public Cadastro getUser(){

        return userManager;
    }
}
