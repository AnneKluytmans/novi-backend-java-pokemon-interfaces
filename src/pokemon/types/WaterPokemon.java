package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {
    private static final int maxHydrationLevel = 2500;
    private static final List<String> attacks = Arrays.asList("Surf", "HydroPump", "RainDance", "HydroCanon");
    private int hydrationLevel = 1300;

    public WaterPokemon(String name, String food, String sound, int level, float weight, float height, int hp, int xp, int hydrationLevel) {
        super(name, "water", food, sound, level, weight, height, hp, xp);
        this.hydrationLevel = hydrationLevel;
    }

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, "water", level, hp, food, sound);
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
    public void eats() {
        System.out.println(getName() + " eats " + getFood() + " to boost its power and hydration level!");
        setHydrationLevel(hydrationLevel + 100);
        setHp(getHp() + 20);
    }

    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 1.2;
            case "electric" -> 2.0;
            case "fire" -> 2.5;
            case "grass" -> 1.5;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(hydrationLevel, maxHydrationLevel) * attackWeight);
    }

    public void surf(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.5);

        System.out.println(getName() + " attacks " + opponent.getName() + " with Surf.");
        opponent.takeDamage(damage);
        setHydrationLevel(hydrationLevel - 40);
        setHp(getHp() + 20);
        System.out.println(getName() + " has gained 20 HP points. HP is now: " + getHp());
    }

    public void hydroPump(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.2);

        System.out.println(getName() + " strikes " + opponent.getName() + " with HydroPump.");
        opponent.takeDamage(damage);
        setHydrationLevel(hydrationLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void rainDance(Pokemon opponent) {
        int damage = damageCalculator(opponent, 2.0);
        System.out.println(getName() + " performs RainDance on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "electric":
                System.out.println("RainDance has no effect on Electric Pokemon. " + opponent.getName() + " doesn't lose HP points.");
                break;
            case "grass":
                opponent.setHp(opponent.getHp() + 20);
                System.out.println(opponent.getName() + " gaines 20 HP points and has now " + opponent.getHp() + " HP.");
                break;
            case "fire", "water":
            default:
                opponent.takeDamage(damage);
        }
        setHydrationLevel(hydrationLevel - 50);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

    public void hydroCanon(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.5);

        System.out.println(getName() + " uses HydroCanon on " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setHydrationLevel(hydrationLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }
}
