package virtual_pet;

public abstract class VirtualPet {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    protected String name;
    protected int boredom;

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public VirtualPet(String petName) {
        this.name = petName;
        this.boredom = 10;
    }

    //----------------------------------------
    // ABSTRACT METHODS
    //----------------------------------------

    public abstract void tick();

    public abstract void eat();

    public abstract void drink();

    public abstract int getHunger();

    public abstract int getThirst();

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    public void play() {
        boredom -= 10;
        if (boredom < 0) {
            boredom = 0;
        }
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


}


