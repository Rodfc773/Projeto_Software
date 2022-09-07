package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

public class Editar {
    
    public Projeto editarProjeto(Projeto projeto, LinkedList <Usuarios> users){

        Scanner teclado = new Scanner(System.in);
        Sistema menu = new Sistema();
        System.out.println("Para editar um projeto, é preciso está logado em um conta de tipo coordenardor");
        System.out.println("Por favor faça o login");
        /*Login login = new Login();
        
        boolean verify = false;

        while(verify == false){

            verify = login.verificarLogin(users);
        }
        */
        

        menu.printEditarProjeto();
        int op = teclado.nextInt();
        teclado.nextLine();

        switch(op){

            case 1:
                menu.printEditarProjetoDescricao();
                String newdescription = teclado.nextLine();

                projeto.setDescricao(newdescription);

                break;
            case 2:
                menu.printEditarProjetoPrazo();
                String dataFinal = teclado.nextLine();
                projeto.setDataFinal(dataFinal);

                break;
            default:
                break;       
        }

        return projeto;
    }
    public Atividades editarAtividades(Atividades task, LinkedList <Usuarios> users){

        Scanner teclado = new Scanner(System.in);
        Sistema menu = new Sistema();
        System.out.println("Por favor faça o login");
        Login login = new Login();

        /*boolean verify = false;

        while(verify == false){

            verify = login.verificarLogin(users);
        }
        */
        menu.printEditarAtividades();

        int op = teclado.nextInt();
        teclado.nextLine();

        switch(op){

            case 1:
                menu.printEditarAtividadesDescricao();
                String descricao = teclado.nextLine();
                task.setDescricao(descricao);

                break;
            case 2:
                menu.printEditarAtividadesPrazo();
                String prazo = teclado.nextLine();
                task.setDataFinal(prazo);

                break;

            default:
                break;
        }
        

        
        return task;
    }
    public Usuarios editarUser(Usuarios user, LinkedList<Usuarios>users){
        
        Sistema menu = new Sistema();
        Scanner scan = new Scanner(System.in);
        
        menu.printEditarUsuarios();
        int option = scan.nextInt();
        scan.nextLine();

        switch(option){

            case 1:
                System.out.println("Digite o novo nome do usuário: ");
                String nome = scan.nextLine();

                user.setNome(nome);

                break;
            case 2:
                System.out.println("Digite o tipo: ");
                String tipo = scan.nextLine();

                user.setTipo(tipo);

                break;
            case 3:

                System.out.println("Informe se ele possui bolsa(1 : sim || 0 : n");
                int op = scan.nextInt();

                if(op == 1){

                    user.setPossuiBolsa(true);
                    System.out.println("Informe o valor da bolsa: ");
                    user.setBolsa(scan.nextDouble());
                    scan.nextLine();
                    System.out.println("Informe o periodo da bolsa: ");
                    String periodo = scan.nextLine();

                    user.setPeriodoBolsa(periodo);
                }

                else{
                    user.setBolsa(0.0);
                    user.setPossuiBolsa(false);
                }
                break;
            case 4:

                if(user.getPossuiBolsa()){

                    System.out.println("Informe o novo periodo da bolsa: ");
                    String periodoBolsa = scan.nextLine();
                    user.setPeriodoBolsa(periodoBolsa);
                }
                else{
                    System.out.println("O usuario " +user.getNome() +" ,não possui bolsa");
                }
                
                break;
            case 5:
                
                System.out.println("Para poder alterar Email/Senha primeiro é nescessario uma identificação");

               /*Login log = new Login();
                boolean verify = false;

                while(verify == false){

                verify = login.verificarLogin(users);
                 }
                 */
                System.out.println("Insira o novo email: ");
                String email = scan.nextLine();
                System.out.println("Insira a nova senh: ");
                String password = scan.nextLine();

                user.setEmail(email);
                user.setPassword(password);


                break;
        }
        return user;
    }
}
