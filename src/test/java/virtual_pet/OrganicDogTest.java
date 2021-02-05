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
        OrganicPet pet = new OrganicDog("Slavica");
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultThirst() {
        OrganicPet pet = new OrganicDog("Rowland");
        int actualThirst = pet.getThirst();

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
        OrganicPet pet = new OrganicDog("Inge");
        pet.tick();
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(20);
    }

    @Test
    public void shouldEat() {
        OrganicPet pet = new OrganicDog("Sasho");
        pet.eat();
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void shouldDrink() {
        OrganicPet pet = new OrganicDog("Tierney");
        pet.drink();
        int actualThirst = pet.getThirst();

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
        OrganicDog pet = new OrganicDog("Wenceslaus");
        pet.walk();
        int actualBoredom = pet.getBoredom();
        boolean actualWasWalked = pet.getWasWalked();

        assertThat(actualBoredom).isEqualTo(0);
        assertThat(actualWasWalked).isEqualTo(true);
    }

    @Test
    public void keepHungerFromNegative() {
        OrganicPet pet = new OrganicDog("Valter");
        pet.eat();
        pet.eat();
        pet.eat();
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void keepThirstFromNegative() {
        OrganicPet pet = new OrganicDog("Arnfried");
        pet.drink();
        pet.drink();
        pet.drink();
        int actualThirst = pet.getThirst();

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
        OrganicDog pet = new OrganicDog("Vivek");
        pet.walk();
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
