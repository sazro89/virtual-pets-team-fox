package virtual_pet;

public class VirtualPet {

    //instance  variables
    private String name;
    private int hunger;
    private int thirst;
    private int boredom;


    // class constructor
    public VirtualPet(String petName) {
        this.name = petName;
        this.hunger = 10;
        this.thirst = 10;
        this.boredom = 10;
    }

    // class methods
    public void tick() {
        hunger += 10; // this is equivalent to hunger = hunger + 10;
        thirst += 10;
        boredom += 10;
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
    // class pet behaviors
    public void eat() {
        hunger -= 10;
    }
    public void play() {
        boredom -= 10;
    }
    public void drink() {
        thirst -= 10;
        if(thirst<0){
            thirst = 0;
        }

    }
}
