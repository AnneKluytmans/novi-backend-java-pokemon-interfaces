package pokemon;

public abstract class Pokemon {
    private final String name;
    private final String type;
    private final String food;
    private final String sound;
    private final int level;
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

}
