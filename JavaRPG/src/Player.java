public class Player extends Character {

	public int numAtkUpgrades, numDefUpgrades;

	// Arrays para guardar os atributos/habilidades
	public String[] atkUpgrades = { "Força", "Poder", "Arma Corporal" };
	public String[] defUpgrades = { "Escudo", "Droga p/ aumento de força", "Estimulante" };

	public Player(String name) {
		super(name, 100, 0);
		// Setando upgrades para 0
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		// O jogador pode escolher uma habilidade
		chooseTrait();
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
		GameLogic.clearConsole();
		GameLogic.printHeading("Escolha uma habilidade: ");
		System.out.println("(1) " + atkUpgrades[0]);
		System.out.println("(2) " + atkUpgrades[1]);
		System.out.println("(3) " + atkUpgrades[2]);
		System.out.println("(4) " + defUpgrades[0]);
		System.out.println("(5) " + defUpgrades[1]);
		System.out.println("(6) " + defUpgrades[2]);

		int input = GameLogic.readInt("-> ", 6);
		GameLogic.clearConsole();
		// lidando com os casos
		if (input == 1) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[0] + "!");
		} else if (input == 2) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[1] + "!");
			numDefUpgrades++;
		} else if (input == 3) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[2] + "!");
			numDefUpgrades++;
		} else if (input == 4) {
			GameLogic.printHeading("Você escolheu: " + defUpgrades[0] + "!");
			numDefUpgrades++;
		} else if (input == 5) {
			GameLogic.printHeading("Você escolheu: " + defUpgrades[1] + "!");
			numDefUpgrades++;
		} else if (input == 6) {
			GameLogic.printHeading("Você escolheu: " + defUpgrades[2] + "!");
			numDefUpgrades++;
		}
		GameLogic.anythingToContinue();
	}

}
