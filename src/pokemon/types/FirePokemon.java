package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {
    private static final int maxTemperature = 500;
    private static final List<String> attacks = Arrays.asList("Inferno", "PyroBall", "FireLash", "FlameThrower");
    private int temperature;

    public FirePokemon(String name, String food, String sound, int level, float weight, float height, int hp, int xp, int temperature) {
        super(name, "fire", food, sound, level, weight, height, hp, xp);
        this.temperature = temperature;
    }

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, "fire", level, hp, food, sound);
    }



    public int getMaxTemperature() {
        return maxTemperature;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = Math.min(temperature, maxTemperature);
    }


    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood() + " to boost its power and temperature!");
        setTemperature(temperature + 30);
        setHp(getHp() + 20);
    }

    public void inferno(Pokemon opponent) {
        int damage = calculateDamage(temperature, maxTemperature);
        System.out.println(getName() + " uses Inferno on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "water":
                opponent.takeDamage(damage + 55);
                break;
            case "grass":
                opponent.takeDamage(damage + 75);
                break;
            case "electric":
                opponent.takeDamage(damage + 35);
                break;
            case "fire":
                opponent.takeDamage(damage + 15);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setTemperature(temperature - 30);
        setHp(getHp() + 20);
        System.out.println(getName() + " has gained 20 HP points. HP is now: " + getHp());
    }

    public void pyroBall(Pokemon opponent) {
        int damage = calculateDamage(temperature, maxTemperature);
        System.out.println(getName() + " throws a PyroBall to " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "water":
                opponent.takeDamage(damage + 40);
                break;
            case "grass":
                opponent.takeDamage(damage + 50);
                break;
            case "electric":
                opponent.takeDamage(damage + 30);
                break;
            case "fire":
                opponent.takeDamage(damage + 10);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setTemperature(temperature - 20);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

    public void fireLash(Pokemon opponent) {
        int damage = calculateDamage(temperature, maxTemperature);
        System.out.println(getName() + " strikes " + opponent.getName() + " with FireLash.");
        switch(opponent.getType().toLowerCase()) {
            case "water":
                opponent.takeDamage(damage + 35);
                break;
            case "grass":
                opponent.takeDamage(damage + 50);
                break;
            case "electric":
                opponent.takeDamage(damage + 20);
                break;
            case "fire":
                opponent.takeDamage(damage + 5);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setTemperature(temperature - 15);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void flameThrower(Pokemon opponent) {
        int damage = calculateDamage(temperature, maxTemperature);
        System.out.println(getName() + " attacks " + opponent.getName() + " with FlameThrower.");
        switch(opponent.getType().toLowerCase()) {
            case "water":
                opponent.takeDamage(damage + 45);
                break;
            case "grass":
                opponent.takeDamage(damage + 60);
                break;
            case "electric":
                opponent.takeDamage(damage + 30);
                break;
            case "fire":
                opponent.takeDamage(damage + 10);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setTemperature(temperature - 20);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }
}
