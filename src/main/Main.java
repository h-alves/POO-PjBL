package main;

import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Criando uma instância do ScannerLeitor
        ScannerLeitor scanner = new ScannerLeitor();

        // Caminho do arquivo CSV
        String fileName = "D:\\area de trabalho\\PUCPR\\3º SEMESTRE 2023\\1 - Programação Orientada a Objetos\\PJBL\\GIT\\POO-PjBL\\src\\main\\funcionarios.csv";

        // Lendo o arquivo e obtendo a tabela de dados
        List<List<String>> tabela = scanner.leituraDoArquivo(fileName);

        // Criando um mapa para armazenar os departamentos
        Map<String, Departamento> departamentos = new HashMap<>();

        // Iterando sobre os registros da tabela
        for (List<String> registro : tabela) {
            // Obtendo os dados do registro
            String cargo = registro.get(0);
            String nome = registro.get(1);
            double salario = Double.parseDouble(registro.get(2));
            String dataNascimento = registro.get(3);
            String departamentoNome = registro.get(4);
            double bonus = Double.parseDouble(registro.get(5));
            double valorVendas = Double.parseDouble(registro.get(6));
            String numVendas = registro.get(7).trim();

            // Convertendo o número de vendas para inteiro
            int newNumVendas = Integer.parseInt(numVendas);

            // Verificando se o departamento já existe no mapa
            Departamento departamento;
            if (departamentos.containsKey(departamentoNome)) {
                departamento = departamentos.get(departamentoNome);
            } else {
                // Criando um novo departamento se não existir
                departamento = new Departamento(departamentoNome);
                departamentos.put(departamentoNome, departamento);
            }

            // Criando o funcionário com base no cargo
            Funcionario funcionario;
            if (cargo.equals("Vendedor")) {
                funcionario = new Vendedor(nome, salario, dataNascimento, departamento, valorVendas, newNumVendas);
            } else {
                funcionario = new Gerente(nome, salario, dataNascimento, departamento, bonus);
            }

            // Adicionando o funcionário ao departamento
            departamento.adicionarFuncionario(funcionario);
        }

        // Executando a interface gráfica em uma thread separada
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Criando uma lista de folhas de pagamento
                List<FolhaPagamento> folhas = new ArrayList<>();

                // Calculando a folha de pagamento para cada departamento
                for (Departamento departamento : departamentos.values()) {
                    FolhaPagamento folha = new FolhaPagamento(Mes.JANEIRO, departamento);
                    folha.calcularTotalSalarios();
                    folhas.add(folha);
                }

                // Criando a interface gráfica e exibindo-a
                InterfaceGrafica interfaceGrafica = new InterfaceGrafica(new ArrayList<>(departamentos.values()), (ArrayList<FolhaPagamento>) folhas);
                interfaceGrafica.setVisible(true);
            }
        });
    }
}
