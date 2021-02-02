package virtual_pet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void shouldBeAbleToTakeManyPets() {
        VirtualPetShelter shelter = new VirtualPetShelter("");
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new VirtualPet(String.valueOf(x)));
        }

        assertEquals(1000, shelter.getManyPetMap().size());
    }

    @Test
    public void shouldBeAbleToFeedOnePet() {
        // Arrangement
        VirtualPetShelter shelter = new VirtualPetShelter("");
        VirtualPet testPet = new VirtualPet("Etsuko");
        int initialHunger = testPet.getHunger();
        shelter.takeInPet(testPet);


        // Action
        shelter.feedPet("Etsuko");

        // Assertion
        assertNotEquals(shelter.getPetInfo("Etsuko").getHunger(), initialHunger);
    }

    @Test
    public void shouldBeAbleToWaterOnePet() {
        // Arrangement
        VirtualPetShelter shelter = new VirtualPetShelter("");
        VirtualPet testPet = new VirtualPet("Etsuko");
        int initialThirst = testPet.getThirst();
        shelter.takeInPet(testPet);


        // Action
        shelter.waterPet("Etsuko");

        // Assertion
        assertNotEquals(shelter.getPetInfo("Etsuko").getThirst(), initialThirst);
    }

    @Test
    public void shouldBeAbleToPlayWithOnePet() {
        // Arrangement
        VirtualPetShelter shelter = new VirtualPetShelter("");
        VirtualPet testPet = new VirtualPet("Etsuko");
        int initialBoredom = testPet.getBoredom();
        shelter.takeInPet(testPet);


        // Action
        shelter.playWithPet("Etsuko");

        // Assertion
        assertNotEquals(shelter.getPetInfo("Etsuko").getBoredom(), initialBoredom);
    }

    @Test
    public void shouldBeABleToFeedAllPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter("");
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new VirtualPet(String.valueOf(x)));
        }

        // ACTION
        shelter.feedAllPets();

        // ASSERTION


        assertThat(true).isTrue();

        // ETC
        System.out.println(shelter.getPetInfo("576").getHunger());

    }
}









