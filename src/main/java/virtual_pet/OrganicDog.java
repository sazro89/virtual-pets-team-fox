package virtual_pet;

public class OrganicDog extends OrganicPet implements Walkable {

    public OrganicDog(String petName) {
        super(petName);
    }

    @Override
    public void walk() {
        boredom -= 50;
        if (boredom < 0) {
            boredom = 0;
        }
        wasWalked = true;
    }
}
