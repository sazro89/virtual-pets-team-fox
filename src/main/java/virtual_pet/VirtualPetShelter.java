package virtual_pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualPetShelter {

    //----------------------------------------
    // INSTANCE VARIABLES
    //----------------------------------------

    private String name;
    private Map<String, VirtualPet> petMap;

    //----------------------------------------
    // CONSTRUCTOR
    //----------------------------------------

    public VirtualPetShelter() {
        petMap = new HashMap<String, VirtualPet>();
    }

    //----------------------------------------
    // CLASS METHODS
    //----------------------------------------

    public void takeInPet(VirtualPet pet) {
        petMap.put(pet.getName(), pet);
    }

    public void feedPet(String name) {
        if (petMap.get(name) instanceof OrganicPet) {
            ((OrganicPet) petMap.get(name)).eat();
        }
    }

    public void waterPet(String name) {
        if (petMap.get(name) instanceof OrganicPet) {
            ((OrganicPet) petMap.get(name)).drink();
        }
    }

    public void playWithPet(String name) {
        petMap.get(name).play();
    }

    public void cleanPet(String name) {
        petMap.get(name).clean();
    }

    public void maintainPet(String name) {
        if (petMap.get(name) instanceof RoboticPet) {
            ((RoboticPet) petMap.get(name)).maintenance();
        }
    }

    public void walkPet(String name) {
        if (petMap.get(name) instanceof Walkable) {
            ((Walkable) petMap.get(name)).walk();
        }
    }

    public void feedAllPets() {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            this.feedPet(name);
        }
    }

    public void waterAllPets() {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            this.waterPet(name);
        }
    }

    public void playWithAllPets() {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            this.playWithPet(name);
        }
    }

    public void cleanAllPets() {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            this.cleanPet(name);
        }
    }

    public void maintainAllPets() {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            this.maintainPet(name);
        }
    }

    public void walkAllPets() {
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            this.walkPet(name);
        }
    }

    public void tickAllPets() {
        Collection<VirtualPet> pets = petMap.values();
        for (VirtualPet pet : pets) {
            pet.tick();
        }
    }

    //----------------------------------------
    // OUTPUT METHODS
    //----------------------------------------

    private String printHeader() {
        String output = "| Name       | Type        | Boredom | Cleanliness | Hunger | Thirst | Oil |\n" +
                "| ---------- | ----------- | ------- | ----------- | ------ | ------ | --- |\n";
        return output;
    }

    private String printPetInfo(String name) {
        String output = "";
        VirtualPet pet = getPetInfo(name);
        if (pet instanceof OrganicPet) {
            output += String.format("| %-10s | %-11s | %-7d | %-11d | %-6d | %-6d | %-3s |\n",
                    pet.getName(), pet.getType(), pet.getBoredom(), pet.getCleanliness(), ((OrganicPet) pet).getHunger(), ((OrganicPet) pet).getThirst(), "N/A");
        } else if (pet instanceof RoboticPet) {
            output += String.format("| %-10s | %-11s | %-7d | %-11d | %-6s | %-6s | %-3d |\n",
                    pet.getName(), pet.getType(), pet.getBoredom(), pet.getCleanliness(), "N/A", "N/A", ((RoboticPet) pet).getOilMaintenanceLevel());
        }
        return output;
    }

    public String printOnePetsInfo(String name) {
        String output = printHeader();
        output += printPetInfo(name);
        return output;
    }

    public String printAllPetsInfo() {
        Set<String> petNames = petMap.keySet();
        String output = printHeader();

        for (String name : petNames) {
            output += printPetInfo(name);
        }
        return output;
    }

    public String printPetNames() {
        String out = "";
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            out += "- " + name + "\n";
        }
        return out;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public Map<String, VirtualPet> getPetMap() {
        return petMap;
    }

    public VirtualPet getPetInfo(String name) {
        return petMap.get(name);
    }

    public String getPetType(String name) {
        return petMap.get(name).getType();
    }

    public String getPetMethods(String name) {
        String out = "- Play\n- Clean\n";
        String type = getPetType(name);
        if (type.contains("Organic")) {
            out += "- Feed\n- Water\n";
        }
        if (type.contains("Robotic")) {
            out += "- Maintenance\n";
        }
        if (type.contains("Dog")) {
            out += "- Walk\n";
        }
        return out;
    }

    //----------------------------------------
    // HELPER FUNCTIONS
    //----------------------------------------

    public void takeInPets(VirtualPet ...pets) {
        for (VirtualPet pet : pets) {
            petMap.put(pet.getName(), pet);
        }
    }
}