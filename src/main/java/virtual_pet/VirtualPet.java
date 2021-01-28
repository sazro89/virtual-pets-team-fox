package virtual_pet;

import java.util.Locale;

public class VirtualPet {
    private String name;
    private int hunger;
    private int thirst;
    private int boredom;


    public VirtualPet(String petName) {
        this.name = petName.substring(0,1).toUpperCase() + petName.substring(1).toLowerCase();
        this.hunger = 10;
        this.thirst = 10;
        this.boredom = 10;
    }

    public void tick() {
        hunger += 10; // this is equivalent to hunger = hunger + 10;
        thirst += 10;
        boredom += 10;
    }

    public void feed() {
        hunger -= 10;
    }

    public void play() {
        boredom -= 10;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

   public int getBoredom() {
        return boredom;
    }


}
