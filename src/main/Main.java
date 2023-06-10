package main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ScannerLeitor scanner = new ScannerLeitor();
        List<List<String>> tabela = scanner.leituraDoArquivo("funcionarios.csv");

        for (List<String> registro : tabela) {
            String cargo = registro.get(0);
            String nome = registro.get(1);
            double salario = Double.parseDouble(registro.get(2));
            String dataNascimento = registro.get(3);
            String departamentoNome = registro.get(4);
            double bonus = Double.parseDouble(registro.get(5));
            double valorVendas = Double.parseDouble(registro.get(6));
            int numVendas = Integer.parseInt(registro.get(7));

            Departamento departamento = new Departamento(departamentoNome);
            Funcionario funcionario;

            if (cargo.equals("Vendedor")) {
                funcionario = new Vendedor(nome, salario, dataNascimento, departamento, valorVendas, numVendas);
            } else if (cargo.equals("Gerente")) {
                funcionario = new Gerente(nome, salario, dataNascimento, departamento, bonus);
            } else {
                continue; // Skip invalid records
            }

            departamento.adicionarFuncionario(funcionario);
        }

        Departamento d1 = new Departamento("posto de gasosa");
        Departamento d2 = new Departamento("lojinha da cacau show");

        Gerente g1 = new Gerente("Vinicius", 100, "01-01-01", d1, 1000);
        Vendedor v1 = new Vendedor("Pedrao", 100, "01-01-01", d1, 200, 12);
        Gerente g2 = new Gerente("Hask", 150, "01-01-01", d1, 1000);
        Gerente g3 = new Gerente("Julia", 30, "01-01-01", d1, 200);
        Vendedor v2 = new Vendedor("Bruno", 150, "01-01-01", d1, 200, 12);

        d1.listarFuncionarios();

        System.out.print("Média de vendas do " + v1.getNome() + ": ");
        try {
            System.out.printf("%.2f\n", v1.mediaVenda());
        } catch (ExcecaoVendedorSemVendas e) {
            System.out.println(0);
        }

        System.out.println("Salário do " + v2.getNome() + ": " + v2.calcularSalario());

        v2.realizarVenda(7450);

        System.out.print("Média de vendas do " + v2.getNome() + ": ");
        try {
            System.out.printf("%.2f\n", v2.mediaVenda());
        } catch (ExcecaoVendedorSemVendas e) {
            System.out.println(0);
        }

        System.out.println("Salário do " + g1.getNome() + ": " + g1.calcularSalario());

        System.out.println("Salário anual do " + g1.getNome() + ": " + g1.calcularSalarioAnual());

        g3.trocarDepartamento(d2);
        v2.trocarDepartamento(d2);

        System.out.println("Salário do " + g2.getNome() + ": " + g2.calcularSalario());

        d1.listarFuncionarios();
        d2.listarFuncionarios();

        FolhaPagamento f1 = new FolhaPagamento(Mes.JANEIRO, d1);

        f1.calcularTotalSalarios();

        System.out.println(d1.mediaVendaFuncionarios());
    }
}
