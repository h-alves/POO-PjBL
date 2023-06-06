package main;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FolhaPagamento implements Serializable {
	private Mes mes;
    private double total_salarios;

    public FolhaPagamento(Mes mes){
    	this.mes = mes;
        this.total_salarios = 0;
    }

    public void calcularTotalSalarios(Departamento departamento) {
    	ArrayList<Gerente> gerentes = departamento.getGerentes();
    	ArrayList<Vendedor> vendedores = departamento.getVendedores();
    	
        double totalSalarios = 0;
        for (Gerente g: gerentes) {
            totalSalarios += g.calcularSalario();
        }
        for (Vendedor v: vendedores) {
        	totalSalarios += v.calcularSalario();
        }
        this.total_salarios = total_salarios;
        
        System.out.println("Folha de Pagamento ("+mes.name().toLowerCase()+"): "+totalSalarios);
    }
    
    //GETTERS:
    
    public Mes getMes() {
    	return mes;
    }
    
    public double getTotalSalarios() {
    	return total_salarios;
    }
    
    //SETTERS:
    
    public void setMes(Mes mes) {
    	this.mes = mes;
    }
    
    public void setTotalSalarios(double total_salarios) {
    	this.total_salarios = total_salarios;
    }

    //Funções das persistencias

    public void salvar(String nome_arquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nome_arquivo);
        ObjectOutputStream gravador = new ObjectOutputStream(arquivo);

        gravador.writeObject(this);

        gravador.close();
        arquivo.close();
    }

    public static FolhaPagamento abrir(String nome_arquivo) throws IOException, ClassNotFoundException {
        FolhaPagamento folhaPagamento = null;

        FileInputStream arquivo = new FileInputStream(nome_arquivo);
        ObjectInputStream restaurador = new ObjectInputStream(arquivo);

        folhaPagamento = (FolhaPagamento) restaurador.readObject();
        restaurador.close();
        arquivo.close();
        return folhaPagamento;
    }

}