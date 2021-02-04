package virtual_pet;

public class RoboticPets extends VirtualPet {
    public RoboticPets(String petName) {
        super(petName);
        this.oilMaintainanceLevel = 10;
    }
    private int oilMaintainanceLevel ;
    public void maintainance() {
        oilMaintainanceLevel = 0;
    }
    public void tick() {
        oilMaintainanceLevel += 10; // this is equivalent to hunger = hunger + 10;
        this.boredom += 10;
    }

    public int getOilMaintainanceLevel() {
        return oilMaintainanceLevel;
    }
}
