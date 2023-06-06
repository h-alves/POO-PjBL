package main;

import java.io.*;

abstract class Funcionario {
    transient private String nome;
    transient private double salario;
    transient private String data_nascimento;
    transient private Departamento departamento;

    public Funcionario(String nome, double salario, String data_nascimento, Departamento departamento) {
        this.nome = nome; 
        this.salario = salario;
        this.data_nascimento = data_nascimento;
        this.departamento = departamento;
        departamento.adicionarFuncionario(this);
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

    //GETTERS:

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
    
    //SETTERS:
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public void setSalario(double salario) {
    	this.salario = salario;
    }
    
    public void setDataNascimento(String data_nascimento) {
    	this.data_nascimento = data_nascimento;
    }
    
}