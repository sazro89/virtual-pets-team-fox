package virtual_pet;

public class VirtualPet {
    private String name;
    private int hunger;
    private int thirst;
    private int boredom;


    public VirtualPet(String petName) {
        this.name = petName;
        this.hunger = 10;
        this.thirst = 10;
        this.boredom = 10;
    }

    public void tick() {
        hunger += 10; // this is equivalent to hunger = hunger + 10;
        thirst += 10;
        boredom += 10;
    }

    public String getName() {
        return name;
    }
    public int getHunger() { return hunger; }
    public int getThirst() { return thirst; }
    public int getBoredom() { return boredom; }

    public String feed() {
        hunger -= 10;
        return name;

    }


}
