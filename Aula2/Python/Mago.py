from PersonagemPy import Personagem


class Mago(Personagem):
    def __init__(self, nome, vida, forca, defesa=0):
        super().__init__(nome, vida, forca, defesa)
        self.__mana = 50

    @property
    def mana(self):
        return self.__mana

    @mana.setter
    def mana(self, valor):
        if valor < 0:
            raise ValueError("A mana não pode ser negativa.")

        self.__mana = valor

    def ficha(self):
        super().ficha()
        print(f"Mana: {self.__mana}")