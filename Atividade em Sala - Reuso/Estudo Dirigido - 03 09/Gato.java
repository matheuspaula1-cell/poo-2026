class Gato extends Animal {
    private boolean gostaDeCaixa;
    public Gato(String nome, boolean gostaDeCaixa) {
        super(nome);
        this.gostaDeCaixa = gostaDeCaixa;
    }
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println(
            gostaDeCaixa
                ? "Adoro caixas!"
                : "Não sou muito fã de caixas."
        );
    }
}