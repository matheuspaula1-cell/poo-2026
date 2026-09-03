/* Inteligência Artificial foi utilizada neste projeto para a seguinte finalidade: Orientação sobre como realizar o próximo passo; Debug/Correção de Erros;
Orientação de práticas saudáveis; Utilização correta do conteúdo apresentado em sala de aula. */

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    protected String nome;
    public Animal(String nome) {
        this.nome = nome;
    }
    public abstract void emitirSom();
    public void apresentar() {
        System.out.println("Meu nome é " + nome + ".");
    }
}

/* CÓDIGO QUE VAI SER EXECUTADO */

public class Main {

    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Cachorro("Dogão", "Siberiano"));
        animais.add(new Gato("Lo Siento Muito Pequenino", true));
        for (Animal animal : animais) {
            animal.apresentar();
            animal.emitirSom();
            System.out.println("- OUTRO ANIMAL -");
        }
}}

/* Auto Avaliação:
- A saída é o esperado. O mesmo comando, emitirSom e Apresentar mostram ambos resultados diferentes devido a implementação de funcionalidaes próprias em Cachorro e Gato(Arquivos)
- Creio que todos os critérios tenham sido atingidos.
- - SuperClasse é o Animal
- - SubClasses são Gato e Cachorro
- - Cachorro adiciona Raça, Gato adiciona se ele é fã de caixa ou não.
- - super.apresentar permite o reaproveitamento do apresentar.
- - O For percorre o laço sem instance.
- - E a saída é o mesmo comando produzindo resultados diferentes. 
- Treço com maior trabalho foi fazer a ligação entre os arquivos que resolvi criar por organização, porém, não é tão difícil.
- Uso de IA reportado na primeira linha.*/