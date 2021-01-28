package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void shouldBeAbleToCreatePet() {
        VirtualPet pet = new VirtualPet("Mittens");
    }

    @Test
    public void petShouldHaveName() {
        VirtualPet underTest = new VirtualPet("Jeff");

        String expected = underTest.getName();

        assertEquals(expected, "Jeff");
    }

    @Test
    public void shouldHaveDefaultHunger() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getHunger();

        assertEquals(expected, 10);
    }

    @Test
    public void shouldHaveDefaultThirst() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getThirst();

        assertEquals(expected, 10);
    }

    @Test
    public void shouldHaveDefaultBoredom() {
        VirtualPet underTest = new VirtualPet("Steve");

        int expected = underTest.getBoredom();

        assertEquals(expected, 10);
    }

    @Test
    public void shouldTick() {
        VirtualPet pet = new VirtualPet("Kendrick");

        int initialHunger = pet.getHunger();
        pet.tick();
        int hungerAfterTick = pet.getHunger();

        assertEquals(initialHunger + 10, hungerAfterTick);


    }

    @Test
    public void shouldFeed() {
        VirtualPet pet = new VirtualPet("Paul");

        int initialHunger = pet.getHunger();
        pet.feed();
        int hungerAfterTick = pet.getHunger();

        assertEquals(initialHunger - 10, hungerAfterTick);
    }

    @Test
    public void shouldPlay() {
        VirtualPet pet = new VirtualPet("Finnegan");

        int initialBoredom = pet.getBoredom();
        pet.play();
        int boredomAfterPlaying = pet.getBoredom();

        assertEquals(initialBoredom - 10, boredomAfterPlaying);
    }

    @Test
    public void hungerShouldNotBecomeNegative() {
        VirtualPet pet = new VirtualPet("Suzie");
        for(int x = 0; x < 10; x++) {
            pet.feed();
        }

        assertEquals(0, pet.getHunger());
    }
}
