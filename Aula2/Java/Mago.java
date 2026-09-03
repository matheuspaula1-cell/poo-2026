public class Mago extends Personagem {
    private int mana;

    public Mago(String nome, int vida, int forca, int defesa) {
        super(nome, vida, forca, defesa);
        this.mana = 50;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("A mana não pode ser negativa.");
        }

        this.mana = mana;
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Mana: " + mana);
    }
    @Override
    public void habilidadeEspecial(Personagem alvo) {
        int custoMana = 10;
    
        if (this.mana < custoMana) {
            System.out.println(this.nome + " não tem mana suficiente para conjurar!");
            return;
        }
    
        this.mana -= custoMana;
        int danoMagico = this.forca * 2;
    
        System.out.println(this.nome + " usa rajada arcana!");
        alvo.receberDano(danoMagico);
    }
}
