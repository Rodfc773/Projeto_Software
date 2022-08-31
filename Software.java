import java.text.ParsePosition;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import Classes.Atividades;
import Classes.Projeto;
import Classes.Usuarios;

public class Software {

    public static void main(String[] args) {
        
        LinkedList <Projeto> projetos = new LinkedList<Projeto>();
        LinkedList <Usuarios> users = new LinkedList<Usuarios>();
        LinkedList <Atividades> atividades = new LinkedList<Atividades>();

        int idProjeto = 0, idAtividade = 0;

        while (true){
            int opcao;

            Scanner teclado = new Scanner(System.in);

            System.out.println("Bem vindo ao sistema de Gerenciamento de Projetos, Qual operação deseja realizar?\n");
            System.out.println("1 : Criar/Retirar informações");
            System.out.println("2 : Editar informações\n3 : Listar Projetos/Atividades");

            opcao = Integer.parseInt(teclado.nextLine());

            if(opcao == 1){

                System.clearProperty("clear");
                System.out.println("O que deseja fazer?\n1: Criar | 2 : Retirar\n");

                int opcao2 = Integer.parseInt(teclado.nextLine());

                if(opcao2 == 1){

                   System.out.println("Deseja criar, (1: Novo Projeto) | (2 : Nova Atividade) | (3 : Novo Usuario) : ");

                   int opcao3 = Integer.parseInt(teclado.nextLine());

                   if (opcao3 == 1){

                    System.clearProperty("clear");
                        Projeto auxProjeto = new Projeto();
                        auxProjeto.Criar(idProjeto);

                        Usuarios coordenador = new Usuarios();
                        coordenador.coordenador();

                        users.add(coordenador);

                        auxProjeto.coordenador = coordenador;

                        projetos.add(auxProjeto);

                        idProjeto += 1;

                        System.out.println("Projeto criado com sucesso!!\n");


    
                   }
                   if (opcao3 == 2){

                        System.clearProperty("clear");

                        Atividades auxAtividades = new Atividades();
                        auxAtividades.criar(idAtividade);

                        atividades.add(auxAtividades);

                        idAtividade += 1;
                        System.out.println("Atividade criada com sucesso!!\n");
                        
                   }
                   if(opcao3 == 3){

                    Usuarios auxUsuarios = new Usuarios();
                    auxUsuarios.Cadastro();
                    users.add(auxUsuarios);

                   }
                   continue;

                }
                else{

                    int aux;

                    System.out.println("O que deseja remover?(1 : Projetos | 2 : Atividades | 3 : Usuarios): ");
                    aux = teclado.nextInt();

                    if(aux == 1){

                        if(projetos.isEmpty()){

                            System.out.println("Não existem projetos cadastrados\n");
                        }
                        else{

                            System.clearProperty("clear");

                            for (Projeto projeto : projetos) 
                            {
                                System.out.println("Id: " +projeto.id);
                                System.out.println("\nDescrição: " +projeto.descricao);
                                System.out.println("\nStatuts: " +projeto.status);
    
                            }
    
                            System.out.println("Deseje Retirar qual projeto?(digite o ID): ");
                            int id = teclado.nextInt();

                            projetos.remove(id);

    
                        }
                    }
                    if(aux == 2)
                    {

                        if(atividades.isEmpty()){

                            System.out.println("Não tem nenhuma atividade em andamento");
                        }
                        else{

                            System.clearProperty("clear");

                            for (Atividades atividades2 : atividades) {

                                System.out.println("Id: " +atividades2.id);
                                System.out.println("Descrição: " +atividades2.descricao);
                                
                            }

                            System.out.println("Qual Atividade deseja retirar?(Digite o ID): ");

                            int id = teclado.nextInt();

                            atividades.remove(id);
                        }
                    }
                    continue;
                }
            }
            if(opcao == 2)
            {

                System.out.println("O Que deseja Editar?\n(1 : Projetos | 2 : Atividades | 3 : Usuarios):");

                int opcao2 = teclado.nextInt();

                switch (opcao2) {
                    case 1:
                        
                        for (Projeto i : projetos) {

                        System.out.println("ID: "+i.id);
                        System.out.println("Status: "+i.status);
                        System.out.println("Descrição: "+i.descricao);
                            
                        }

                        System.out.println("Escolha um Projeto pra ser editado(Digite seu ID): ");

                        int index = teclado.nextInt();

                        projetos.get(index).editar();
                        break;
                
                    default:
                        break;
                }



            }
            if(opcao == 3)
            {
                System.out.println("!------- PROJETOS ------!");
                for (Projeto i : projetos) {

                    System.out.println("ID: "+i.id);
                    System.out.println("Status: "+i.status);
                    System.out.println("Descrição: "+i.descricao);
                    System.out.println("Coordenador: "+i.coordenador.nome);
                    System.out.println("Inicio: "+i.data_inicio +"\nPrazo: " + i.data_termino);
 
                }

                System.out.println("!########### Atividades ########!");

                for (Atividades j : atividades) {
                    
                    System.out.println("ID: "+j.id);
                    System.out.println("Descrição: "+j.descricao);
                    System.out.println("Coordenador: "+j.responsavel);
                    System.out.println("Inicio: "+j.data_inicio +"\nPrazo: " + j.data_fim);
                }
            }
            else
            {
                System.out.println("Encerrando o sistema de gerenciamento!");
                break;
            }
        }
    }
    
}
