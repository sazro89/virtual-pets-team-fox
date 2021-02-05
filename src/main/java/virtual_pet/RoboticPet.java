package virtual_pet;

public abstract class RoboticPet extends VirtualPet {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    protected int oilMaintenanceLevel;
    protected boolean wasWalked;

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public RoboticPet(String petName) {
        super(petName);
        this.oilMaintenanceLevel = 10;
        wasWalked = false;
    }

    //----------------------------------------
    // ABSTRACT METHODS
    //----------------------------------------

    public abstract String getType();

    public abstract boolean getWasWalked();

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    public void maintenance() {
        oilMaintenanceLevel = 0;
    }

    public void tick() {
        oilMaintenanceLevel += 7; // this is equivalent to hunger = hunger + 10;
        this.boredom += 2;

        if (wasWalked) {
            cleanliness += 4;
            wasWalked = false;
        } else {
            cleanliness += 8;
        }
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public int getOilMaintenanceLevel() {
        return oilMaintenanceLevel;
    }
}