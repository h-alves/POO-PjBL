package main;

import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ScannerLeitor scanner = new ScannerLeitor();
        String fileName = "D:\\area de trabalho\\PUCPR\\3º SEMESTRE 2023\\1 - Programação Orientada a Objetos\\PJBL\\GIT\\POO-PjBL\\src\\main\\funcionarios.csv";
        List<List<String>> tabela = scanner.leituraDoArquivo(fileName);

        Map<String, Departamento> departamentos = new HashMap<>();

        for (List<String> registro : tabela) {
            String cargo = registro.get(0);
            String nome = registro.get(1);
            double salario = Double.parseDouble(registro.get(2));
            String dataNascimento = registro.get(3);
            String departamentoNome = registro.get(4);
            double bonus = Double.parseDouble(registro.get(5));
            double valorVendas = Double.parseDouble(registro.get(6));
            String numVendas = registro.get(7).trim();

            int newNumVendas = Integer.parseInt(numVendas);

            Departamento departamento;
            if (departamentos.containsKey(departamentoNome)) {
                departamento = departamentos.get(departamentoNome);
            } else {
                departamento = new Departamento(departamentoNome);
                departamentos.put(departamentoNome, departamento);
            }

            Funcionario funcionario;
            if (cargo.equals("Vendedor")) {
                funcionario = new Vendedor(nome, salario, dataNascimento, departamento, valorVendas, newNumVendas);
            } else {
                funcionario = new Gerente(nome, salario, dataNascimento, departamento, bonus);
            }

            departamento.adicionarFuncionario(funcionario);
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                List<FolhaPagamento> folhas = new ArrayList<>();
                for (Departamento departamento : departamentos.values()) {
                    FolhaPagamento folha = new FolhaPagamento(Mes.JANEIRO, departamento);
                    folha.calcularTotalSalarios();
                    folhas.add(folha);
                }

                InterfaceGrafica interfaceGrafica = new InterfaceGrafica(new ArrayList<>(departamentos.values()), (ArrayList<FolhaPagamento>) folhas);
                interfaceGrafica.setVisible(true);
            }
        });
    }
}
