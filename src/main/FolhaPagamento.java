package main;

import java.util.ArrayList;

public class FolhaPagamento {
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
}