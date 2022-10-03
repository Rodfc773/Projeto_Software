package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Pessoa;
import Classes.Ruler;
import Classes.Usuarios;

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
        this.section = login;

        while(running){

            if(this.section == null || this.section.getAcessLevel().equals(Ruler.Aluno)){

                System.out.println("!----  Error  ------!\nPara Cadastrar usuarios é nescessario está em uma conta do tipo Administrador");
                break;
            }
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
                                remover();
                                break;
                            case 2:
                                editar();
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
        }
    }
    private Usuarios createNewUser(){

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
    private void remover(){

        Scanner scan = new Scanner(System.in);
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
    }
    private void editar(){

        Scanner scan = new Scanner(System.in);
        Sistema menu = new Sistema();

        System.out.println("Digite o email da conta que queira Editar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){

            System.out.println("Não é permitido Editar o Administrador");
        }
        else{

            Pessoa aux = new Pessoa();

            for(Usuarios user : users){

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
                    
                    String nome = scan.nextLine();
                    aux.setNome(nome);
                    break;
                case 2:
                    String tipo = scan.nextLine();
                    aux.setTipo(tipo);
                
                case 3:
                    aux.setpBolsa();
                    aux.setBolsa();
                    aux.setPeriodoBolsa(scan);

                case 4:
                    
            
                default:
                    break;
            }
        }
       
    }
    public  Usuarios login(){

        if(users.isEmpty()){

            System.out.println("Não tem nenhum usuarios cadastrados, por favor cadastre um");
            return null;
        }

        Sistema menu = new Sistema();
        Scanner scan = new Scanner(System.in);
        menu.printLogin();
        String email = scan.nextLine();

        System.out.println("Digite a senha: ");
        String password = scan.nextLine();

        for (Usuarios user : users){

            if(!(user.getEmail().equals(email) && user.getPassword().equals(password))){

                this.section = null;
                continue;
            }

            this.section = user;
            System.out.println("Seja bem vindo: " +this.section.getEmail());
            break;
        }
        return this.section;
    }
}
