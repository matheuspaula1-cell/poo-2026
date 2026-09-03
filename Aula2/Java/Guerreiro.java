public class Guerreiro extends Personagem {
    private int mana;

    public Guerreiro(String nome, int vida, int forca, int defesa) {
        super(nome, vida, forca, defesa);
    }

    @Override
    public void habilidadeEspecial(Personagem alvo) {
        this.defesa += 5;
        System.out.println(this.nome + " usa fúria de batalha e ganha defesa!");
    }
}
