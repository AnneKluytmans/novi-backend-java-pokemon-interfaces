package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {
    private static final int maxChlorofylLevel = 1000;
    private static final List<String> attacks = Arrays.asList("LeafStorm", "SolarBeam", "LeechSeed", "LeafBlade");
    private int chlorofylLevel;

    public GrassPokemon(String name, String food, String sound, int level, float weight, float height, int hp, int xp, int chlorofylLevel) {
        super(name, "Grass", food, sound, level, weight, height, hp, xp);
        this.chlorofylLevel = chlorofylLevel;
    }

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, "Grass", level, hp, food, sound);
    }


    public int getMaxChlorofylLevel() {
        return maxChlorofylLevel;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public int getChlorofylLevel() {
        return chlorofylLevel;
    }

    public void setChlorofylLevel(int chlorofylLevel) {
        this.chlorofylLevel = Math.min(chlorofylLevel, maxChlorofylLevel);
    }


    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood() + " to grow and boost its chlorofyl level!");
        setChlorofylLevel(getChlorofylLevel() + 100);
        setHp(getHp() + 20);
    }

    public void leafStorm(Pokemon opponent) {
        int damage = calculateDamage(chlorofylLevel, maxChlorofylLevel);
        System.out.println(getName() + " attacks " + opponent.getName() + " with LeafStorm.");
        switch(opponent.getType().toLowerCase()) {
            case "fire":
                opponent.takeDamage(damage + 40);
                break;
            case "electric":
                opponent.takeDamage(damage + 50);
                break;
            case "water":
                opponent.takeDamage(damage + 30);
                break;
            case "grass":
                opponent.takeDamage(damage + 10);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setChlorofylLevel(chlorofylLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void solarBeam(Pokemon opponent) {
        int damage = calculateDamage(chlorofylLevel, maxChlorofylLevel);
        System.out.println(getName() + " uses SolarBeam on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "fire":
                opponent.takeDamage(damage + 30);
                break;
            case "electric":
                opponent.takeDamage(damage + 50);
                break;
            case "water":
                opponent.takeDamage(damage + 20);
                break;
            case "grass":
                opponent.takeDamage(damage + 5);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setChlorofylLevel(chlorofylLevel - 15);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

    public void leechSeed(Pokemon opponent) {
        int damage = calculateDamage(chlorofylLevel, maxChlorofylLevel);
        System.out.println(getName() + " performs LeechSeed on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "fire":
                opponent.takeDamage(damage + 25);
                setHp(getHp() + (damage + 25));
                break;
            case "electric":
                opponent.takeDamage(damage + 45);
                setHp(getHp() + (damage + 45));
                break;
            case "water":
                opponent.takeDamage(damage + 15);
                setHp(getHp() + (damage + 15));
                break;
            case "grass":
                opponent.takeDamage(damage + 5);
                setHp(getHp() + (damage + 5));
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setChlorofylLevel(chlorofylLevel - 30);
        setHp(getHp() + 5);
        System.out.println(getName() + " has gained HP points. HP is now: " + getHp());
    }

    public void leaveBlade(Pokemon opponent) {
        int damage = calculateDamage(chlorofylLevel, maxChlorofylLevel);
        System.out.println(getName() + " uses LeafBlade on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "fire":
                opponent.takeDamage(damage + 25);
                break;
            case "electric":
                opponent.takeDamage(damage + 30);
                break;
            case "water":
                opponent.takeDamage(damage + 15);
                break;
            case "grass":
                opponent.takeDamage(damage + 10);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setChlorofylLevel(chlorofylLevel - 5);
        setHp(getHp() + 5);
        System.out.println(getName() + " has gained 5 HP points. HP is now: " + getHp());
    }
}
