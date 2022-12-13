package Funcionalidades.Menu;
import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Atividades;
import Entidades.Pessoa;
import Entidades.Projeto;
import Entidades.Ruler;
import Entidades.Usuarios;
import Funcionalidades.Editar;
import Funcionalidades.Runner;



public class SoftwareEditar {
    
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
}
