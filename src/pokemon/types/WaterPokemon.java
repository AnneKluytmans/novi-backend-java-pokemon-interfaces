package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {
    private static final int maxHydrationLevel = 2500;
    private static final List<String> attacks = Arrays.asList("", "", "", "");
    private int hydrationLevel;

    public WaterPokemon(String name, String food, String sound, int level, float weight, float height, int hp, int xp, int hydrationLevel) {
        super(name, "Fire", food, sound, level, weight, height, hp, xp);
        this.hydrationLevel = hydrationLevel;
    }

    public int getMaxHydrationLevel() {
        return maxHydrationLevel;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public int getHydrationLevel() {
        return hydrationLevel;
    }

    public void setHydrationLevel(int hydrationLevel) {
        this.hydrationLevel = hydrationLevel;
    }


    @Override
    public void feed() {
        System.out.println(getName() + " eats " + getFood() + " to boost its power and hydration level!");
        setHydrationLevel(hydrationLevel + 100);
        setHp(getHp() + 20);
    }

    public void surf(Pokemon opponent) {
        int damage = calculateDamage(hydrationLevel, maxHydrationLevel);
        System.out.println(getName() + " attacks " + opponent.getName() + " with Surf.");
        switch(opponent.getType().toLowerCase()) {
            case "electric":
                opponent.takeDamage(damage + 55);
                break;
            case "fire":
                opponent.takeDamage(damage + 75);
                break;
            case "grass":
                opponent.takeDamage(damage + 35);
                break;
            case "water":
                opponent.takeDamage(damage + 15);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setHydrationLevel(hydrationLevel - 40);
        setHp(getHp() + 20);
        System.out.println(getName() + " has gained 20 HP points. HP is now: " + getHp());
    }

    public void hydroPump(Pokemon opponent) {
        int damage = calculateDamage(hydrationLevel, maxHydrationLevel);
        System.out.println(getName() + " strikes " + opponent.getName() + " with HydroPump.");
        switch(opponent.getType().toLowerCase()) {
            case "electric":
                opponent.takeDamage(damage + 50);
                break;
            case "fire":
                opponent.takeDamage(damage + 70);
                break;
            case "grass":
                opponent.takeDamage(damage + 30);
                break;
            case "water":
                opponent.takeDamage(damage + 5);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setHydrationLevel(hydrationLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void RainDance(Pokemon opponent) {
        int damage = calculateDamage(hydrationLevel, maxHydrationLevel);
        System.out.println(getName() + " performs RainDance on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "electric":
                System.out.println("RainDance has no effect on Electric Pokemon. " + opponent.getName() + " doesn't lose HP points.");
                break;
            case "fire":
                opponent.takeDamage(damage + 65);
                break;
            case "grass":
                opponent.setHp(opponent.getHp() + 20);
                System.out.println(opponent.getName() + " gaines 20 HP points and has now " + opponent.getHp() + " HP.");
                break;
            case "water":
                opponent.takeDamage(damage + 5);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setHydrationLevel(hydrationLevel - 50);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

    public void hydroCanon(Pokemon opponent) {
        int damage = calculateDamage(hydrationLevel, maxHydrationLevel);
        System.out.println(getName() + " uses HydroCanon on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "electric":
                opponent.takeDamage(damage + 40);
                break;
            case "fire":
                opponent.takeDamage(damage + 50);
                break;
            case "grass":
                opponent.takeDamage(damage + 20);
                break;
            case "water":
                opponent.takeDamage(damage + 10);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setHydrationLevel(hydrationLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }
}
