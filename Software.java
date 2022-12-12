
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
       Listar func = new Listar();
       Listar rel = new Listar();
       Payment pagamento = new Payment();
       Software software = new Software();
    

       run.users.add(admin);

       int option;

       while(true){
            
            menu.printSistema();
            option = scan.nextInt();
            scan.nextLine();

            if(option == 0)software.exit(scan);

            if(option == 1)projetos = software.criacaoProjeto(projetos, login, criacao);
            
            if(option == 2) atividades = software.criacaoAtiv(atividades, (Pessoa)login, criacao);
    
            if(option == 3)run.users = software.createUsers(run, login, scan);
            
            if(option == 4)projetos = software.removerProjeto(projetos, (Pessoa)login, remover);

            if(option == 5)atividades = software.removerTask(atividades, (Pessoa)login, remover);

            if(option == 6)run.users = software.removeUsers(run, login, scan);

            if(option == 7)projetos = software.editarProjeto(projetos, (Pessoa) login, edicao);

            if(option == 8)atividades =  software.editarTasks(atividades, (Pessoa) login, edicao);

            if(option == 9)run.users = software.editarUsuarios(run, login, scan);

            if(option == 10)projetos = software.associarUsersToProject(projetos, run.users, login, function);

            if(option == 11)projetos = software.tasksToProjects(projetos, atividades, login, function);

            if(option == 12)atividades = software.usersToTasks(atividades, run.users, login, function);

            if(option == 13)projetos = software.alterarStatus(projetos, login, status);

            if(option == 14)software.listarProjetosCadastrados(projetos, rel);

            if(option == 15)software.listarTasksCadastradas(atividades, rel);

            if(option == 16)software.listarUsersCadastrados(run.users, rel);

            if(option == 17)software.relatorioProjeto(projetos, scan, rel);

            if(option == 18)software.paymentBolsa(run.users, login, pagamento, scan);
            
            if(option == 19) software.login(login, run);
       }
    }
    public void exit(Scanner scan) {
        
        scan.close();
        System.exit(0);
    }
    public LinkedList<Projeto> criacaoProjeto(LinkedList <Projeto> projetos, Usuarios usuario, Criar create){

        Projeto projeto = new Projeto();

        projeto = create.criarProjetos((Pessoa)usuario);

        if(projeto != null){
            projetos.add(projeto);
        }
        else{
            System.out.println("Não foi possível criar o projeto");
        }
        return projetos;
    }
    public LinkedList <Atividades> criacaoAtiv(LinkedList <Atividades> atvds, Pessoa usuario, Criar create){

        Atividades newTask = new Atividades();

       newTask =  create.criarAtividade(usuario);


       if(newTask!= null)atvds.add(newTask);

       else System.out.println("Não foi possível criar a Atividade");

       return atvds;
    }
    public LinkedList <Projeto> removerProjeto(LinkedList<Projeto> projetos, Pessoa login, Retirar remove){

        try{
            if((login.getAcessLevel() == Ruler.Coordenador || login.getAcessLevel() == Ruler.Admin) && login != null){
                projetos =  remove.retirarProjetos(projetos);
            }
            else{
                System.out.println("É nescessário estar conectado em uma conta de Acess level de Admin");
            }
        return projetos;

        }catch(Exception y){

            System.out.println("É nescessário estar conectado em alguma conta para realizar essa funcionalidade");
            return projetos;
        }
    }
    public LinkedList<Atividades> removerTask(LinkedList<Atividades> atvds, Pessoa login, Retirar remove){

        try{

            if((login.getAcessLevel() == Ruler.Coordenador || login.getAcessLevel() == Ruler.Admin) && login != null){
                atvds =  remove.retirarAtividades(atvds);
            }
            else{
                System.out.println("É nescessário está conectado em uma conta de Acess level de Admin");
            }

            return atvds;
        }catch(Exception e){

            System.out.println("É nescessário está conectado a alguma conta existente para realizar essa função");
            return atvds;
        }
    }
    public  LinkedList<Projeto> editarProjeto(LinkedList<Projeto> projetos, Pessoa login, Editar edicao){

        try{
            if(login.getAcessLevel() == Ruler.Coordenador || login.getAcessLevel() == Ruler.Admin){

                projetos = edicao.editarProjeto(projetos, login);
                return projetos;
            }
            else{
                System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");

                return projetos;
            }
        }catch(Exception y){

            System.out.println("E nescessario esta conectado em algum conta para realizar essa ação");
            return projetos;
        }
    }
    public LinkedList<Atividades> editarTasks(LinkedList <Atividades> tasks, Pessoa login, Editar edicao){

        try{
            if(login.getAcessLevel() == Ruler.Coordenador || login.getAcessLevel() == Ruler.Admin){

                tasks = edicao.editarAtividades(tasks);
                return tasks;
            }
            else{
                System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");

                return tasks;
            }
        }catch(Exception y){

            System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");
            return tasks;
        }
    }
    public  LinkedList<Projeto> associarUsersToProject(LinkedList<Projeto> projetos, LinkedList<Usuarios> users, Usuarios login, Associar func){

        try{
            if(login.getAcessLevel().equals(Ruler.Admin) || login.getAcessLevel().equals(Ruler.Coordenador)){

                projetos = func.usersToProject(projetos, users);

                return projetos;
            }
            else{
                System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");

                return projetos;

            }
        }catch(Exception y){

            System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");
            return projetos;
        }
    }
    public LinkedList<Projeto> tasksToProjects(LinkedList<Projeto> projetos, LinkedList<Atividades> tasks, Usuarios login, Associar func){

       try{
            if(login.getAcessLevel().equals(Ruler.Admin) || login.getAcessLevel().equals(Ruler.Coordenador)){

                projetos = func.taskToProject(projetos, tasks);

                return projetos;
            }
            else{
                System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");

                return projetos;

            }
        }catch(Exception y){

            System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");
            return projetos;
        }
    }
    public LinkedList<Atividades> usersToTasks(LinkedList<Atividades> tasks, LinkedList<Usuarios> users, Usuarios login, Associar func){

        try{
            if(login.getAcessLevel().equals(Ruler.Admin) || login.getAcessLevel().equals(Ruler.Coordenador)){

                tasks = func.userTotask(tasks, users);

                return tasks;
            }
            else{
                System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");

                return tasks;

            }
        }catch(Exception y){

            System.out.println("E nescessario esta conectado a uma conta de professor/coordenador ou a conta de admnistrador do sistema");
            return tasks;
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

        return login = run.login(login);
    }
    public LinkedList<Usuarios> removeUsers(Runner run, Usuarios login, Scanner scan){

        try{
            if(login.getAcessLevel().equals(Ruler.Admin) || login.getAcessLevel().equals(Ruler.Coordenador)){

                run.users = run.remover(scan);
                return run.users;
            }
            else{

                System.out.println("É nescessário estar conectado a uma conta de Professor|Pesquisador");
                return run.users;
            }
        }catch(Exception y){

            System.out.println("É nescessário estar conectado em alguma conta para realizar essa ação");
            return run.users;
        }
    }
    public LinkedList<Usuarios> editarUsuarios(Runner run, Usuarios login, Scanner scan){

        try{
            if(login.getAcessLevel().equals(Ruler.Admin) || login.getAcessLevel().equals(Ruler.Coordenador)){

                run.users = run.editar(scan);
                return run.users;
            }
            else{
                System.out.println("É Nescessário estar conectado a uma conta de Professor}Pesquisador");
                return run.users;
            }
        }catch(Exception y ){
            System.out.println("É nescessário estar conectado em alguma conta para realizar essa ação");
            return run.users;
        }
    }
    public LinkedList<Usuarios> createUsers(Runner run, Usuarios login, Scanner scan){

        try{
            if(login.getAcessLevel().equals(Ruler.Coordenador) || login.getAcessLevel().equals(Ruler.Admin)){

                run.users.add(run.createNewUser());
                return run.users;
            }
            else{
                System.out.println("E nescessario esta conectado a uma conta professor|pesquisador");
                return run.users;
            }
        }catch(Exception y){

            System.out.println("E nescessario estar conectado em alguma conta");
            return run.users;
        }
    }
}
