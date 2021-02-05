package virtual_pet;

public abstract class OrganicPet extends VirtualPet {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    protected int hunger;
    protected int thirst;
    protected boolean wasWalked;

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public OrganicPet(String petName) {
        super(petName);
        this.hunger = 10;
        this.thirst = 10;
        this.wasWalked = false;
    }

    //----------------------------------------
    // ABSTRACT METHODS
    //----------------------------------------

    public abstract String getType();

    public abstract boolean getWasWalked();

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    public void tick() {
        hunger += 10; // this is equivalent to hunger = hunger + 10;
        thirst += 10;
        boredom += 10;

        if (wasWalked) {
            cleanliness += 5;
            wasWalked = false;
        } else {
            cleanliness += 10;
        }
    }

    public void eat() {
        hunger -= 10;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void drink() {
        thirst -= 10;
        if (thirst < 0) {
            thirst = 0;
        }
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }
}