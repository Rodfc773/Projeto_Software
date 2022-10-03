package Funcionalidades;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import Classes.Atividades;
import Classes.Pessoa;
import Classes.Projeto;
import Classes.Usuarios;

public class Editar {

    public LinkedList <Projeto> editarProjeto(LinkedList<Projeto> projetos, Pessoa user){

        Scanner teclado = new Scanner(System.in);
        Sistema menu = new Sistema();
        System.out.println("Digite o nome do projeto que queira editar: ");
        String nomeProjeto = teclado.nextLine();

        for(Projeto projeto : projetos){

            if(projeto.getNome().equals(nomeProjeto)){

                if(projeto.getCoordenador() != user){

                    System.out.println("!--------------         ERROR       ----------------!");
                    System.out.println("Só o coordenador do projeto é permitido alterar as informações");
                    return projetos;
                }

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
                        LocalDateTime dataFinal = LocalDateTime.parse(teclado.nextLine());
                        projeto.setDataFinal(dataFinal);

                        break;
                    default:
                        break;
                }
                System.out.println("!---- ---          Edição fimalizada com sucesso            ------!\n");
                return projetos;
            }
        }

        System.out.println("!---        Não existe projeto cadastrado com esse nome         ----!\n");
        return projetos;
    }
    public LinkedList<Atividades> editarAtividades(LinkedList <Atividades> atvds){

        Scanner teclado = new Scanner(System.in);
        Sistema menu = new Sistema();

        System.out.println("Digite o nome da atvidade que queira editar: ");
        String nomeAtividade = teclado.nextLine();

        for(Atividades task : atvds){

            if(task.getNome().equals(nomeAtividade)){

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
                        LocalDateTime prazo = LocalDateTime.parse(teclado.nextLine());
                        task.setDataFinal(prazo);

                        break;

                    default:
                        break;
                }
                System.out.println("    !!!!    Atividade editado com sucesso   !!!");
                return atvds;
            }
        }
        System.out.println("!!!----!!         ERROR         !!--!!\n\n");
        System.out.println("!--------       Não existe atividade cadastrada com esse nome           ---------!\n");
        return atvds;
    }
}
