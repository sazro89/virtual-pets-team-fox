package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrganicCatTest {
    @Test
    public void canCreateOrganicCat() {
        VirtualPet pet = new OrganicCat("Mittens");
    }

    @Test
    public void organicCatsShouldHaveName() {
        VirtualPet pet = new OrganicCat("Joseph");
        String actual = pet.getName();

        assertThat(actual).isEqualTo("Joseph");
    }

    @Test
    public void shouldHaveDefaultHunger() {
        OrganicPet pet = new OrganicCat("Shaun");
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultThirst() {
        OrganicPet pet = new OrganicCat("Oinone");
        int actualThirst = pet.getThirst();

        assertThat(actualThirst).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultBoredom() {
        VirtualPet pet = new OrganicCat("Villum");
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultCleanliness() {
        VirtualPet pet = new OrganicCat("Ariel");
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(10);
    }

    @Test
    public void shouldTick() {
        OrganicPet pet = new OrganicCat("Daniel");
        pet.tick();
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(20);
    }

    @Test
    public void shouldEat() {
        OrganicPet pet = new OrganicCat("Derryl");
        pet.eat();
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void shouldDrink() {
        OrganicPet pet = new OrganicCat("Horos");
        pet.drink();
        int actualThirst = pet.getThirst();

        assertThat(actualThirst).isEqualTo(0);
    }

    @Test
    public void shouldPlay() {
        VirtualPet pet = new OrganicCat("Cato");
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void shouldClean() {
        VirtualPet pet = new OrganicCat("Cecilia");
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void keepHungerFromNegative() {
        OrganicPet pet = new OrganicCat("Sjors");
        pet.eat();
        pet.eat();
        pet.eat();
        int actualHunger = pet.getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void keepThirstFromNegative() {
        OrganicPet pet = new OrganicCat("Eemil");
        pet.drink();
        pet.drink();
        pet.drink();
        int actualThirst = pet.getThirst();

        assertThat(actualThirst).isEqualTo(0);
    }

    @Test
    public void keepBoredomFromNegative() {
        VirtualPet pet = new OrganicCat("Sadb");
        pet.play();
        pet.play();
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void keepCleanlinessFromNegative() {
        VirtualPet pet = new OrganicCat("Abimbola");
        pet.clean();
        pet.clean();
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void returnsType() {
        VirtualPet pet = new OrganicCat("Geena");
        String actualType = pet.getType();

        assertThat(actualType).isEqualTo("Organic Cat");
    }
}