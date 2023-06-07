package main;

public class Vendedor extends Funcionario {
    private double valor_vendas;
    private int num_vendas;

    public Vendedor(String nome, double salario, String data_nascimento, Departamento departamento, double valor_vendas, int num_vendas) {
        super(nome, salario, data_nascimento, departamento);
        this.valor_vendas = valor_vendas;
        this.num_vendas = num_vendas;
    }

    public double getVendas() {
        return valor_vendas;
    }

    public double calcularSalario() {
        return getSalario() + (valor_vendas * 0.1);
    }

    public void realizarVenda(double valor){
        this.valor_vendas += valor;
        this.num_vendas += 1;
        System.out.println(this.getNome()+" realizou uma venda!");
    }

    public double mediaVenda() throws ExcecaoVendedorSemVendas{
    	if (num_vendas <= 0)
    		throw new ExcecaoVendedorSemVendas();
    	
    	return (valor_vendas / num_vendas);
    }
    
    //GETTERS:
    
    public double getValorVendas() {
    	return valor_vendas;
    }
    
    public int getNumVendas() {
    	return num_vendas;
    }
    
    //SETTERS:
    
    public void setValorVendas(double valor_vendas) {
    	this.valor_vendas = valor_vendas;
    }
    
    public void setNumVendas(int num_vendas) {
    	this.num_vendas = num_vendas;
    }
}