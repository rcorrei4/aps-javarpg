public class Player extends Character{

	public int numAtkUpgrades, numDefUpgrades; 
	
	// 	Arrays para guardar os atributos/habilidades
	public String[] atkUpgrades = {"Força", "Poder", "Arma Corporal"};
	public String [] defUpgrades = {"Escudo","Droga p/ aumento de força", "Estimulante"};
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
		System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2) " + defUpgrades[numDefUpgrades]);
		
		int input = GameLogic.readInt("-> ", 3);
		GameLogic.clearConsole();
		// lidando com os dois casos
		if (input == 1) {
			GameLogic.printHeading("Você escolheu: " + atkUpgrades[numAtkUpgrades] + "!");
			
		}else {
			GameLogic.printHeading("Você escolheu: " + defUpgrades[numDefUpgrades] + "!");
			numDefUpgrades++;
		}
		GameLogic.anythingToContinue();
	}

}
