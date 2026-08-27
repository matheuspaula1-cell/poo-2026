class Item {
    private String nome;
    private int bonus;
    private String atributo;

    public Item(String nome, int bonus, String atributo) {
        this.nome = nome;

        if (bonus < 0) {
            throw new IllegalArgumentException("O bônus não pode ser negativo.");
        }

        this.bonus = bonus;
        this.atributo = atributo;
    }

    public String getNome() {
        return nome;
    }

    public int getBonus() {
        return bonus;
    }

    public String getAtributo() {
        return atributo;
    }

    public String descricao() {
        return nome + " (+" + bonus + " " + atributo + ")";
    }
    @Override
    public String toString() {
        return descricao();
}
}