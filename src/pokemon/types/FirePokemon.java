package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {
    private static final int maxTemperature = 500;
    private static final List<String> attacks = Arrays.asList("Inferno", "PyroBall", "FireLash", "FlameThrower");
    private int temperature = 194;

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

    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 2.0;
            case "electric" -> 1.5;
            case "fire" -> 1.2;
            case "grass" -> 2.5;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(temperature, maxTemperature) * attackWeight);
    }

    public void inferno(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.3);

        System.out.println(getName() + " uses Inferno on " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setTemperature(temperature - 30);
        setHp(getHp() + 20);
        System.out.println(getName() + " has gained 20 HP points. HP is now: " + getHp());
    }

    public void pyroBall(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.5);

        System.out.println(getName() + " throws a PyroBall to " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setTemperature(temperature - 20);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

    public void fireLash(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.2);

        System.out.println(getName() + " strikes " + opponent.getName() + " with FireLash.");
        opponent.takeDamage(damage);
        setTemperature(temperature - 15);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void flameThrower(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.4);

        System.out.println(getName() + " attacks " + opponent.getName() + " with FlameThrower.");
        opponent.takeDamage(damage);
        setTemperature(temperature - 20);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }
}
