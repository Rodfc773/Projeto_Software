package Funcionalidades.Menu;
import java.util.LinkedList;
import java.util.Scanner;

import Entidades.Atividades;
import Entidades.Pessoa;
import Funcionalidades.Retirar;
import Entidades.Projeto;
import Entidades.Ruler;
import Entidades.Usuarios;
import Funcionalidades.Runner;;


public class SoftwareRemover {
    
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
}
