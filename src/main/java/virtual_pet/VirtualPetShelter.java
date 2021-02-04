package virtual_pet;

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
        petMap.get(name).eat();
    }

    public void waterPet(String name) {
        petMap.get(name).drink();
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
        String output = "| Name       | Boredom | Hunger | Thirst |\n| ---------- | ------- | ------ | ------ |\n";
        Set<String> petNames = petMap.keySet();
        for (String name : petNames) {
            VirtualPet pet = getPetInfo(name);
            output += String.format("| %-10s | %-7d | %-6d | %-6d |\n", pet.getName(), pet.getBoredom(), pet.getHunger(), pet.getThirst());
        }
        return output;
    }

    //----------------------------------------
    // GETTER METHODS
    //----------------------------------------

    public Map<String, VirtualPet> getPetMap() {
        return petMap;
    }
}