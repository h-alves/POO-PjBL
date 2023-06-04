package main;


public class Gerente extends Funcionario {
    private Departamento departamento;
    private double bonus;

    public Gerente(String nome, double salario, String data_nascimento, Departamento departamento, double bonus) {
        super(nome, salario, data_nascimento, departamento);
        this.bonus = bonus;
    }

    @Override
    public double calcularSalarioAnual(){
        return (calcularSalario()*12 + getSalario());
    }
    
    public double calcularSalario() {
        return getSalario() + bonus;
    }
}