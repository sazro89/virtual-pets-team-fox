package virtual_pet;

public class RoboticCat extends RoboticPet {

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public RoboticCat(String petName) {
        super(petName);
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    @Override
    public String getType() {
        return "Robotic Cat";
    }

    @Override
    public boolean getWasWalked() {
        return false;
    }
}
