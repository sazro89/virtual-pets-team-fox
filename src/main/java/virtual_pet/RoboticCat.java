package virtual_pet;

public class RoboticCat extends RoboticPet {

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public RoboticCat(String petName) {
        super(petName);
    }

    //----------------------------------------
    // CLASS METHODS
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
