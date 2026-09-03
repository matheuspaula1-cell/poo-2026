class Cachorro extends Animal {
    private String raca;
    public Cachorro(String nome, String raca) {
        super(nome); 
        this.raca = raca;
    }
    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }
    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Sou um cachorro da raça " + raca + ".");
    }
}
