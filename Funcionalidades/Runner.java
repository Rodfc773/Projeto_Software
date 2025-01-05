package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Pessoa;
import Entidades.Ruler;
import Entidades.Usuarios;
import Interface.Cadastro;

public class Runner {

    private Cadastro section = new Usuarios();
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

        Sistema menuSistema = new Sistema();
        Scanner tecladoScanner =  new Scanner(System.in);


        menuSistema.printCriarUsuarioNome();
        String nome = tecladoScanner.nextLine();

        menuSistema.printCriarUsuarioTipo();
        String tipo = tecladoScanner.nextLine();


        menuSistema.printCriarUsuarioEmail();
        String email = tecladoScanner.nextLine();

        menuSistema.printCriarUsuarioPassword();
        String password = tecladoScanner.nextLine();


        Pessoa user = new Pessoa(email, password, nome, tipo,tecladoScanner);

        return (Usuarios) user;
    }
        public boolean remover(Scanner scan){

        System.out.println("Digite o email do aluno que queira retirar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){
            System.out.println("Não é permitido remover o Administrador");
        }

        return userService.removeUser(email);

    }
    public LinkedList<Usuarios> editar(Scanner scan){

        Sistema menu = new Sistema();

        System.out.println("Digite o email da conta que queira Editar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){

            System.out.println("Não é permitido Editar o Administrador");
        }
        else{

            Pessoa aux = new Pessoa();

            for(Usuarios user : this.users){

                if(user.getEmail().equals(email)){

                    aux = (Pessoa) user;
                    this.users.remove(user);
                    break;
                }
            }

            menu.printEditarUsuarios();
            int option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1:
                    System.out.println("Digite o novo nome a ser cadastrado: ");
                    String nome = scan.nextLine();
                    aux.setNome(nome);
                    break;
                case 2:
                    System.out.println("Digite o novo Tipo a ser cadastrado: ");

                    String tipo = scan.nextLine();
                    aux.setTipo(tipo);
                    break;
                
                case 3:
                    System.out.println("Cadastre a bolsa: ");

                    aux.setpBolsa();
                    aux.setBolsa();
                    aux.setPeriodoBolsa(scan);
                    break;
                case 4:
                    System.out.println("Digite o novo email: ");
                    String emailSec = scan.nextLine();

                    aux.setEmail(emailSec);
                    break;
                case 5:
                    System.out.println("Digite a nova senha: ");

                    String password = scan.nextLine();

                    aux.setPassword(password);
                    break;
                default:
                    break;
            }
            this.users.add(aux);
        }
       return this.users;
    }
    public  Usuarios login(Usuarios login){

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
