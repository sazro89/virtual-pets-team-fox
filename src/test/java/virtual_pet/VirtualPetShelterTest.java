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
    public void shouldBeAbleToTakeInPet() {
        // ARRANGEMENT
        VirtualPetShelter newShelter = new VirtualPetShelter();
        VirtualPet pet = new OrganicDog("Steve");

        // ACTION
        newShelter.takeInPet(pet);

        // ASSERTION
        assertEquals(newShelter.getPetInfo("Steve"), pet);
    }

    @Test
    public void shouldBeAbleToTakeDifferentPets() {
        // ARRANGEMENT
        VirtualPetShelter newShelter = new VirtualPetShelter();
        VirtualPet paulPet = new OrganicDog("Paul");
        VirtualPet ryanPet = new OrganicCat("Ryan");

        // ACTION
        newShelter.takeInPets(paulPet, ryanPet);

        // ASSERTION
        assertEquals(newShelter.getPetInfo("Paul"), paulPet);
    }

    @Test
    public void shouldBeAbleToTakeManyPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();

        // ACTION
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicDog(String.valueOf(x)));
        }

        // ASSERTION
        assertEquals(1000, shelter.getPetMap().size());
    }

    @Test
    public void shouldBeAbleToFeedOnePet() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        OrganicPet testPet = new OrganicCat("Etsuko");
        int initialHunger = testPet.getHunger();
        shelter.takeInPet(testPet);
        // ACTION
        shelter.feedPet("Etsuko");

        // ASSERTION
        assertNotEquals(((OrganicPet) shelter.getPetInfo("Etsuko")).getHunger(), initialHunger);
    }

    @Test
    public void shouldBeAbleToWaterOnePet() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        OrganicPet testPet = new OrganicDog("Etsuko");
        int initialThirst = testPet.getThirst(); //little thirsty
        shelter.takeInPet(testPet);

        // ACTION
        shelter.waterPet("Etsuko");

        // ASSERTION
        assertNotEquals(((OrganicPet) shelter.getPetInfo("Etsuko")).getThirst(), initialThirst);
    }

    @Test
    public void shouldBeAbleToPlayWithOnePet() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicCat("Etsuko");
        int initialBoredom = testPet.getBoredom();
        shelter.takeInPet(testPet);

        // ACTION
        shelter.playWithPet("Etsuko");

        // ASSERTION
        assertNotEquals(shelter.getPetInfo("Etsuko").getBoredom(), initialBoredom);
    }

    @Test
    public void shouldBeAbleToCleanOnePet() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet testPet = new OrganicDog("Etsuko");
        int initialCleanliness = testPet.getCleanliness();
        shelter.takeInPet(testPet);

        shelter.cleanPet("Etsuko");
        int currentCleanliness = shelter.getPetInfo("Etsuko").getCleanliness();

        assertThat(currentCleanliness).isLessThan(initialCleanliness);
    }

    @Test
    public void shouldBeAbleToMaintainOneRoboticPet() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        RoboticPet testPet = new RoboticDog("Etsuko");
        int initialOilMaintenanceLevel = testPet.getOilMaintenanceLevel();
        shelter.takeInPet(testPet);

        shelter.maintainPet("Etsuko");
        int currentOilMaintenanceLevel = ((RoboticPet) shelter.getPetInfo("Etsuko")).getOilMaintenanceLevel();

        assertThat(currentOilMaintenanceLevel).isLessThan(initialOilMaintenanceLevel);
    }

    @Test
    public void shouldBeAbleToWalkOneDog() {
        VirtualPetShelter shelter = new VirtualPetShelter();
        VirtualPet testPet = new RoboticDog("Etsuko");
        int initialBoredom = testPet.getBoredom();
        shelter.takeInPet(testPet);

        shelter.walkPet("Etsuko");
        int currentBoredom = shelter.getPetInfo("Etsuko").getBoredom();

        assertThat(currentBoredom).isLessThan(initialBoredom);
    }

    @Test
    public void shouldBeAbleToFeedAllOrganicPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicDog(String.valueOf(x)));
        }

        // ACTION
        shelter.feedAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> ((OrganicPet) pet).getHunger() == 0);
        //list ^ of pets  // ^ for each value call it pet  // ^ making sure each pets hunger == 0
    }

    @Test
    public void shouldBeAbleToWaterManyOrganicPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicDog(String.valueOf(x)));
        }

        // ACTION
        shelter.waterAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> ((OrganicPet) pet).getThirst() == 0);
    }

    @Test
    public void shouldBeAbleToPlayWithManyPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicCat(String.valueOf(x)));
        }

        // ACTION
        shelter.playWithAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> pet.getBoredom() == 0);
    }

    @Test
    public void shouldBeAbleToCleanManyPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new OrganicCat(String.valueOf(x)));
        }

        // ACTION
        shelter.cleanAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> pet.getCleanliness() == 0);
    }

    @Test
    public void shouldBeAbleToMaintainManyRoboticPets() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new RoboticCat(String.valueOf(x)));
        }

        // ACTION
        shelter.maintainAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> ((RoboticPet) pet).getOilMaintenanceLevel() == 0);
    }

    @Test
    public void shouldBeAbleToWalkManyDogs() {
        // ARRANGEMENT
        VirtualPetShelter shelter = new VirtualPetShelter();
        for (int x = 0; x < 1000; x++) {
            shelter.takeInPet(new RoboticDog(String.valueOf(x)));
        }

        // ACTION
        shelter.walkAllPets();

        // ASSERTION
        assertThat(shelter.getPetMap().values()).allMatch(pet -> pet.getBoredom() == 0);
    }

    @Test
    public void shelterShouldPrintOnePetsInfo() {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet pet = new RoboticCat("Nami");
        petShelter.takeInPet(pet);

        String expectedOutput = "| Name       | Type        | Boredom | Cleanliness | Hunger | Thirst | Oil |\n" +
                "| ---------- | ----------- | ------- | ----------- | ------ | ------ | --- |\n" +
                "| Nami       | Robotic Cat | 10      | 10          | N/A    | N/A    | 10  |\n";
        String actualOutput = petShelter.printOnePetsInfo("Nami");

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void shelterShouldPrintAllPetsInfo() {
        // ARRANGEMENT
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet petOne = new OrganicCat("Tim");
        VirtualPet petTwo = new RoboticDog("Ryan");
        VirtualPet petThree = new OrganicDog("Sam");
        petShelter.takeInPets(petOne, petTwo, petThree);

        // ACTION
        String actualOutput = petShelter.printAllPetsInfo();
        String sampleOutput = "| Name       | Type        | Boredom | Cleanliness | Hunger | Thirst | Oil |\n" +
                "| ---------- | ----------- | ------- | ----------- | ------ | ------ | --- |\n" +
                "| Ryan       | Robotic Dog | 10      | 10          | N/A    | N/A    | 10  |\n" +
                "| Tim        | Organic Cat | 10      | 10          | 10     | 10     | N/A |\n" +
                "| Sam        | Organic Dog | 10      | 10          | 10     | 10     | N/A |\n";

        // ASSERTION
        assertThat(actualOutput).isEqualTo(sampleOutput);
    }

    @Test
    public void shouldPrintRelevantPetMethodsRoboticDog() {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet pet = new RoboticDog("Winston");
        petShelter.takeInPet(pet);

        String expectedOutput = "- Play\n- Clean\n- Maintenance\n- Walk\n";
        String actualOutput = petShelter.getPetMethods("Winston");

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldPrintRelevantPetMethodsRoboticCat() {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet pet = new RoboticCat("Krystal");
        petShelter.takeInPet(pet);

        String expectedOutput = "- Play\n- Clean\n- Maintenance\n";
        String actualOutput = petShelter.getPetMethods("Krystal");

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldPrintRelevantPetMethodsOrganicDog() {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet pet = new OrganicDog("Winston");
        petShelter.takeInPet(pet);

        String expectedOutput = "- Play\n- Clean\n- Feed\n- Water\n- Walk\n";
        String actualOutput = petShelter.getPetMethods("Winston");

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldPrintRelevantPetMethodsOrganicCat() {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet pet = new OrganicCat("Nami");
        petShelter.takeInPet(pet);

        String expectedOutput = "- Play\n- Clean\n- Feed\n- Water\n";
        String actualOutput = petShelter.getPetMethods("Nami");

        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @Test
    public void shelterShouldGetPetType() {
        VirtualPetShelter petShelter = new VirtualPetShelter();
        VirtualPet pet = new RoboticCat("Nami");
        petShelter.takeInPet(pet);

        String actualType = petShelter.getPetType("Nami");

        assertThat(actualType).isEqualTo("Robotic Cat");
    }
}