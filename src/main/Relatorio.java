package main;


import java.util.ArrayList;

public class Relatorio {
    public String gerarRelatorio(ArrayList<Funcionario> funcionarios) {
        StringBuilder relatorio = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            relatorio.append("Nome: ").append(funcionario.getNome()).append("\n");
            relatorio.append("Salário: ").append(funcionario.calcularSalario()).append("\n");
            relatorio.append("---------------------------\n");
        }
        return relatorio.toString();
    }
}