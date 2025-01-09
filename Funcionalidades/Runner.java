package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Pessoa;
import Entidades.Ruler;
import Entidades.Usuarios;
import Interface.Cadastro;

public class Runner {

    private Cadastro section;
    private boolean  running = true;
    private UserManagementService userService = new UserManagementService(this.section);

    public void Runner(Usuarios login){
        this.running = true;
        this.run(login);
    }
    private  void run(Usuarios login){
        Sistema menu = new Sistema();
        Scanner scan = new Scanner(System.in);

        while(running){

            try{

                this.section = login;

                userService.setUserManager(section);

                Sistema.createUserMenuBeforeOpt();

                int op = scan.nextInt();
                scan.nextLine();

                switch (op){

                    case 1:

                        userService.addUser(createNewUser());
                        break;
                    case 2:

                        Sistema.adminOptInCreateUser();
                        int op2 = scan.nextInt();
                        scan.nextLine();

                        if(op2 == 1) remover(scan);
                        if (op2 == 2) editar(scan);

                        break;

                    case 0:
                        running = false;
                        break;
                    default:
                        running = false;
                        break;
                }
            }catch(Exception e){

                System.out.println("Não existe nenhuma conta logada, por favor faça login primeiro");
            }
        }
    }
    public Usuarios createNewUser(){



        return user;
    }
        public boolean remover(Scanner scan){

        System.out.println("Digite o email do aluno que queira retirar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){
            System.out.println("Não é permitido remover o Administrador");
        }

        return userService.removeUser(email);

    }
    public void editar(Scanner scan) {

    }
    public Cadastro login(Usuarios login){

            if(login != null){
                System.out.println("Você ja está conectado ao sistema" + login.getEmail());
                return login;
            }

            Sistema menu = new Sistema();
            Scanner scan = new Scanner(System.in);
            menu.printLogin();
            String email = scan.nextLine();

            System.out.println("Digite a senha: ");
            String password = scan.nextLine();


            this.section = SessionManagement.login(email, password, userService.getAllUsers());
            System.out.println(this.section == null ? "Nenhum Usuário encontrado com esse login" : "Login bem sucedido!"); 
            return this.section;
        }
}
