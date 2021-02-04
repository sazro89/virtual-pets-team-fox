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

    public void takeInPet(VirtualPet takesInPet) {
        petMap.put(takesInPet.getName(), takesInPet);
    }

    public VirtualPet getPetInfo(String name) {
        return petMap.get(name);
    }

    public void feedPet(String name) {
        if (petMap.get(name) instanceof OrganicPet) {
            ((OrganicPet)petMap.get(name)).eat();
        }
    }

    public void waterPet(String name) {
        if (petMap.get(name) instanceof OrganicPet) {
            ((OrganicPet)petMap.get(name)).drink();
        }
    }

    public void playWithPet(String name) {
        petMap.get(name).play();
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

    public String printPetInfo() {
        String output = "| Name       | Type | Boredom | Hunger | Thirst | Oil |\n| ---------- | ---- | ------- | ------ | ------ | --- |\n";
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            VirtualPet pet = getPetInfo(name);
            if (pet instanceof OrganicPet) {
                output += String.format("| %-10s | %-4s | %-7d | %-6d | %-6d | %-3s |\n",
                        pet.getName(), "Org" ,pet.getBoredom(), ((OrganicPet) pet).getHunger(), ((OrganicPet) pet).getThirst(), "N/A");
            } else if (pet instanceof RoboticPet) {
                output += String.format("| %-10s | %-4s | %-7d | %-6s | %-6s | %-3d |\n",
                        pet.getName(), "Robo" ,pet.getBoredom(), "N/A", "N/A", ((RoboticPet) pet).getOilMaintenanceLevel());
            }
        }
        return output;
    }

    public String printPetNames() {
        String out = "";
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            out += name + "\n";
        }

        return out;
    }

    public void tickAllPets() {
        Collection<VirtualPet> pets = petMap.values();
        for (VirtualPet pet : pets) {
            pet.tick();
        }
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public Map<String, VirtualPet> getPetMap() {
        return petMap;
    }

}