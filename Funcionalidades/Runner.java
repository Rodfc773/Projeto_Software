package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Pessoa;
import Entidades.Ruler;
import Entidades.Usuarios;

public class Runner {

    public LinkedList  <Usuarios> users =  new LinkedList<Usuarios>();

    private Usuarios section = new Usuarios();
    private boolean  running = true;

    public void Runner(Usuarios login){
        this.running = true;
        this.run(login);
    }
    private  void run(Usuarios login){
        Sistema menu = new Sistema();
        Scanner scan = new Scanner(System.in);

        while(running){

            try{
                if(login.getAcessLevel().equals(Ruler.Aluno)){

                    System.out.println("!----  Error  ------!\nPara Cadastrar usuarios é nescessario está em uma conta do tipo Administrador");
                    break;
                }
                
                this.section = login;
                System.out.println(this.section != null ? "Seção OK" : "Por favor faça login pra continuar");
                System.out.println("!---------------  1 - Cria Usuário --------------!\n!------------- 0 - encerrar o sistema ---------------!\n");
                if(this.section != null && (this.section.getAcessLevel().equals(Ruler.Admin) || this.section.getAcessLevel().equals(Ruler.Coordenador))) System.out.println("!----------------- 2 - Opção de administrador ------------!" );

                int op = scan.nextInt();
                scan.nextLine();

                switch (op){

                    case 1:
                        if(this.section == null || this.section.getAcessLevel().equals(Ruler.Aluno)){
                            System.out.println("Por favor logue em uma conta do tipo administrador para usar a função");
                            break;
                        }
                        else{
                            users.add(createNewUser());
                        }

                        break;
                        case 2:

                            System.out.println("!----------- FUNCIONALIDADES DE ADMINISTRADOR -----------!");
                            System.out.println("!-----------        1 - Remover                 -----------!");
                            System.out.println("!-----------        2 - Editar informações      -----------!");

                            int op2 = scan.nextInt();
                            scan.nextLine();

                            switch(op2){

                                case 1: 
                                    remover(scan);
                                    break;
                                case 2:
                                    editar(scan);
                                    break;
                                default:
                                    break;
                            }
                    case 0:
                        running = false;
                        break;
                    default:
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
        public LinkedList<Usuarios> remover(Scanner scan){

        System.out.println("Digite o email do aluno que queira retirar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){
            System.out.println("Não é permitido remover o Administrador");
        }

        for (Usuarios user : this.users){

            if(user.getEmail().equals(email)){

                users.remove(user);
                System.out.println("\n" +"Email: " +user.getEmail() + "\nFoi removido com sucesso");
            }
        }
        return this.users;
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
                System.out.println("Bye bye " + login.getEmail());
                return null;
            }

            Sistema menu = new Sistema();
            Scanner scan = new Scanner(System.in);
            menu.printLogin();
            String email = scan.nextLine();

            System.out.println("Digite a senha: ");
            String password = scan.nextLine();

            for (Usuarios user : users){

                if((user.getEmail().equals(email) && user.getPassword().equals(password))){

                    this.section = user;
                    System.out.println("Seja bem vindo: " +this.section.getEmail());
                    break;
                }
                else{
                    this.section = null;
                }

            }
            System.out.println(this.section == null ? "Nenhum Usuário encontrado com esse login" : "Login bem sucedido!"); 
            return this.section;
        }
}
