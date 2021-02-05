package virtual_pet;

public class OrganicCat extends OrganicPet {

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public OrganicCat(String petName) {
        super(petName);
    }

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    @Override
    public String getType() {
        return "Organic Cat";
    }

    @Override
    public boolean getWasWalked() {
        return false;
    }
}
