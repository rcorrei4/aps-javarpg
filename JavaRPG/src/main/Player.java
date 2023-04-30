package main;
public class Player extends Character {

	public int numAtkUpgrades, numDefUpgrades;

	// Arrays para guardar os atributos/habilidades
	public String[] atkUpgrades = { "Arma Corporal", "Espada", "Metralhadora" };
	public String[] defUpgrades = { "Escudo", "Droga p/ aumento de força", "Estimulante" };

	public Player(String name) {
		super(name, 100, 100, 0);
		// Setando upgrades para 0
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		// O jogador pode escolher uma habilidade

	}

	@Override
	public int attack() {
		return 0;

	}

	@Override
	public int defend() {
		return 0;
	}

	public void chooseTrait() {
		GameLogic.printHeading("Escolha uma habilidade: ");
		System.out.println("(1) " + atkUpgrades[0]);
		System.out.println("(2) " + atkUpgrades[1]);
		System.out.println("(3) " + atkUpgrades[2]);

		int input = GameLogic.readInt("-> ", 3);
		// lidando com os casos
		if (input == 1) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[0] + "!");

		} else if (input == 2) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[1] + "!");
			numDefUpgrades++;
		} else if (input == 3) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[2] + "!");
			numDefUpgrades++;
		}
	}

}
