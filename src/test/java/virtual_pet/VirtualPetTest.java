package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void shouldBeAbleToCreatePet() {
        VirtualPet pet = new OrganicPet("Mittens");
    }

    @Test
    public void petShouldHaveName() {
        // ARRANGEMENT & ACTION
        VirtualPet underTest = new OrganicPet("Jeff");
        String expected = underTest.getName();

        // ASSERTION
        assertEquals(expected, "Jeff");
    }

    @Test
    public void shouldHaveDefaultHunger() {
        // ARRANGEMENT & ACTION
        VirtualPet pet = new OrganicPet("Steve");
        int expected = ((OrganicPet) pet).getHunger();

        // ASSERTION
        assertEquals(expected, 10);
    }

    @Test
    public void shouldHaveDefaultThirst() {
        // ARRANGEMENT & ACTION
        VirtualPet pet = new OrganicPet("Steve");
        int expected = ((OrganicPet) pet).getThirst();

        // ASSERTION
        assertEquals(expected, 10);
    }

    @Test
    public void shouldHaveDefaultBoredom() {
        // ARRANGEMENT & ACTION
        VirtualPet underTest = new OrganicPet("Steve");
        int expected = underTest.getBoredom();

        // ASSERTION
        assertEquals(expected, 10);
    }

    @Test
    public void shouldTick() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("Kendrick");

        // ACTION
        int initialHunger = ((OrganicPet) pet).getHunger();
        pet.tick();
        int hungerAfterTick = ((OrganicPet) pet).getHunger();

        // ASSERTION
        assertEquals(initialHunger + 10, hungerAfterTick);
    }

    @Test
    public void shouldFeed() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("");

        // ACTION
        int feedPet = ((OrganicPet) pet).getHunger(); // makes pet object and gets hunger (hunger = 10)
        ((OrganicPet) pet).eat();
        int fedPet = ((OrganicPet) pet).getHunger();

        // ASSERTION
        assertEquals(feedPet - 10, fedPet);
    }

    @Test
    public void shouldPlay() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("");

        // ACTION
        int playPet = pet.getBoredom();
        pet.play();
        int tiredPet = pet.getBoredom();

        // ASSERTION
        assertEquals(playPet - 10, tiredPet);
    }

    @Test
    public void shouldDrink() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("");

        // ACTION
        int petThirst = ((OrganicPet) pet).getThirst();
        ((OrganicPet) pet).drink();
        int wateredPet = ((OrganicPet) pet).getThirst();

        // ASSERTION
        assertEquals(petThirst - 10, wateredPet);
    }

    @Test
    public void keepsThirstFromNegative() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("");

        // ACTION
        for (int x = 0; x < 5; x++) {
            ((OrganicPet) pet).drink();
        }

        // ASSERTION
        assertEquals(0, ((OrganicPet) pet).getThirst());
    }

    @Test
    public void keepsBoredomFromNegative() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("");

        // ACTION
        for (int x = 0; x < 5; x++) {
            pet.play();
        }

        // ASSERTION
        assertEquals(0, pet.getBoredom());
    }

    @Test
    public void keepsHungerFromNegative() {
        // ARRANGEMENT
        VirtualPet pet = new OrganicPet("");

        // ACTION
        for (int x = 0; x < 5; x++) {
            ((OrganicPet) pet).eat();
        }

        // ASSERTION
        assertEquals(0, ((OrganicPet) pet).getHunger());
    }
}