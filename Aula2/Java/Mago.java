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
}