package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class VirtualPetShelterTest {
    @Test
    public void shouldMakeVirtualPetShelter() {
        VirtualPetShelter shelter = new VirtualPetShelter();
    }

    @Test
    public void shouldBeAbleToIntakePet() {
        // ARRANGEMENT
        VirtualPetShelter newShelter = new VirtualPetShelter();
        VirtualPet pet = new OrganicPet("Steve");

        // ACTION
        newShelter.takeInPet(pet);

        // ASSERTION
        assertEquals(newShelter.getPetInfo("Steve"), pet);
    }

    @Test
    public void shouldBeAbleToTakeDifferentPets() {
        // ARRANGEMENT
        VirtualPetShelter newShelter = new VirtualPetShelter();
        VirtualPet paulPet = new OrganicPet("Paul");
        VirtualPet ryanPet = new OrganicPet("Ryan");

        // ACTION
        newShelter.takeInPet(paulPet);
        newShelter.takeInPet(ryanPet);
        assertEquals(newShelter.getPetInfo("Paul"), paulPet);
    }

    @Test
    public void shouldBeAbleToTakeManyPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();

        // ACTION
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicPet(String.valueOf(x)));
        }
        assertEquals(1000, shelter.getPetMap().size());
    }

    @Test
    public void shouldBeAbleToFeedOnePet() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicPet("Etsuko");
        int initialHunger = testPet.getHunger();
        shelter.takeInPet(testPet);
        // ACTION
        shelter.feedPet("Etsuko");

        // ASSERTION
        assertNotEquals(shelter.getPetInfo("Etsuko").getHunger(), initialHunger);
    }

    @Test
    public void shouldBeAbleToWaterOnePet() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicPet("Etsuko");
        int initialThirst = testPet.getThirst(); //little thirsty
        shelter.takeInPet(testPet);

        // ACTION
        shelter.waterPet("Etsuko");

        // ASSERTION
        assertNotEquals(shelter.getPetInfo("Etsuko").getThirst(), initialThirst);
    }

    @Test
    public void shouldBeAbleToPlayWithOnePet() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicPet("Etsuko");
        int initialBoredom = testPet.getBoredom();
        shelter.takeInPet(testPet);

        // ACTION
        shelter.playWithPet("Etsuko");

        // ASSERTION
        assertNotEquals(shelter.getPetInfo("Etsuko").getBoredom(), initialBoredom);
    }

    @Test
    public void shouldBeABleToFeedAllPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicPet(String.valueOf(x)));
        }

        // ACTION
        shelter.feedAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> pet.getHunger() == 0);
        //list ^ of pets  // ^ for each value call it pet  // ^ making sure each pets hunger == 0
    }

    @Test
    public void playersShouldBeAbleToWaterManyPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicPet(String.valueOf(x)));
        }

        // ACTION
        shelter.waterAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> pet.getThirst() == 0);
    }

    @Test
    public void playerShouldBeAbleToPlayWithManyPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicPet(String.valueOf(x)));
        }

        // ACTION
        shelter.playWithAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> pet.getBoredom() == 0);
    }

    @Test
    public void shelterShouldPrintPetInfo() {
        // ARRANGEMENT
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet petOne = new OrganicPet("Tim");
        VirtualPet petTwo = new OrganicPet("Ryan");
        VirtualPet petThree = new OrganicPet("Sam");
        petShelter.takeInPet(petOne);
        petShelter.takeInPet(petTwo);
        petShelter.takeInPet(petThree);

        // ACTION
        String stringOutput = petShelter.printPetInfo();
        String testOut = "| Name       | Boredom | Hunger | Thirst |\n" +
                "| ---------- | ------- | ------ | ------ |\n" +
                "| Ryan       | 10      | 10     | 10     |\n" +
                "| Tim        | 10      | 10     | 10     |\n" +
                "| Sam        | 10      | 10     | 10     |\n";

        // ASSERTION
        assertEquals(testOut, stringOutput);
    }
}