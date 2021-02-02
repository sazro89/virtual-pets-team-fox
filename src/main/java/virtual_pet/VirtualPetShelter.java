package virtual_pet;

import java.util.Collection;
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

    public VirtualPet getPetInfo(String lookUp) {

        return manyPetMap.get(lookUp);
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
}
