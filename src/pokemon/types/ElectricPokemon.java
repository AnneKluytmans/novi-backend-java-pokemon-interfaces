package pokemon.types;

import pokemon.Pokemon;

import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon {
    private static final int maxVoltage = 10000;
    private static final List<String> attacks = Arrays.asList("ThunderPunch", "ElectroBall", "Thunder", "VoltTackle");
    private int voltageLevel;

    public ElectricPokemon(String name, int level, float weight, float height, int hp, int xp, int voltageLevel) {
        super(name, "Electric", "lightning", "Wroaaaarrrr",
                level, weight, height, hp, xp);
        this.voltageLevel = voltageLevel;
    }


    public int getMaxVoltage() {
        return maxVoltage;
    }

    public int getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(int voltageLevel) {
        this.voltageLevel = Math.min(voltageLevel, maxVoltage);
    }

    public List<String> getAttacks() {
        return attacks;
    }


    @Override
    public void feed() {
        System.out.println(getName() + " absorbs " + getFood() + " to boost its energy!");
        setHp(getHp() + 20);
    }

    @Override
    public void speaks() {
        System.out.println(getName() + " speaks: " + getSound());
    }

    public void thunderPunch(Pokemon opponent) {
        int damage = voltageLevel / 4;
        System.out.println(getName() + " strikes " + opponent.getName() + " with a ThunderPunch.");
        switch(opponent.getType().toLowerCase()) {
            case "grass":
                opponent.takeDamage(damage + 50);
                break;
            case "water":
                opponent.takeDamage(damage + 70);
                break;
            case "fire":
                opponent.takeDamage(damage + 30);
                break;
            case "electric":
                opponent.takeDamage(damage + 10);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setVoltageLevel(voltageLevel - 20);
        setHp(getHp() + 10);
        System.out.println(getName() + " has gained 10 HP points. HP is now: " + getHp());
    }

    public void electroBall(Pokemon opponent) {
        int damage = voltageLevel / 2;
        System.out.println(getName() + " throws an Electro ball to " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "grass":
                opponent.takeDamage(damage + 45);
                break;
            case "water":
                opponent.takeDamage(damage + 65);
                break;
            case "fire":
                opponent.takeDamage(damage + 25);
                break;
            case "electric":
                opponent.takeDamage(damage + 5);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setVoltageLevel(voltageLevel - 50);
        setHp(getHp() + 30);
        System.out.println(getName() + " has gained 30 HP points. HP is now: " + getHp());
    }

    public void thunder(Pokemon opponent) {
        int damage = voltageLevel / 3;
        System.out.println(getName() + " strikes " + opponent.getName() + " with Thunder.");
        switch(opponent.getType().toLowerCase()) {
            case "grass":
                opponent.takeDamage(damage + 60);
                break;
            case "water":
                opponent.takeDamage(damage + 80);
                break;
            case "fire":
                opponent.takeDamage(damage + 40);
                break;
            case "electric":
                opponent.setHp(opponent.getHp() + 15);
                System.out.println(opponent.getName() + " gaines 15 HP points and has now " + opponent.getHp() + " HP.");
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setVoltageLevel(voltageLevel - 25);
        setHp(getHp() + 20);
        System.out.println(getName() + " has gained 20 HP points. HP is now: " + getHp());
    }

    public void voltTackle(Pokemon opponent) {
        int damage = voltageLevel / 4;
        System.out.println(getName() + " uses a VoltTackle on " + opponent.getName() + ".");
        switch(opponent.getType().toLowerCase()) {
            case "grass":
                opponent.takeDamage(damage + 45);
                break;
            case "water":
                opponent.takeDamage(damage + 55);
                break;
            case "fire":
                opponent.takeDamage(damage + 35);
                break;
            case "electric":
                opponent.takeDamage(damage + 15);
                break;
            default:
                System.out.println("This type of pokemon cannot compete.");
        }
        setVoltageLevel(voltageLevel - 25);
        setHp(getHp() + 15);
        System.out.println(getName() + " has gained 15 HP points. HP is now: " + getHp());
    }

}