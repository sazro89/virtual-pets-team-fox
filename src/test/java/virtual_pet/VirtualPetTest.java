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
        VirtualPet pet = new VirtualPet("");
        int feedPet = pet.getHunger(); // makes pet object and gets hunger (hunger = 10)
        pet.eat();
        int fedPet = pet.getHunger();
        assertEquals(feedPet - 10, fedPet);
    }

    @Test
    public void shouldPlay(){
        VirtualPet pet= new VirtualPet("");
        int playPet = pet.getBoredom();
        pet.play();
        int tiredPet = pet.getBoredom();
        assertEquals(playPet-10, tiredPet);
    }

    @Test
    public void shouldDrink(){
        VirtualPet pet= new VirtualPet("");
        int petThirst = pet.getThirst();
        pet.drink();
        int wateredPet = pet.getThirst();
        assertEquals(petThirst-10, wateredPet);
    }
    @Test
    public void keepsThirstFromNegative() {
        VirtualPet pet = new VirtualPet("");
        for(int x = 0; x <5; x++) {
            pet.drink();
        }
        assertEquals(0, pet.getThirst());
    }


}
