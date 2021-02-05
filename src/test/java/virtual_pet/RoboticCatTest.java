package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoboticCatTest {
    @Test
    public void canCreateRoboticCat() {
        VirtualPet pet = new RoboticCat("Nail");
    }

    @Test
    public void roboticCatsShouldHaveName() {
        VirtualPet pet = new RoboticCat("Melissa");
        String actual = pet.getName();

        assertThat(actual).isEqualTo("Melissa");
    }

    @Test
    public void shouldHaveDefaultOilMaintenance() {
        VirtualPet pet = new RoboticCat("Agostino");
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultBoredom() {
        VirtualPet pet = new RoboticCat("Villum");
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultCleanliness() {
        VirtualPet pet = new RoboticCat("Ariel");
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(10);
    }

    @Test
    public void shouldTick() {
        VirtualPet pet = new RoboticCat("Daniel");
        pet.tick();
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(17);
    }

    @Test
    public void shouldMaintenance() {
        VirtualPet pet = new RoboticCat("Derryl");
        ((RoboticPet) pet).maintenance();
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(0);
    }

    @Test
    public void shouldPlay() {
        VirtualPet pet = new RoboticCat("Cato");
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void shouldClean() {
        VirtualPet pet = new RoboticCat("Cecilia");
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void keepOilMaintenanceLevelFromNegative() {
        VirtualPet pet = new RoboticCat("Sjors");
        ((RoboticPet) pet).maintenance();
        ((RoboticPet) pet).maintenance();
        ((RoboticPet) pet).maintenance();
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(0);
    }

    @Test
    public void keepBoredomFromNegative() {
        VirtualPet pet = new RoboticCat("Sadb");
        pet.play();
        pet.play();
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void keepCleanlinessFromNegative() {
        VirtualPet pet = new RoboticCat("Abimbola");
        pet.clean();
        pet.clean();
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void returnsType() {
        VirtualPet pet = new RoboticCat("Geena");
        String actualType = pet.getType();

        assertThat(actualType).isEqualTo("Robotic Cat");
    }
}
