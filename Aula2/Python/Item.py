class Item:
    def __init__(self, nome, bonus, atributo):
        self.nome = nome

        if bonus < 0:
            raise ValueError("O bônus não pode ser negativo.")

        self.bonus = bonus
        self.atributo = atributo

    def descricao(self):
        return f"{self.nome} (+{self.bonus} {self.atributo})"

    def __str__(self):
        return self.descricao()

    def __repr__(self):
        return self.descricao()