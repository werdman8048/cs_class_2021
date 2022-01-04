import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PokemonGame {

	static Pokemon makeWild() {
		List<String> givenList = Arrays.asList("Fire", "Water", "Leaf");
    Random rand = new Random();
    String enemyType = givenList.get(rand.nextInt(givenList.size()));
		return PokeFactory.CreatePokemon(enemyType, false);
	}

	static void lastCase(Pokemon uPokemon) {
		Scanner scanner = new Scanner(System.in);
		Pokemon wildPokemon = makeWild();
		System.out.println("You've come across a wild " + wildPokemon.type + " Pokemon");
		System.out.println("Do you still want to fight?");
		System.out.println("0: No, Flee");
		System.out.println("1: Yes, Fight");

		int inputnum = scanner.nextInt();

		switch (inputnum) {
			case 0: 
				break;
			case 1: 
				uPokemon.fight(wildPokemon);
				break;
		}
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the type of your Pokemon: ");
		String type = scanner.nextLine();
		Pokemon userPokemon = PokeFactory.CreatePokemon(type, true);
		System.out.println("You created a new " + userPokemon.type + " Pokemon");
		int inputnum = -1;

		while (inputnum != 0) {
			if (userPokemon.health <= 0) {
				break;
			}
			if (userPokemon.hunger <= 1) {System.out.println("Your Pokemon is very hungry!");}
			if (userPokemon.health <= 2) {System.out.println("Your Pokemon is about to die");}

			System.out.println();

			System.out.println("0: Quit");
			System.out.println("1: Feed your Pokemon");
			System.out.println("2: Make your Pokemon talk");
			System.out.println("3: Go to the medical facility");
			System.out.println("4: Fight a wild pokemon!");

			inputnum = scanner.nextInt();

			switch (inputnum) {
				case 0: 
					break;
				case 1: 
					userPokemon.eat();
					break;
				case 2:
					userPokemon.speak();
					break;
				case 3: 
					userPokemon.heal();
					break;
				case 4:
					lastCase(userPokemon);
					break;
				default:
					System.out.println("Illegal value entered");
			}
		}
	}
}
	
abstract class Pokemon {
	String type;
	String weakType;
	float hunger;
	float health;
	float experience;
	float damage;
	// damage will be based on experience
	public Pokemon( String type, float health, float experience) {
		this.type = type;
		this.hunger = 10;
		this.health = health;
		this.experience = experience;

		switch (type) {
			case "Fire":
				this.weakType = "Water";
				break;
			case "Water":
				this.weakType = "Leaf";
				break;
			default:
				this.weakType = "Fire";
				break;
		}

		this.damage = this.experience*2 + 1;
	}
	public void eat() {
		System.out.println("Your Pokemon is no longer hungry!");
		this.hunger -= 1;
	}
	public void speak() {
		System.out.println("Hello!!");
	}
	public void fight(Pokemon wildPokemon) {
		if (this.weakType == wildPokemon.type) {
			float modDamage = wildPokemon.damage * 3;
			fightHelper(this.damage, modDamage, this, wildPokemon);
			this.hunger -= 1;
		} else if (this.type == wildPokemon.weakType) {
			float modDamage = this.damage * 3;
			fightHelper(modDamage, wildPokemon.damage, this, wildPokemon);
			this.hunger -= 1;
		} else {
			fightHelper(this.damage, wildPokemon.damage, this, wildPokemon);
			this.hunger -= 1;
		}
		this.experience += 1;
		this.damage = this.experience*2 +1;
	}
	private void fightHelper(float userDamage, float enemyDamage, Pokemon userPoke, Pokemon wildPoke) {
		while (true) {
			wildPoke.health -= userDamage;
			if (wildPoke.health <= 0) {
				System.out.println("The wild Pokemon has been slain");
				break;
			}
			System.out.println("Wild Pokemon health: " + wildPoke.health);
			userPoke.health -= enemyDamage;
			if (userPoke.health <= 0 ) {
				System.out.println("Your Pokemon has been slain");
				break;
			}
			System.out.println("Your Pokemon health: " + userPoke.health);
		}
	}
	public void heal() {
		System.out.println("Your Pokemon is now at full health!");
	}
}

class Fire extends Pokemon {
	public Fire(boolean isUsers) {
		super("Fire", 50, 0);
		if (isUsers) {
			this.health = 70;
		}
	}
}

class Water extends Pokemon {
	public Water(boolean isUsers) {
		super("Water", 50, 0);
		if (isUsers) {
			this.health = 70;
		}
	}
}

class Leaf extends Pokemon {
	public Leaf(boolean isUsers) {
		super("Leaf", 50, 0);
		if (isUsers) {
			this.health = 70;
		}
	}
}

class PokeFactory {
	public static Pokemon CreatePokemon(String pokemonType, boolean isUserPokemon ) {
		switch (pokemonType) {
			case "Fire":
				return new Fire(isUserPokemon);
			case "Water":
				return new Water(isUserPokemon);
			default: 
				return new Leaf(isUserPokemon);
		}
		
	}
}
