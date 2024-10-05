package pokemon;

public abstract class Pokemon {
    private final String name;
    private final String type;
    private final String food;
    private final String sound;
    private int level;
    private float weight;
    private float height;
    private int hp;
    private int xp;

    public Pokemon(String name, String type, String food, String sound, int level, float weight, float height, int hp, int xp) {
        this.name = name;
        this.type = type;
        this.food = food;
        this.sound = sound;
        this.level = level;
        this.weight = weight;
        this.height = height;
        this.hp = hp;
        this.xp = xp;
    }

    public Pokemon(String name, String type, int level, int hp, String food, String sound) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFood() {
        return food;
    }

    public String getSound() {
        return sound;
    }

    public int getLevel() {
        return level;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }


    public String toString() {
        return "\n" + name + " is a " + type + " Pokemon with a weight of " + weight + " kg and a height of " + height +
                " m. \n -Level: " + level + "\n -HP: " + hp + "\n -XP: " + xp + "\n";
    }


    public abstract void eats();

    public void speaks() {
        System.out.println(getName() + " speaks: " + getSound());
    }

    public void feed(String food) {
        System.out.println(getName() + " gets " + food + " food from its owner.");

        if (food.equalsIgnoreCase(type)) {
            System.out.println(name + " enjoyed his meel and boosted its energy level and raised its HP with 20 points");
            setHp(getHp() + 20);
        } else {
            System.out.println(name + " didn't like this type of food. Its HP didn't change.");
        }
    }

    public void levelUp() {
        level++;
        hp += 50;
        xp = 0;
        System.out.println(name + " leveled up to level " + level + "! \n- HP is now: " + hp + " \n- xp is now: " + xp + "\n");
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + " has passed out and cannot play until hp is restored.\n");
        } else {
            System.out.println(name + " loses " + damage + " HP points. \n" + name + " has " + hp + " HP left.\n");
        }
    }

    public int calculateDamage(int power, int limit) {
        if (power > (limit/2)) {
            return (int) (Math.random() * 11) + 10;
        } else {
            return (int) (Math.random() * 10) + 1;
        }
    }
}
