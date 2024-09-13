import java.util.Scanner;

public class GerenciamentoAtendimento {
    public static void main(String[] args) {
        Pilha historico = new Pilha();
        Fila filaAtendimento = new Fila();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("0 - Sair");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Visualizar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar:");
                    System.out.println("1 - Adicionar ao Histórico");
                    System.out.println("2 - Adicionar à Fila de Atendimento");
                    System.out.print("Escolha uma opção: ");
                    int tipoAdicao = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data (para histórico) ou Motivo (para fila): ");
                    String info = scanner.nextLine();

                    Elemento novoElemento = new Elemento(id, descricao, info);

                    if (tipoAdicao == 1) {
                        historico.push(novoElemento);
                        System.out.println("Solicitação adicionada ao histórico.");
                    } else if (tipoAdicao == 2) {
                        filaAtendimento.enqueue(novoElemento);
                        System.out.println("Cliente adicionado à fila de atendimento.");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    System.out.println("Remover:");
                    System.out.println("1 - Remover do Histórico");
                    System.out.println("2 - Remover da Fila de Atendimento");
                    System.out.print("Escolha uma opção: ");
                    int tipoRemocao = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    if (tipoRemocao == 1) {
                        if (!historico.isEmpty()) {
                            Elemento solicitacaoRemovida = historico.pop();
                            System.out.println("Removido do histórico: " + solicitacaoRemovida.id + " - " + solicitacaoRemovida.descricao);
                        } else {
                            System.out.println("Histórico vazio.");
                        }
                    } else if (tipoRemocao == 2) {
                        if (!filaAtendimento.isEmpty()) {
                            Elemento clienteRemovido = filaAtendimento.dequeue();
                            System.out.println("Removido da fila: " + clienteRemovido.id + " - " + clienteRemovido.descricao);
                        } else {
                            System.out.println("Fila de atendimento vazia.");
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3:
                    System.out.println("Visualizar:");
                    System.out.println("1 - Visualizar Histórico");
                    System.out.println("2 - Visualizar Fila de Atendimento");
                    System.out.print("Escolha uma opção: ");
                    int tipoVisualizacao = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    if (tipoVisualizacao == 1) {
                        if (!historico.isEmpty()) {
                            System.out.println("Histórico de Solicitações:");
                            Pilha historicoAux = new Pilha(); // Pilha auxiliar para não perder os elementos
                            while (!historico.isEmpty()) {
                                Elemento solicitacao = historico.pop();
                                historicoAux.push(solicitacao); // Coloca na pilha auxiliar para manter a original
                                System.out.println("Solicitação: " + solicitacao.id + " - " + solicitacao.descricao + " (" + solicitacao.data + ")");
                            }
                            while (!historicoAux.isEmpty()) {
                                historico.push(historicoAux.pop()); // Restaura os elementos na pilha original
                            }
                        } else {
                            System.out.println("Histórico vazio.");
                        }
                    } else if (tipoVisualizacao == 2) {
                        if (!filaAtendimento.isEmpty()) {
                            System.out.println("Fila de Atendimento:");
                            Fila filaAux = new Fila(); // Fila auxiliar para não perder os elementos
                            while (!filaAtendimento.isEmpty()) {
                                Elemento cliente = filaAtendimento.dequeue();
                                filaAux.enqueue(cliente); // Coloca na fila auxiliar para manter a original
                                System.out.println("Cliente: " + cliente.id + " - " + cliente.descricao + " (" + cliente.data + ")");
                            }
                            while (!filaAux.isEmpty()) {
                                filaAtendimento.enqueue(filaAux.dequeue()); // Restaura os elementos na fila original
                            }
                        } else {
                            System.out.println("Fila de atendimento vazia.");
                        }
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
