package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon {
    private static final int maxVoltage = 5000;
    private static final List<String> attacks = Arrays.asList("ThunderPunch", "ElectroBall", "Thunder", "VoltTackle");
    private int voltageLevel;

    public ElectricPokemon(String name, String food, String sound, int level, float weight, float height, int hp, int xp, int voltageLevel) {
        super(name, "electric", food, sound, level, weight, height, hp, xp);
        this.voltageLevel = voltageLevel;
    }

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, "electric", level, hp, food, sound);
    }


    public int getMaxVoltage() {
        return maxVoltage;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public int getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(int voltageLevel) {
        this.voltageLevel = Math.min(voltageLevel, maxVoltage);
    }


    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood() + " to boost its energy!");
        setVoltageLevel(voltageLevel + 50);
        setHp(getHp() + 20);
    }

    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 2.5;
            case "electric" -> 1.2;
            case "fire" -> 1.5;
            case "grass" -> 2.0;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(voltageLevel, maxVoltage) * attackWeight);
    }

    public void thunderPunch(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.2);

        System.out.println(getName() + " strikes " + opponent.getName() + " with ThunderPunch.");
        opponent.takeDamage(damage);
        setVoltageLevel(voltageLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void electroBall(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.5);

        System.out.println(getName() + " throws an Electro ball to " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setVoltageLevel(voltageLevel - 50);
        setHp(getHp() + 30);
        System.out.println(getName() + " has gained 30 HP points. HP is now: " + getHp());
    }

    public void thunder(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.4);

        System.out.println(getName() + " strikes " + opponent.getName() + " with Thunder.");
        switch(opponent.getType().toLowerCase()) {
            case "electric":
                opponent.setHp(opponent.getHp() + 15);
                System.out.println(opponent.getName() + " gaines 15 HP points and has now " + opponent.getHp() + " HP.");
                break;
            case "fire", "water", "grass":
            default:
                opponent.takeDamage(damage);
        }
        setVoltageLevel(voltageLevel - 25);
        setHp(getHp() + 20);
        System.out.println(getName() + " has gained 20 HP points. HP is now: " + getHp());
    }

    public void voltTackle(Pokemon opponent) {
        int damage = damageCalculator(opponent, 1.2);

        System.out.println(getName() + " uses VoltTackle on " + opponent.getName() + ".");
        opponent.takeDamage(damage);
        setVoltageLevel(voltageLevel - 25);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

}