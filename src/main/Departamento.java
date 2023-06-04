package main;

import java.util.ArrayList;

public class Departamento {
    private String nome;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Vendedor> vendedores;

    public Departamento(String nome) {
        this.nome = nome;
        this.gerentes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        if(funcionario instanceof Gerente) {
        	gerentes.add((Gerente) funcionario);
        }else if (funcionario instanceof Vendedor) {
        	vendedores.add((Vendedor) funcionario);
        }
    }

    public void removerFuncionario(Funcionario funcionario) {
    	if(funcionario instanceof Gerente && gerentes.contains(funcionario)) {
    		gerentes.remove(funcionario);
    	}else if(funcionario instanceof Vendedor && vendedores.contains(funcionario)) {
    		vendedores.remove(funcionario);
    	}
    }

    public void listarFuncionarios(){
    	System.out.println("=-=-=-=-=-=-=-=-"+this.getNome()+"-=-=-=-=-=-=-=-=");
    	
    	if(gerentes.size() > 0) {
    		System.out.println("Gerentes:");
    		for(Gerente g: gerentes) {
    			System.out.println(g.getNome() + "(" + g.getDataNascimento() + ")" + ": " + g.getSalario());
    		}
    		System.out.println();
    	}
    	if(vendedores.size() > 0) {
    		System.out.println("Vendedores:");
    		for(Vendedor v: vendedores) {
    			System.out.println(v.getNome() + "(" + v.getDataNascimento() + ")" + ": " + v.getSalario());
    		}
    		System.out.println();
    	}
    	
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }

    public double mediaVendaFuncionarios(){
    	double total_vendas = 0;
    	
        for (Vendedor v: vendedores){
            total_vendas += v.getVendas();
        }
        
        return total_vendas/vendedores.size();
    }
    
    //GETTERS:
    
    public String getNome(){
    	return nome;
    }

    public ArrayList<Gerente> getGerentes(){
        return gerentes;
    }

    public ArrayList<Vendedor> getVendedores(){
        return vendedores;
    }
    
    //SETTERS:
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
}