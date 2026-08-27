from PersonagemPy import Personagem


class Guerreiro(Personagem):
    def __init__(self, nome, vida, forca, defesa=0):
        super().__init__(nome, vida, forca, defesa)
        self.defesa = 5