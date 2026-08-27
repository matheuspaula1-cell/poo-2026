class Personagem:
    def __init__(self, nome, vida, forca, defesa=0):
        self.nome = nome
        self.vida = vida
        self.forca = forca
        self.defesa = defesa
        self.inventario = []

    def pegar(self, item):
        self.inventario.append(item)

        if item.atributo == "vida":
            self.vida += item.bonus

        if item.atributo == "ataque":
            self.forca += item.bonus

        if item.atributo == "defesa":
            self.defesa += item.bonus

    def receberDano(self, dano):
        dano_final = dano - self.defesa

        if dano_final < 0:
            dano_final = 0

        self.vida -= dano_final

    def estaVivo(self):
        return self.vida > 0

    def ficha(self):
        print(f"Nome: {self.nome}")
        print(f"Vida: {self.vida}")
        print(f"Força: {self.forca}")
        print(f"Defesa: {self.defesa}")
        print(f"Itens: {self.inventario}")

    def atacar(self, alvo):
        print(f"{self.nome} atacou {alvo.nome}!")
        alvo.receberDano(self.forca)


if __name__ == "__main__":

    from Item import Item
    from Mago import Mago
    from Guerreiro import Guerreiro

    espada = Item("Espada de Aço", 3, "ataque")

    elara = Mago("Elara", 50, 20, 0)
    elara.pegar(espada)

    print("=== FICHA DA MAGA ===")
    elara.ficha()

    bran = Guerreiro("Bran", 50, 15, 0)

    print("\n=== GUERREIRO ANTES DO DANO ===")
    bran.ficha()

    bran.receberDano(8)

    print("\n=== GUERREIRO APÓS RECEBER 8 DE DANO ===")
    print(f"Vida restante: {bran.vida}")

    print("\n=== TESTE DE MANA NEGATIVA ===")

    try:
        elara.mana = -10
    except ValueError as erro:
        print(f"Validação impediu a mana negativa: {erro}")