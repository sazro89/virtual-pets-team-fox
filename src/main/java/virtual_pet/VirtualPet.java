package virtual_pet;

public abstract class VirtualPet {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    protected String name;
    protected int boredom;
    protected int cleanliness;

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public VirtualPet(String petName) {
        this.name = petName;
        this.boredom = 10;
        this.cleanliness = 10;
    }

    //----------------------------------------
    // ABSTRACT METHODS
    //----------------------------------------

    public abstract void tick();

    public abstract String getType();

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    public void play() {
        boredom -= 10;
        if (boredom < 0) {
            boredom = 0;
        }
    }

    public void clean() {
        cleanliness = 0;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public String getName() {
        return name;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public abstract boolean getWasWalked();
}