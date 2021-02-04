package virtual_pet;

public abstract class VirtualPet {

    //instance  variables
    protected String name;
    protected int boredom;


    // class constructor
    public VirtualPet(String petName) {
        this.name = petName;
        this.boredom = 10;
    }

    // class methods
    public abstract void tick();

    public String getName() {
        return name;
    }

    public int getBoredom() {
        return boredom;
    }
    public void play() {
        boredom -= 10;
        if (boredom < 0) {
            boredom = 0;
        }
    }
}


