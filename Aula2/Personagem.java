public class Personagem {
    String nome;
    int vida;
    int forca;
    public void receberDano(int dano) {
        this.vida = this.vida - dano;
    }
    public boolean estaVivo() {
        return this.vida > 0;
    }
    public void ficha() {
        System.out.println(this.nome);
        System.out.println(this.vida);
        System.out.println(this.forca);
    }
    public void atacar(Personagem alvo) {
        alvo.receberDano(this.forca);
    }
}
class Main {
    public static void main(String[] args) {
        Personagem heroi = new Personagem();
        heroi.nome = "Herói";
        heroi.vida = 50;
        heroi.forca = 15;

        Personagem monstro = new Personagem();
        monstro.nome = "Monstro grande e Feio";
        monstro.vida = 40;
        monstro.forca = 10;


        System.out.println("--- FICHAS INICIAIS ---");
        heroi.ficha();
        System.out.println();
        monstro.ficha();
        System.out.println("-----------------------\n");

        while ((heroi.vida > 0) && (monstro.vida > 0)){
        System.out.println(heroi.nome + " ataca!");
        heroi.atacar(monstro);

        System.out.println("\nVida do inimigo após o ataque:");
        monstro.ficha();

        if ((monstro.vida > 0) && (heroi.vida > 0)){
        System.out.println("\nO inimigo ataca! ");
        monstro.atacar(heroi);

        System.out.println("\nVida do heroi após o ataque:");
        heroi.ficha();
        }

        }
        System.out.println("\n-------------------------- A LUTA ACABOU -------------------------");
    }
}