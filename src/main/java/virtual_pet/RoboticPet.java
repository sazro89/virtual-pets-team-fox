package virtual_pet;

public class RoboticPet extends VirtualPet {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    protected int oilMaintenanceLevel;

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public RoboticPet(String petName) {
        super(petName);
        this.oilMaintenanceLevel = 10;
    }

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    public void maintenance() {
        oilMaintenanceLevel = 0;
    }

    public void tick() {
        oilMaintenanceLevel += 7; // this is equivalent to hunger = hunger + 10;
        this.boredom += 2;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public int getOilMaintenanceLevel() {
        return oilMaintenanceLevel;
    }
}