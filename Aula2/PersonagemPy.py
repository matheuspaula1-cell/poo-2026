class Personagem:
    def __init__(self, nome, vida, forca):
        self.nome = nome
        self.vida = vida
        self.forca = forca
    def ReceberDano(self, dano):
        self.vida = self.vida - dano
    
    def estaVivo(self):
        return self.vida > 0
    
    def ficha(self):
        print(f"Nome: {self.nome} | Vida: {self.vida} | Força: {self.forca}")

    def atacar(self, alvo):
        print(f"{self.nome} atacou {alvo.nome}!")
        alvo.ReceberDano(self.forca)

heroi = Personagem("Heroi", 50, 15)
monstro = Personagem("Monstro grande e Feio", 75, 5)

print("=== INÍCIO DA BATALHA ===")
heroi.ficha()
monstro.ficha()
print("=========================\n")

while heroi.estaVivo() and monstro.estaVivo():
    
    heroi.atacar(monstro)
    monstro.ficha()
    
    if not monstro.estaVivo():
        print(f"\nO {monstro.nome} foi derrotado!")
        break
        
    monstro.atacar(heroi)
    heroi.ficha()
    
    if not heroi.estaVivo():
        print(f"\nO {heroi.nome} foi derrotado!")
        break
    print(f"\n")

print("\n=== FIM DA SIMULAÇÃO ===")