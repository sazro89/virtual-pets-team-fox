package virtual_pet;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // THIS IS WHERE WE SET UP THINGS FOR THE GAME

        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";
        VirtualPetShelter shelter = new VirtualPetShelter();
        boolean keepPlaying = true;

        while (keepPlaying) {
            // THIS IS THE GAME LOOP
            // INITIAL MENU
            System.out.println("What would you like to do?");
            System.out.println("1) List all pets");
            System.out.println("2) Take in a new pet");
            System.out.println("3) Interact with the pets");
            System.out.println("0) Quit the game");
            userInput = inputScanner.nextLine();

            // PARSE USER INPUT FOR THE GAME LOOP

            System.out.println(userInput);
            switch (userInput) {
                //----------------------------------------
                // LIST ALL PETS
                //----------------------------------------
                case "1":
                    System.out.println(shelter.printAllPetsInfo());
                    break;
                //----------------------------------------
                // ADD NEW PET
                //----------------------------------------
                case "2": {
                    System.out.println("What is the pet's name?");
                    String name = inputScanner.nextLine();
                    System.out.println("What kind of pet is it?\n- Robotic Cat\n- Robotic Dog\n- Organic Cat\n- Organic Dog");
                    String petType = inputScanner.nextLine();

                    if (petType.equalsIgnoreCase("robotic cat")) {
                        shelter.takeInPet(new RoboticCat(name));
                    } else if (petType.equalsIgnoreCase("robotic dog")) {
                        shelter.takeInPet(new RoboticDog(name));
                    } else if (petType.equalsIgnoreCase("organic cat")) {
                        shelter.takeInPet(new OrganicCat(name));
                    } else if (petType.equalsIgnoreCase("organic dog")) {
                        shelter.takeInPet(new OrganicDog(name));
                    }
                    break;
                }
                //----------------------------------------
                // INTERACT WITH PETS
                //----------------------------------------
                case "3": {
                    String playChoice;
                    System.out.println("Type the name of the pet you want to interact with");
                    System.out.println(shelter.printPetNames() + "- All" + "\n");
                    System.out.println("Cancel");
                    String name = inputScanner.nextLine();

                    // If cancel is input, skip logic, otherwise...
                    if (name.equalsIgnoreCase("Cancel")) {
                    }
                    // Display options for interacting with all pets if all was chosen
                    else if (name.equalsIgnoreCase("All")) {
                        System.out.println("What do you want to do with all of the pets?");
                        System.out.println("- Play (all)");
                        System.out.println("- Clean (all)");
                        System.out.println("- Feed (organic only)");
                        System.out.println("- Water (organic only)");
                        System.out.println("- Maintenance (robotic only)");
                        System.out.println("- Walk (dogs only)");
                        System.out.println("- Cancel");

                        playChoice = inputScanner.nextLine();
                        if (playChoice.equalsIgnoreCase("Play")) {
                            shelter.playWithAllPets();
                        } else if (playChoice.equalsIgnoreCase("Clean")) {
                            shelter.cleanAllPets();
                        } else if (playChoice.equalsIgnoreCase("Feed")) {
                            shelter.feedAllPets();
                        } else if (playChoice.equalsIgnoreCase("Water")) {
                            shelter.waterAllPets();
                        } else if (playChoice.equalsIgnoreCase("Maintenance")) {
                            shelter.maintainAllPets();
                        } else if (playChoice.equalsIgnoreCase("Walk")) {
                            shelter.walkAllPets();
                        } else if (playChoice.equalsIgnoreCase("Cancel")) {
                        }
                    }
                    // Otherwise, we assume a specific pet was chosen and we look it up
                    // and present the relevant options for that specific pet
                    else {
                        System.out.println(shelter.printOnePetsInfo(name));
                        System.out.println("What do you want to do with " + name);
                        System.out.println(shelter.getPetMethods(name));
                        System.out.println("- Cancel");

                        playChoice = inputScanner.nextLine();
                        if (playChoice.equalsIgnoreCase("Play")) {
                            shelter.playWithPet(name);
                        } else if (playChoice.equalsIgnoreCase("Clean")) {
                            shelter.cleanPet(name);
                        } else if (playChoice.equalsIgnoreCase("Feed")) {
                            shelter.feedPet(name);
                        } else if (playChoice.equalsIgnoreCase("Water")) {
                            shelter.waterPet(name);
                        } else if (playChoice.equalsIgnoreCase("Maintenance")) {
                            shelter.maintainPet(name);
                        } else if (playChoice.equalsIgnoreCase("Walk")) {
                            shelter.walkPet(name);
                        } else if (playChoice.equalsIgnoreCase("Cancel")) {
                        }
                    }
                    break;
                }
                // Quit the game
                case "0":
                    keepPlaying = false;
                    System.out.println("Cya next time~");
                    break;
            }

            // END OF LOOP METHODS
            shelter.tickAllPets();
        }
    }
}

