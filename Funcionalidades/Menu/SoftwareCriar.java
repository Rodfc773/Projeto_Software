package Funcionalidades.Menu;
import java.util.LinkedList;
import java.util.Scanner;
import Entidades.Atividades;
import Entidades.Pessoa;
import Entidades.Projeto;
import Entidades.Usuarios;
import Funcionalidades.Criar;
import Funcionalidades.Runner;
import Entidades.Ruler;


public class SoftwareCriar {
    
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
