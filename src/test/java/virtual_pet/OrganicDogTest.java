package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrganicDogTest {
    @Test
    public void canCreateOrganicDog() {
        VirtualPet pet = new OrganicDog("Oktawia");
    }

    @Test
    public void organicDogsShouldHaveName() {
        VirtualPet pet = new OrganicDog("Abril");
        String actual = pet.getName();

        assertThat(actual).isEqualTo("Abril");
    }

    @Test
    public void shouldHaveDefaultHunger() {
        VirtualPet pet = new OrganicDog("Slavica");
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultThirst() {
        VirtualPet pet = new OrganicDog("Rowland");
        int actualThirst = ((OrganicPet) pet).getThirst();

        assertThat(actualThirst).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultBoredom() {
        VirtualPet pet = new OrganicDog("Ode");
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultCleanliness() {
        VirtualPet pet = new OrganicDog("Soraya");
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(10);
    }

    @Test
    public void shouldTick() {
        VirtualPet pet = new OrganicDog("Inge");
        pet.tick();
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(20);
    }

    @Test
    public void shouldEat() {
        VirtualPet pet = new OrganicDog("Sasho");
        ((OrganicPet) pet).eat();
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void shouldDrink() {
        VirtualPet pet = new OrganicDog("Tierney");
        ((OrganicPet) pet).drink();
        int actualThirst = ((OrganicPet) pet).getThirst();

        assertThat(actualThirst).isEqualTo(0);
    }

    @Test
    public void shouldPlay() {
        VirtualPet pet = new OrganicDog("Zvi");
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void shouldClean() {
        VirtualPet pet = new OrganicDog("Tzuriel");
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void shouldWalk() {
        VirtualPet pet = new OrganicDog("Wenceslaus");
        ((OrganicDog) pet).walk();
        int actualBoredom = pet.getBoredom();
        boolean actualWasWalked = pet.getWasWalked();

        assertThat(actualBoredom).isEqualTo(0);
        assertThat(actualWasWalked).isEqualTo(true);
    }

    @Test
    public void keepHungerFromNegative() {
        VirtualPet pet = new OrganicDog("Valter");
        ((OrganicPet) pet).eat();
        ((OrganicPet) pet).eat();
        ((OrganicPet) pet).eat();
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void keepThirstFromNegative() {
        VirtualPet pet = new OrganicDog("Arnfried");
        ((OrganicPet) pet).drink();
        ((OrganicPet) pet).drink();
        ((OrganicPet) pet).drink();
        int actualThirst = ((OrganicPet) pet).getThirst();

        assertThat(actualThirst).isEqualTo(0);
    }

    @Test
    public void keepBoredomFromNegative() {
        VirtualPet pet = new OrganicDog("Skanda");
        pet.play();
        pet.play();
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void keepBoredomFromNegativeByWalking() {
        VirtualPet pet = new OrganicDog("Vivek");
        ((OrganicDog) pet).walk();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void keepCleanlinessFromNegative() {
        VirtualPet pet = new OrganicDog("Aphrodisios");
        pet.clean();
        pet.clean();
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void returnsType() {
        VirtualPet pet = new OrganicDog("Erna");
        String actualType = pet.getType();

        assertThat(actualType).isEqualTo("Organic Dog");
    }
}
