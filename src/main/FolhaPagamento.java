package main;


import java.util.ArrayList;

public class FolhaPagamento {
    private String mes;
    private double totalSalarios;

    public FolhaPagamento(String mes){
    	this.mes = mes;
        this.totalSalarios = 0;
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
        this.totalSalarios = totalSalarios;
        
        System.out.println("Folha de Pagamento ("+mes+"): "+totalSalarios);
    }
}