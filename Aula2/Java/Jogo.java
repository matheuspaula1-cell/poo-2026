/* Foi utilizado de ferramentas tal como: ChatGPT e aplicativos de navegações para a realização do projeto. A IA generativa foi utilizada para:
Ajudar com um empurro inicial na direção correta; Debug; Boas práticas; Conferir se conclui o exercício.
Os Navegadores foi utilizados para:
Síntaxe de código. */

import java.util.ArrayList;
import java.util.List;

abstract class Personagem {
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

    public abstract void habilidadeEspecial(Personagem alvo);
}

class Monster extends Personagem {

    public Monster(String nome, int vida, int forca, int defesa) {
        super(nome, vida, forca, defesa);
    }

    @Override
    public void habilidadeEspecial(Personagem alvo) {
        System.out.println(this.nome + " usa uma investida selvagem em " + alvo.nome + "!");
        alvo.receberDano(this.forca / 2);
    }
}

public class Jogo {

    public static void main(String[] args) {

        List<Personagem> herois = new ArrayList<>();
        herois.add(new Mago("Elara", 50, 20, 0));
        herois.add(new Guerreiro("Conan", 75, 15, 5));

        Chefe chefe = new Chefe();

        System.out.println("--- FICHA DO CHEFE ---");
        chefe.ficha();
        System.out.println("-----------------------\n");

        System.out.println("--- HABILIDADES INICIAIS ---");
        for (Personagem heroi : herois) {
            heroi.ficha();
            heroi.habilidadeEspecial(chefe);
            System.out.println("-----------------------\n");
        }

        int rodada = 1;
        while (chefe.estaVivo() && algumHeroiVivo(herois)) {
            System.out.println("=========== RODADA " + rodada + " ===========\n");

            for (Personagem heroi : herois) {
                if (!heroi.estaVivo()) {
                    continue; // herói já morto não age
                }

                System.out.println(heroi.nome + " ataca " + chefe.nome + "!");
                heroi.atacar(chefe);
                chefe.ficha();

                if (!chefe.estaVivo()) {
                    System.out.println(chefe.nome + " foi derrotado!");
                    break; // Chefe morreu no meio da rodada, para tudo
                }

                System.out.println(chefe.nome + " revida contra " + heroi.nome + "!");
                chefe.atacar(heroi);
                heroi.ficha();

                if (!heroi.estaVivo()) {
                    System.out.println(heroi.nome + " foi derrotado!\n");
                }
            }

            rodada++;
        }

        System.out.println("\n-------------------------- A LUTA ACABOU -------------------------");
        System.out.println("--- FICHA FINAL DO CHEFE ---");
        chefe.ficha();

        System.out.println("--- STATUS FINAL DOS HERÓIS ---");
        for (Personagem heroi : herois) {
            System.out.println(heroi.nome + " - " + (heroi.estaVivo() ? "Sobreviveu" : "Caiu em batalha"));
        }

        System.out.println("\n--- MANA DOS MAGOS ---");
        for (Personagem heroi : herois) {
            if (heroi instanceof Mago) {
                Mago mago = (Mago) heroi;
                System.out.println(mago.nome + " - Mana restante: " + mago.getMana());
            }
        }
    }


    private static boolean algumHeroiVivo(List<Personagem> herois) {
        for (Personagem heroi : herois) {
            if (heroi.estaVivo()) {
                return true;
            }
        }
        return false;
    }
}