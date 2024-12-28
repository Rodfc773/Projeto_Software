
import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Atividades;
import Entidades.Pessoa;
import Entidades.Projeto;
import Entidades.Ruler;
import Entidades.Usuarios;
import Funcionalidades.AlterarStatus;
import Funcionalidades.Associar;
import Funcionalidades.Criar;
import Funcionalidades.Editar;
import Funcionalidades.Listar;
import Funcionalidades.Payment;
import Funcionalidades.Retirar;
import Funcionalidades.Runner;
import Funcionalidades.Sistema;
import Funcionalidades.Menu.SoftwareAssociar;
import Funcionalidades.Menu.SoftwareCriar;
import Funcionalidades.Menu.SoftwareEditar;
import Funcionalidades.Menu.SoftwareRemover;

public class Software {

    public static void main(String[] args) {

       Sistema menu = new Sistema();
       Usuarios admin = new Pessoa();
       Usuarios login = new Pessoa();

       login = null;


       LinkedList <Projeto> projetos = new LinkedList<Projeto>();
       LinkedList <Atividades> atividades = new LinkedList<Atividades>();
       Scanner scan = new Scanner(System.in);
    

       Runner run = new Runner();

       Criar criacao = new Criar();
       Retirar remover = new Retirar();
       Editar edicao = new Editar();
       Associar function = new Associar();
       AlterarStatus status = new AlterarStatus();
       Listar rel = new Listar();
       Payment pagamento = new Payment();
       Software software = new Software();
       SoftwareAssociar softAssociar = new SoftwareAssociar();
       SoftwareCriar softCriar = new SoftwareCriar();
       SoftwareEditar softEditar = new SoftwareEditar();
       SoftwareRemover softRemover = new SoftwareRemover();
    

       run.users.add(admin);

       int option;

       while(true){
            
           if(login == null) menu.printSistema();
           else menu.printSistemaLogin();
            option = scan.nextInt();
            scan.nextLine();

            if(option == 0)softCriar.exit(scan);

            if(option == 1)projetos = softCriar.criacaoProjeto(projetos, login, criacao);
            
            if(option == 2) atividades = softCriar.criacaoAtiv(atividades, (Pessoa)login, criacao);
    
            if(option == 3)run.users = softCriar.createUsers(run, login, scan);
            
            if(option == 4)projetos = softRemover.removerProjeto(projetos, (Pessoa)login, remover);

            if(option == 5)atividades = softRemover.removerTask(atividades, (Pessoa)login, remover);

            if(option == 6)run.users = softRemover.removeUsers(run, login, scan);

            if(option == 7)projetos = softEditar.editarProjeto(projetos, (Pessoa) login, edicao);

            if(option == 8)atividades =  softEditar.editarTasks(atividades, (Pessoa) login, edicao);

            if(option == 9)run.users = softEditar.editarUsuarios(run, login, scan);

            if(option == 10)projetos = softAssociar.associarUsersToProject(projetos, run.users, login, function);

            if(option == 11)projetos = softAssociar.tasksToProjects(projetos, atividades, login, function);

            if(option == 12)atividades = softAssociar.usersToTasks(atividades, run.users, login, function);

            if(option == 13)projetos = software.alterarStatus(projetos, login, status);

            if(option == 14)software.listarProjetosCadastrados(projetos, rel);

            if(option == 15)software.listarTasksCadastradas(atividades, rel);

            if(option == 16)software.listarUsersCadastrados(run.users, rel);

            if(option == 17)software.relatorioProjeto(projetos, scan, rel);

            if(option == 18)software.paymentBolsa(run.users, login, pagamento, scan);

            if(option == 19) login = software.login(login, run);
       }
    }
  
    public LinkedList<Projeto> alterarStatus(LinkedList<Projeto> projetos, Usuarios login, AlterarStatus status){

        try{
            if(login.getAcessLevel().equals(Ruler.Coordenador) || login.getAcessLevel().equals(Ruler.Admin)){

                projetos = status.mudarStatus(projetos, login);

                return projetos;
            }
            else{
                System.out.println("E nescessário estar logado em uma conta de Professor ou Pesquisador para realizar essa ação");

                return projetos;
            }
        }catch(Exception y){

            System.out.println("É nescessário estar conectado a alguma conta para realizar essa função");
            return projetos;
        }
    }
    public void listarProjetosCadastrados(LinkedList<Projeto> projetos, Listar list){

        list.listarProjetos(projetos);
    }
    public void listarTasksCadastradas(LinkedList<Atividades> tasks, Listar list){

        list.listarAtividades(tasks);
    }
    public void listarUsersCadastrados(LinkedList<Usuarios> users, Listar list){

        list.listarUsuarios(users);
    }
    public void relatorioProjeto(LinkedList<Projeto> projetos, Scanner scan, Listar list){

        System.out.println("Digite o nome do projeto que você quer o relátorio");
        String name = scan.nextLine();

        for( Projeto project : projetos){

            if(project.getNome().equals(name)){

                list.relatorio(project);

                break;
            }
        }
    }
    public void paymentBolsa(LinkedList<Usuarios> users, Usuarios login, Payment pagamento, Scanner scan){

            try{
                if(login != null && (login.getAcessLevel().equals(Ruler.Admin) || login.getAcessLevel().equals(Ruler.Coordenador))){

                    pagamento.paymentBolsa(users, scan);
                }
                else{
                    System.out.println("O usuario que irá realizar o pagamento da bolsa tem que ter nivel de acesso de admin9");
                }
            }catch(Exception y){

                System.out.println("Não existe nenhuma conta conectada");
            
        }
    }
    public Usuarios login(Usuarios login, Runner run){

        if(login == null){

            return run.login(login);
        }
        else{
            return null;
        }
    }
}
