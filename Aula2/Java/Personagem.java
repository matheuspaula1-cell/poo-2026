/* Foi utilizado de ferramentas tal como: ChatGPT e aplicativos de navegações para a realização do projeto. A IA generativa foi utilizada para:
Ajudar com um empurro inicial na direção correta; Debug; Boas práticas; Conferir se conclui o exercício.
Os Navegadores foi utilizados para:
Síntaxe de código. */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personagem {
    String nome;
    int vida;
    int forca;
    int defesa;

    private List<Item> inventario = new ArrayList<>();
    public void pegar(Item item) {
    inventario.add(item);

        if (item.getAtributo().equals("vida")) {
            this.vida += item.getBonus();
    }

        if (item.getAtributo().equals("ataque")) {
            this.forca += item.getBonus();
    }

        if (item.getAtributo().equals("defesa")) {
            this.defesa += item.getBonus();
    }
}
    public List<Item> getInventario() {
        return inventario;
    }
    public void receberDano(int dano) {
        int danoFinal = dano - this.defesa;
            if (danoFinal < 0) {
                danoFinal = 0;
            }
        this.vida -= danoFinal;
}
    public boolean estaVivo() {
        return this.vida > 0;
    }
    public void ficha() {
        System.out.println(this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Forca: " + this.forca);
        System.out.println("Defesa: " + this.defesa);
        System.out.println("Itens: " + this.inventario + "\n");
    }
    public void atacar(Personagem alvo) {
        alvo.receberDano(this.forca);
    }
    public Personagem() {
    }

    public Personagem(String nome, int vida, int forca, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
    }

    public static void main(String[] args) {
        /*  "Personagem heroi = new Personagem();
        heroi.nome = "Herói";
        heroi.vida = 50;
        heroi.forca = 15 */
        Mago heroi = new Mago("Gandalf do Rodo", 50, 30, 0);
       /*  Guerreiro heroi = new Guerreiro("Conan do Rodo", 75, 5, 5); */

        Personagem monstro = new Personagem();
        monstro.nome = "Monstro grande e Feio";
        monstro.vida = 40;
        monstro.forca = 10;


        System.out.println("--- FICHAS INICIAIS ---");
        heroi.ficha();
        System.out.println();
        monstro.ficha();
        System.out.println("-----------------------\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("O que fazer antes do ataque?\n 0: Nada \n 1: Adquirir e Equipar item.");
        int Escolha = scanner.nextInt();
        if (Escolha == 1){
            Item espada = new Item("Espada de Aço", 3, "ataque");
            heroi.pegar(espada);
        }

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