package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

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

            if(this.section == null || this.section.type != Ruler.ADMIN){

                System.out.println("!----  Error  ------!\nPara Cadastrar usuarios é nescessario está em uma conta do tipo Administrador");
                break;
            }
            System.out.println(this.section != null ? "Seção OK" : "Por favor faça login pra continuar");
            System.out.println("!---------------  1 - Cria Usuário --------------!\n!------------- 0 - encerrar o sistema ---------------!\n");
            if(this.section != null && this.section.type == Ruler.ADMIN) System.out.println("!----------------- 2 - Opção de administrador ------------!" );

            int op = scan.nextInt();
            scan.nextLine();

            switch (op){

                case 1:
                    if(this.section == null || this.section.type != Ruler.ADMIN){
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
                                users = remover(users);
                                break;
                            case 2:
                                users = editar(users);
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

        Usuarios user = new Usuarios();
        Sistema menuSistema = new Sistema();
        Scanner tecladoScanner =  new Scanner(System.in);


        menuSistema.printCriarUsuarioNome();
        String nome = tecladoScanner.nextLine();
        user.setNome(nome);

        menuSistema.printCriarUsuarioTipo();
        String tipo = tecladoScanner.nextLine();
        user.setTipo(tipo);

        if(tipo.equals("Professor") || tipo.equals("Pesquisador")){

            user.type = Ruler.ADMIN;
        }
        else{
            user.type = Ruler.DEFAULT;
        }

        menuSistema.printCriarUsuarioEmail();
        String email = tecladoScanner.nextLine();
        user.setEmail(email);

        menuSistema.printCriarUsuarioPassword();
        String password = tecladoScanner.nextLine();
        user.setPassword(password);

        menuSistema.printCriarUsuarioPossuiBolsa();
        int opcao = tecladoScanner.nextInt();
        tecladoScanner.nextLine();

        switch(opcao){

            case 1:
                user.setPossuiBolsa(true);

                menuSistema.printCriarBolsa();
                double bolsa = tecladoScanner.nextDouble();
                user.setBolsa(bolsa);
                tecladoScanner.nextLine();

                menuSistema.printCriarUsuarioPeriodoBolsa();
                String periodoBolsa = tecladoScanner.nextLine();
                user.setPeriodoBolsa(periodoBolsa);

                break;
            case 2:

                user.setPossuiBolsa(false);
                user.setBolsa(0.0);
                break;
        }
        user.setID(users.size() + 1);
        return user;
    }
    private LinkedList <Usuarios> remover(LinkedList <Usuarios> users){

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o email do aluno que queira retirar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){

            System.out.println("Não é permitido remover o Administrador");

            return users;
        }

        for (Usuarios user : users){

            if(user.getEmail().equals(email)){

                users.remove(user);
                System.out.println("O usuario: " +user.getNome() + "\n" +"Email: " +user.getEmail() + "\nFoi removido com sucesso");
                return users;
            }
        }
        System.out.println("!-----------            ERROR           ---------!");
        System.out.println("!-----------        O usuário não existe ---------!");
        return users;
    }
    private LinkedList <Usuarios> editar(LinkedList <Usuarios> users){

        Scanner scan = new Scanner(System.in);
        Sistema menu = new Sistema();

        System.out.println("Digite o email da conta que queira Editar: ");
        String email = scan.nextLine();

        if(email.equals("Admin@gmail.com")){

            System.out.println("Não é permitido Editar o Administrador");

            return users;
        }

        Usuarios aux = new Usuarios();



        for (Usuarios user : users){

            if(user.getEmail().equals(email)){

                menu.printEditarUsuarios();
                int op = scan.nextInt();
                scan.nextLine();

                switch (op){

                    case 1:
                        System.out.println("Digite o novo nome do usuário: ");
                        String nome = scan.nextLine();
                        user.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Digite o novo tipo do usuário: ");
                        String tipo = scan.nextLine();

                        if(tipo.equals("Professor") || tipo.equals("Coordenador")){

                            user.type = Ruler.ADMIN;
                        }
                        aux.setTipo(tipo);

                        break;

                    case 3:
                        System.out.println("Digite se o usuário possuí bolsa(1 : Sim || 2 : Não");
                        int op2 = scan.nextInt();
                        scan.nextLine();

                        if(op2 == 1){

                            user.setPossuiBolsa(true);
                            System.out.println("Digite o valor da bolsa: ");
                            Double valorBolsa = scan.nextDouble();
                            

                            System.out.println("Digite o período da bolsa: ");
                            
                            String periodoBolsa = scan.nextLine();

                            user.setBolsa(valorBolsa);
                            user.setPeriodoBolsa(periodoBolsa);
                        }

                    case 4:
                        if(user.getPossuiBolsa() == false){
                            System.out.println("O usuário não possui bolsa");
                            break;
                        }
                        System.out.println("Digite o novo periodo da bolsa: ");
                        String periodoBolsa = scan.nextLine();
                        user.setPeriodoBolsa(periodoBolsa);

                        break;
                    case 5:
                        System.out.println("Digite o novo Email do usuário: ");
                        email = scan.nextLine();
                        user.setEmail(email);

                        break;
                    case 6:
                        System.out.println("Digite a nova senha desse usuário: ");
                        String password = scan.nextLine();
                        user.setPassword(password);
                        break;
                    default:
                        break;
                }

                break;
            }
        }
        return users;
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
