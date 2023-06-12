package main;
import java.io.*;
import java.util.ArrayList;

public class Departamento implements Serializable {
    private String nome;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Vendedor> vendedores;

    public Departamento(String nome) {
        this.nome = nome;
        this.gerentes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
    }

    public void adicionarFuncionario(String cargo, String nome, double salario, String dataNascimento, double bonus, double valorVendas, int numVendas) {
        if (cargo.equals("Vendedor")) {
            Vendedor vendedor = new Vendedor(nome, salario, dataNascimento, this, valorVendas, numVendas);
            vendedores.add(vendedor);
        } else {
            Gerente gerente = new Gerente(nome, salario, dataNascimento, this, bonus);
            gerentes.add(gerente);
        }
    }

    public void removerFuncionario(Funcionario funcionario) {
        if (funcionario instanceof Gerente && gerentes.contains(funcionario)) {
            gerentes.remove(funcionario);
        } else if (funcionario instanceof Vendedor && vendedores.contains(funcionario)) {
            vendedores.remove(funcionario);
        }
    }

    public void listarFuncionarios() {
        if (gerentes.size() > 0) {
            System.out.println("Gerentes:");
            for (Gerente g : gerentes) {
                System.out.println(g.getNome() + "(" + g.getDataNascimento() + ")" + ": " + g.getSalario());
            }
            System.out.println();
        }
        if (vendedores.size() > 0) {
            System.out.println("Vendedores:");
            for (Vendedor v : vendedores) {
                System.out.println(v.getNome() + "(" + v.getDataNascimento() + ")" + ": " + v.getSalario());
            }
            System.out.println();
        }
    }

    public double mediaVendaFuncionarios() {
        double totalVendas = 0;

        for (Vendedor v : vendedores) {
            totalVendas += v.getValorVendas();
        }

        if (vendedores.size() > 0) {
            return totalVendas / vendedores.size();
        } else {
            return 0;
        }
    }

    // GETTERS:

    public String getNome() {
        return nome;
    }

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public ArrayList<Vendedor> getVendedores() {
        return vendedores;
    }

    // SETTERS:

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Funções de persistência

    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);
        gravador.writeObject(this);
        gravador.close();
        arquivo.close();
    }

    public static Departamento abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        Departamento departamento = null;
        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);
        departamento = (Departamento) restaurador.readObject();

        restaurador.close();
        arquivo.close();

        return departamento;
    }
}
