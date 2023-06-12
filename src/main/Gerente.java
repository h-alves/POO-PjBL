package main;

import java.io.*;
import java.util.Date;

public class Gerente extends Funcionario implements Serializable{
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

    //Funções das persistencias

    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public static Funcionario abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        Gerente gerente = null;

        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        gerente = (Gerente) restaurador.readObject();
        restaurador.close();
        arquivo.close();
        return gerente;
    }

}
