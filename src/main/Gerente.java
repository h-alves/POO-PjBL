package main;

import java.util.Date;

public class Gerente extends Funcionario {
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
    
    //GETTER:
    
    public double getBonus() {
    	return bonus;
    }
    
    //SETTER:
    
    public void setBonus(double bonus) {
    	this.bonus = bonus;
    }
}