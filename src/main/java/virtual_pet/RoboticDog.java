package virtual_pet;

public class RoboticDog extends RoboticPet implements Walkable {

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public RoboticDog(String petName) {
        super(petName);
    }

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    @Override
    public void walk() {
        boredom -= 10;             // decreases the boredom of the pet
        oilMaintenanceLevel += 20; // this increases the need for maintenance
        wasWalked = true;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    @Override
    public String getType() {
        return "Robotic Dog";
    }

    @Override
    public boolean getWasWalked() {
        return wasWalked;
    }
}
