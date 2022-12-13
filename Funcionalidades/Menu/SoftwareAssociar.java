package Funcionalidades.Menu;

import java.util.LinkedList;

import Entidades.Atividades;
import Entidades.Projeto;
import Entidades.Ruler;
import Entidades.Usuarios;
import Funcionalidades.Associar;


public class SoftwareAssociar {
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
}
