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
        VirtualPet pet = new OrganicCat("Shaun");
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultThirst() {
        VirtualPet pet = new OrganicCat("Oinone");
        int actualThirst = ((OrganicPet) pet).getThirst();

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
        VirtualPet pet = new OrganicCat("Daniel");
        pet.tick();
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(20);
    }

    @Test
    public void shouldEat() {
        VirtualPet pet = new OrganicCat("Derryl");
        ((OrganicPet) pet).eat();
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void shouldDrink() {
        VirtualPet pet = new OrganicCat("Horos");
        ((OrganicPet) pet).drink();
        int actualThirst = ((OrganicPet) pet).getThirst();

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
        VirtualPet pet = new OrganicCat("Sjors");
        ((OrganicPet) pet).eat();
        ((OrganicPet) pet).eat();
        ((OrganicPet) pet).eat();
        int actualHunger = ((OrganicPet) pet).getHunger();

        assertThat(actualHunger).isEqualTo(0);
    }

    @Test
    public void keepThirstFromNegative() {
        VirtualPet pet = new OrganicCat("Eemil");
        ((OrganicPet) pet).drink();
        ((OrganicPet) pet).drink();
        ((OrganicPet) pet).drink();
        int actualThirst = ((OrganicPet) pet).getThirst();

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