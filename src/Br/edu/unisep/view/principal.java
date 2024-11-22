package Br.edu.unisep.view;

import javax.swing.*;
import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;

public class principal {
    private static ArrayList<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String opcao = JOptionPane.showInputDialog("Selecione uma opção:\n" +
                    "1. Adicionartarefa\n" +
                    "2. Marcar tarefa como concluída\n" +
                    "3. Remover tarefa\n" +
                    "4. Exibir todas as tarefas\n" +
                    "5. Sair"
            );
            if (opcao == null || opcao.equals("5")) {
                break;
            }
            switch (opcao) {
                case "1":
                    AdicionarTarefa();
                case "2":
                    Marcartarefa();
                case "3":
                    Removertarefas();
                case "4":
                    Exibirtarefas();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opção invalida");
            }
        }
    }

    private static void AdicionarTarefa() {
        String tarefa = JOptionPane.showInputDialog("Digite a tarefa:");
        if (tarefa != null && !tarefa.trim().isEmpty()) {
            tarefas.add(tarefa);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "A tarefa não pode estar vazia.");
        }
    }

    private static void Marcartarefa() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para concluir.");
            return;
        }
        StringBuilder listaTarefas = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            listaTarefas.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        String input = JOptionPane.showInputDialog("Selecione o número da tarefa para remover:\n" + listaTarefas);
        try {
            int indice = Integer.parseInt(input) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
        }
    }

    private static void Exibirtarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas.");
        } else {
            StringBuilder listaTarefas = new StringBuilder();
            for (String tarefa : tarefas) {
                listaTarefas.append("- ").append(tarefa).append("\n");

            }
        }
        JOptionPane.showMessageDialog(null, tarefas.toString(), "Lista de Tarefas", JOptionPane.INFORMATION_MESSAGE);
    }
    private static void Removertarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para remover.");
            return;
        }
    }

}


