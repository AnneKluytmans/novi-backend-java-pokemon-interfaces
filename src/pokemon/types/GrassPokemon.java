package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {
    private static final int maxChlorofylLevel = 1000;
    private static final List<String> attacks = Arrays.asList("LeafStorm", "SolarBeam", "LeechSeed", "LeafBlade");
    private int chlorofylLevel;

    public GrassPokemon(String name, String food, String sound, int level, float weight, float height, int hp, int xp, int chlorofylLevel) {
        super(name, "grass", food, sound, level, weight, height, hp, xp);
        this.chlorofylLevel = chlorofylLevel;
    }

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, "grass", level, hp, food, sound);
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


    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 1.5;
            case "electric" -> 2.5;
            case "fire" -> 2.0;
            case "grass" -> 1.2;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(chlorofylLevel, maxChlorofylLevel) * attackWeight);
    }


    public void leafStorm(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.2);

        System.out.println(getName() + " attacks " + opponent.getName() + " with LeafStorm.");
        opponent.takeDamage(damage);
        setChlorofylLevel(chlorofylLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void solarBeam(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.5);

        System.out.println(getName() + " uses SolarBeam on " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setChlorofylLevel(chlorofylLevel - 15);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

    public void leechSeed(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.5);

        System.out.println(getName() + " performs LeechSeed on " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setHp(getHp() + damage + 5);
        setChlorofylLevel(chlorofylLevel - 30);
        System.out.println(getName() + " has gained HP points. HP is now: " + getHp());
    }

    public void leaveBlade(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.2);

        System.out.println(getName() + " uses LeafBlade on " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setChlorofylLevel(chlorofylLevel - 5);
        setHp(getHp() + 5);
        System.out.println(getName() + " has gained 5 HP points. HP is now: " + getHp());
    }
}
