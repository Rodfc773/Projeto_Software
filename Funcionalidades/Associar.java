package Funcionalidades;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

public class Associar {

    public LinkedList <Projeto> usersToProject(LinkedList <Projeto> projetos, LinkedList <Usuarios> users){


        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do projeto que queira associar:");
        String nomeProjeto = scan.nextLine();

        System.out.println("Digite o email do usuário que queira associar: ");
        String userEmail = scan.nextLine();

        Usuarios aux = new Usuarios();
        aux = null;
        for(Usuarios user : users){

            if(user.getEmail().equals(userEmail)){
                aux = user;
                break;
            }
        }

        for(Projeto projeto : projetos){

            if(aux == null || projetos.contains(projeto.getNomeProjeto().equals(nomeProjeto))){

                System.out.println("Não existe projeto com esse nome/Não existe usuario com esse email");
                return projetos;
            }
            if(projeto.getNomeProjeto().equals(nomeProjeto)){

                projeto.setProfissionais(aux);
                System.out.println("O profissional : " +aux.getNome() + "\nDe email: " +aux.getEmail() + "\nFoi cadastrado com sucesso no projeto: "+projeto.getNomeProjeto());
                break;
            }
        }

        return projetos;
    }

    public LinkedList <Projeto>  taskToProject(LinkedList <Projeto> prjts, LinkedList <Atividades> tasks){

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome da Atividade que queira associar: ");
        String nomeAtividade = scan.nextLine();

        System.out.println("Digite o nome do projeto: ");
        String nomeProjeto = scan.nextLine();

        Atividades aux = null;

        for(Atividades task: tasks){

            if(task.getNomeAtvd().equals(nomeAtividade)){

                aux = task;
                break;
            }
        }

        if(aux == null){

            System.out.println("Nao existe atividade cadastrada com esse nome");
            return prjts;
        }

        for(Projeto projeto : prjts){

            if(projeto.getNomeProjeto().equals(nomeProjeto)){

                projeto.setTasks(aux);
                System.out.println("A atividade : " +aux.getNomeAtvd() + "\nFoi associada com sucesso no projeto: "+projeto.getNomeProjeto());
                break;
            }
        }
        return prjts;
    }

    public LinkedList<Atividades> userTotask(LinkedList <Atividades> tasks, LinkedList <Usuarios> users){

        System.out.println("Digite o nome da Atividade: ");
        Scanner scan = new Scanner(System.in);
        String nomeAtividade = scan.nextLine();

        System.out.println("Digite o email do Usuario que sera associado: ");

        String email = scan.next();
        Usuarios aux = null;

        for(Usuarios user : users){

            if(user.getEmail().equals(email)){

                aux = user;
                break;
            }
        }

        for(Atividades task : tasks){

            if(task.getNomeAtvd().equals(nomeAtividade)){

                task.setProfissionais(aux);

                System.out.println("Deseja cadastar: " + aux.getNome() + " ,Como respons[avel pela tarefa?(1 : sim | 2 : nao)\n-->");
                int op = scan.nextInt();
                scan.nextLine();

                if(op == 1){
                    task.setResponsavel(aux);
                }

                System.out.println("O profissional : " +aux.getNome() + "\nDe email: " +aux.getEmail() + "\nFoi cadastrado com sucesso no projeto: "+task.getNomeAtvd());

            }
        }
        return tasks;
    }
}
