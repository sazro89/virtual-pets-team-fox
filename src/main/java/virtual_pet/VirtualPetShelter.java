package virtual_pet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualPetShelter {
    private String name;
    private Map<String, VirtualPet> manyPetMap = new HashMap<String, VirtualPet>();

    public VirtualPetShelter(String shelterName) {
        this.name = shelterName;
    }

    public String getName() {
        return name;
    }

    public void takeInPet(VirtualPet takesInPet) {
        manyPetMap.put(takesInPet.getName(), takesInPet);
    }

    public VirtualPet getPetInfo(String name) {
        return manyPetMap.get(name);
    }

    public Map<String, VirtualPet> getManyPetMap() {
        return manyPetMap;
    }

    public void feedPet(String name) {
        manyPetMap.get(name).eat();
    }

    public void waterPet(String name) {
        manyPetMap.get(name).drink();
    }

    public void playWithPet(String name) {
        manyPetMap.get(name).play();
    }

    public void feedAllPets() {
        Set<String> petNames = manyPetMap.keySet();
        for (String name : petNames) {
            this.feedPet(name);
        }
    }

    public void waterAllPets() {
        Set<String> petNames = manyPetMap.keySet();
        for (String name : petNames) {
            this.waterPet(name);
        }
    }

    public void playWithAllPets() {
        Set<String> petNames = manyPetMap.keySet();
        for (String name : petNames) {
            this.playWithPet(name);
        }
    }

    public String dumpPetInfo() {
        String output = "| Name       | Boredom | Hunger | Thirst |\n| ---------- | ------- | ------ | ------ |\n";
        Set<String> petNames = manyPetMap.keySet();
        for (String name : petNames) {
            VirtualPet pet = getPetInfo(name);
            //output += pet.getName() + "\t" + pet.getBoredom() + "\t" + pet.getHunger() + "\t" + pet.getThirst() + "\n";

            output += String.format("| %-10s | %-7d | %-6d | %-6d |\n", pet.getName(), pet.getBoredom(), pet.getHunger(), pet.getThirst());
        }
        return output;
    }

//output += String.format("| %-10s | %-7d | %-6d | %-6d |\n", pet.getName(), pet.getBoredom(), pet.getHunger(), pet.getThirst());


    //      @Test
    //    public void stringFormatOutputVerification(){
    //        Cat testCat = new Cat("Bosco");
    //        String statusLine = String.format("| %s | %3d | %2s | %2s |", testCat.getName(), testCat.getHunger(), testCat.getWater(), testCat.play());
    //        assertThat(statusLine).isEqualTo("|      Bosco |  10 |");
    //    }
//
}
