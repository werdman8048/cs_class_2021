public class PokemonGame {
	public static void main(String args[]) {
		System.out.println("Hello!");
		Pokemon myPokemon = PokeFactory.CreatePokemon("Fanta");
		Pokemon myPokemon2 = PokeFactory.CreatePokemon("Coke");
		Pokemon myPokemon3 = PokeFactory.CreatePokemon("abc");
		System.out.println(myPokemon2);
	}
}
	
abstract class Pokemon {
	String type;
	String name;
	float hunger;
	float health;
	float experience;
	// damage will be based on experience
	public Pokemon( String type, String name, float health, float experience) {
		this.type = type;
		this.name = name;
		this.hunger = 0;
		this.health = health;
		this.experience = experience;
	}
	public void eat() {
		System.out.println(this.name + " is no longer hungry!");
		this.hunger -= 1;
	}
	public void speak() {
		System.out.println("Hello!!");
	}
	public void fight() {}
	public void heal() {
		System.out.println(this.name + " is now at full health!");
	}
}

class Fanta extends Pokemon {
	public Fanta() {
		super("Fanta", "orange", 20, 0);
	}
}

class Coke extends Pokemon {
	public Coke() {
		super("Coke", "cola-ey", 18, 0);
	}
}

class Sprite extends Pokemon {
	public Sprite() {
		super("Sprite", "lemony", 17, 0);
	}
}

class PokeFactory {
	public static Pokemon CreatePokemon( String PokemonTypeParam ) {
		switch (PokemonTypeParam) {
			case "Fanta":
        return new Fanta();
			case "Coke":
				return new Coke();
			default: 
				return new Sprite();
		}
	}
}
