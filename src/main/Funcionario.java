package main;


import java.io.*;

abstract class Funcionario implements Serializable{
    private String nome;
    private double salario;
    private String data_nascimento;
    private Departamento departamento;

    public Funcionario(String nome, double salario, String data_nascimento, Departamento departamento) {
        this.nome = nome; 
        this.salario = salario;
        this.data_nascimento = data_nascimento;
        this.departamento = departamento;
        departamento.adicionarFuncionario(this);
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getDataNascimento() {
        return data_nascimento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public double calcularSalarioAnual(){
        return salario*12;
    }

    public void trocarDepartamento(Departamento departamento_novo){
    	Departamento departamento_antigo = this.getDepartamento();
    	this.departamento = departamento_novo;
    	
    	departamento_antigo.removerFuncionario(this);
    	departamento_novo.adicionarFuncionario(this);
        
        System.out.println(this.getNome()+" trocou para o departamento "+departamento_novo.getNome());
    }

    public abstract double calcularSalario();
}