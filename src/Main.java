import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Scanner leitor = new Scanner(System.in);

        ArrayList<Task> tarefas = new ArrayList<>();
        String resposta;
        do {
            System.out.println("Digite a descrição da tarefa:");
            String descricao = leitor.nextLine();

            Task novaTarefa = new Task(descricao);
            tarefas.add(novaTarefa);

            System.out.println("Deseja adicionar outra tarefa? (s/n)");
            resposta = leitor.nextLine();

        } while (!resposta.equalsIgnoreCase("n"));



        System.out.println("Tarefas criadas:");
        tarefas.forEach(tarefa -> System.out.println("ID: " + tarefa.getId()
                + ", Descrição: " + tarefa.getDescricao()
                + ", Status: " + tarefa.getStatus()
                + ", Criada em: " + tarefa.getCreatedAt().format(formatter)
                + ", Atualizada em: " + tarefa.getUpdatedAt().format(formatter)));
        Iterator<Task> iterator = tarefas.iterator();


        System.out.println("Deseja excluir alguma tarefa? (s/n)");
        String excluirResposta = leitor.nextLine();
        if (excluirResposta.equals("s")){
            System.out.println("Digite o ID da tarefa que deseja excluir:");
            String excluir = leitor.nextLine();
            while (iterator.hasNext()){
                Task tarefa = iterator.next();
                if (tarefa.getId().equals(excluir)){
                    iterator.remove();
                    System.out.println("Tarefa com ID " + excluir + " foi excluída.");
                }
            }
        }


        System.out.println("Deseja mudar o status de alguma tarefa? (s/n)");
        String mudarStatus = leitor.nextLine();
        if (mudarStatus.equals("s")){
            System.out.println("Digite o Id da tarefa que deseja mudar o status: ");
            String id = leitor.nextLine();
            for (Task tarefa : tarefas){
                if (tarefa.getId().equals(id)){
                    System.out.println("Digite o novo status (PENDENTE, EM_ANDAMENTO, CONCLUIDA): ");
                    String novoStatus = leitor.nextLine();
                    switch (novoStatus.toUpperCase()){
                        case "PENDENTE":
                            tarefa.setStatus(Status.PENDENTE);
                            System.out.println("Status da tarefa com ID " + id + " foi atualizado para PENDENTE.");
                            break;
                        case "EM_ANDAMENTO":
                            tarefa.setStatus(Status.EM_ANDAMENTO);
                            System.out.println("Status da tarefa com ID " + id + " foi atualizado para EM_ANDAMENTO.");
                            break;
                        case "CONCLUIDA":
                            tarefa.setStatus(Status.CONCLUIDA);
                            System.out.println("Status da tarefa com ID " + id + " foi atualizado para CONCLUIDA.");
                            break;
                        default:
                            System.out.println("Status inválido. Tente novamente.");
                    }
                }
            }
        }


    }
}
