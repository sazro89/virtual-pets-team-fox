package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {
    @Test
    public void shouldMakeVirtualPetShelter() {
        VirtualPetShelter shelter = new VirtualPetShelter("");
    }
    @Test
    public void shouldBeAbleToNameShelter() {
        VirtualPetShelter shelterName = new VirtualPetShelter("house");
        String expected = shelterName.getName();
        assertEquals(expected, "house");
    }
    @Test
    public void shouldBeAbleToIntakePet() {
        VirtualPetShelter newShelter = new VirtualPetShelter("");
        VirtualPet pet = new VirtualPet("Steve");
        newShelter.takeInPet(pet);
        assertEquals(newShelter.getPetInfo("Steve"), pet);

    }
    @Test
        public void shouldBeAbleToTakeDifferentPets() {
        VirtualPetShelter newShelter = new VirtualPetShelter("");
        VirtualPet paulPet = new VirtualPet("Paul");
        VirtualPet ryanPet  = new VirtualPet("Ryan");
        newShelter.takeInPet(paulPet);
        newShelter.takeInPet(ryanPet);
        assertEquals(newShelter.getPetInfo("Paul"), paulPet);
    }
}









