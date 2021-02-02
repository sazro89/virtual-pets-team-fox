package virtual_pet;

import java.util.HashMap;
import java.util.Map;

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
}
