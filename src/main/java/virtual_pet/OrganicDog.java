package virtual_pet;

public class OrganicDog extends OrganicPet implements Walkable {

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public OrganicDog(String petName) {
        super(petName);
    }

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    @Override
    public void walk() {
        boredom -= 50;
        if (boredom < 0) {
            boredom = 0;
        }
        wasWalked = true;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    @Override
    public String getType() {
        return "Organic Dog";
    }

    @Override
    public boolean getWasWalked() {
        return wasWalked;
    }
}
