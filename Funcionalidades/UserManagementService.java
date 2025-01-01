package Funcionalidades;


import Interface.Cadastro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserManagementService {
    private List<Cadastro> users;

    UserManagementService(){
        users = new LinkedList<>();
    }

    public void addUser(Cadastro newUser){

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
        return users.removeIf(user -> user.getEmail().equals(userEmailRequested));
    }
    public List<Cadastro> getAllUsers(){
        return new ArrayList<>(users);
    }
    public Optional<Cadastro> findUserByEmail(String email){
        return users.stream().filter(user->user.getEmail().equalsIgnoreCase(email)).findFirst();
    }
}
