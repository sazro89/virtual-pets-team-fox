package virtual_pet;

public class RoboticPet extends VirtualPet {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    private int oilMaintenanceLevel;

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
        oilMaintenanceLevel += 10; // this is equivalent to hunger = hunger + 10;
        this.boredom += 10;
    }

    public void drink() {
        oilMaintenanceLevel -= 2;
        if (oilMaintenanceLevel < 0) {
            oilMaintenanceLevel = 0;
        }
    }

    public void eat() {
        oilMaintenanceLevel += 5;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public int getOilMaintenanceLevel() {
        return oilMaintenanceLevel;
    }

    public int getThirst() {
        return 0;
    }

    public int getHunger() {
        return 0;
    }
}
