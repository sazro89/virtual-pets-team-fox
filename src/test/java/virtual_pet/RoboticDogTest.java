package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoboticDogTest {
    @Test
    public void canCreateRoboticDog() {
        VirtualPet pet = new RoboticDog("Nail");
    }

    @Test
    public void roboticDogsShouldHaveName() {
        VirtualPet pet = new RoboticDog("Melissa");
        String actual = pet.getName();

        assertThat(actual).isEqualTo("Melissa");
    }

    @Test
    public void shouldHaveDefaultOilMaintenance() {
        VirtualPet pet = new RoboticDog("Agostino");
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultBoredom() {
        VirtualPet pet = new RoboticDog("Villum");
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(10);
    }

    @Test
    public void shouldHaveDefaultCleanliness() {
        VirtualPet pet = new RoboticDog("Ariel");
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(10);
    }

    @Test
    public void shouldTick() {
        VirtualPet pet = new RoboticDog("Daniel");
        pet.tick();
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(17);
    }

    @Test
    public void shouldMaintenance() {
        VirtualPet pet = new RoboticDog("Derryl");
        ((RoboticPet) pet).maintenance();
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(0);
    }

    @Test
    public void shouldPlay() {
        VirtualPet pet = new RoboticDog("Dogo");
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void shouldClean() {
        VirtualPet pet = new RoboticDog("Cecilia");
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void shouldWalk() {
        VirtualPet pet = new RoboticDog("Wenceslaus");
        ((RoboticDog) pet).walk();
        int actualBoredom = pet.getBoredom();
        boolean actualWasWalked = pet.getWasWalked();

        assertThat(actualBoredom).isEqualTo(0);
        assertThat(actualWasWalked).isEqualTo(true);
    }

    @Test
    public void keepOilMaintenanceLevelFromNegative() {
        VirtualPet pet = new RoboticDog("Sjors");
        ((RoboticPet) pet).maintenance();
        ((RoboticPet) pet).maintenance();
        ((RoboticPet) pet).maintenance();
        int actualOilMaintenanceLevel = ((RoboticPet) pet).getOilMaintenanceLevel();

        assertThat(actualOilMaintenanceLevel).isEqualTo(0);
    }

    @Test
    public void keepBoredomFromNegative() {
        VirtualPet pet = new RoboticDog("Sadb");
        pet.play();
        pet.play();
        pet.play();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void keepBoredomFromNegativeByWalking() {
        VirtualPet pet = new RoboticDog("Vivek");
        ((RoboticDog) pet).walk();
        int actualBoredom = pet.getBoredom();

        assertThat(actualBoredom).isEqualTo(0);
    }

    @Test
    public void keepCleanlinessFromNegative() {
        VirtualPet pet = new RoboticDog("Abimbola");
        pet.clean();
        pet.clean();
        pet.clean();
        int actualCleanliness = pet.getCleanliness();

        assertThat(actualCleanliness).isEqualTo(0);
    }

    @Test
    public void returnsType() {
        VirtualPet pet = new RoboticDog("Geena");
        String actualType = pet.getType();

        assertThat(actualType).isEqualTo("Robotic Dog");
    }
}
