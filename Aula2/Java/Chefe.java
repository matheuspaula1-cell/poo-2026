public class Chefe extends Personagem {
    private int mana;

    public Chefe() {
        super("[MONSTRO CHEFE] Rei Lich - Nicolás de Bal Duro", 200, 20, 0);
    }

    @Override
    public void habilidadeEspecial(Personagem alvo) {
        System.out.println(this.nome + " Portões dos 9 infernos abissais!");
        this.forca += 30;
    }
}
