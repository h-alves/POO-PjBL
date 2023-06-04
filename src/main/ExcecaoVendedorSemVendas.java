package main;

class ExcecaoVendedorSemVendas extends Exception {

    public ExcecaoVendedorSemVendas(String mensagem) {
        super(mensagem);
    }

    public ExcecaoVendedorSemVendas() {
        super();
    }
}
