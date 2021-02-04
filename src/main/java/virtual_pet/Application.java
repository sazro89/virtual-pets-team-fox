package virtual_pet;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
//        String name;

//        System.out.println("Welcome to a fox generator!!");
//        System.out.println("What would you like your fox's name to be?");
//        name = inputScanner.nextLine();
//
//        VirtualPet demoPet = new OrganicPet(name);
//        System.out.println("Your fox's name is " + demoPet.getName() + ".");
//        System.out.println("Your fox's current hunger value is " + ((OrganicPet) demoPet).getHunger() + ".");
//        demoPet.tick();
//        System.out.println("Your fox's current hunger value is " + ((OrganicPet) demoPet).getHunger() + ".");

        // THIS IS WHERE WE SET UP THINGS FOR THE GAME

        Scanner inputScanner = new Scanner(System.in);
        Boolean keepPlaying = true;
        String userInput = "";
        String playChoice = "";
        String petType = "";
        String animalType = "";
        VirtualPetShelter shelter = new VirtualPetShelter();

        while (keepPlaying) {
            // THIS IS THE GAME LOOP
            // INITIAL MENU
            System.out.println("What do you wanna do punk?");
            System.out.println("1) List all pets");
            System.out.println("2) Take in a new pet");
            System.out.println("3) Interact with the pets");
            System.out.println("0) Quit the game");
            userInput = inputScanner.nextLine();

            // PARSE USER INPUT FOR THE GAME LOOP

            System.out.println(userInput);
            if (userInput.equals("1")) {
                System.out.println(shelter.printPetInfo());
            } else if (userInput.equals("2")) {
                System.out.println("What is the pet's name?");
                userInput = inputScanner.nextLine();
                System.out.println("What kind of pet is it?\n- Robotic\n- Organic");
                petType = inputScanner.nextLine();
                System.out.println("What kind of animal is it?\n- Cat\n- Dog");
                animalType = inputScanner.nextLine();
                if (petType.equals("Robotic")) {
                    if (animalType.equals("Cat")) {
                        VirtualPet newPet = new RoboticCat(userInput);
                        shelter.takeInPet(newPet);
                    }
                    if (animalType.equals("Dog")) {
                        VirtualPet newPet = new RoboticDog(userInput);
                        shelter.takeInPet(newPet);
                    }
                } else if (petType.equals("Organic")) {
                    if (animalType.equals("Cat")) {
                        VirtualPet newPet = new OrganicCat(userInput);
                        shelter.takeInPet(newPet);
                    }
                    if (animalType.equals("Dog")) {
                        VirtualPet newPet = new OrganicDog(userInput);
                        shelter.takeInPet(newPet);
                    }
                }
            } else if (userInput.equals("3")) {
                System.out.println("Type the name of the pet you want to interact with");
                System.out.println(shelter.printPetNames() + "All\n");
                userInput = inputScanner.nextLine();
                if (userInput.equals("All")) {
                    System.out.println("What do you want to do with all of the pets?");
                    System.out.println("- Feed");
                    System.out.println("- Water");
                    System.out.println("- Play");

                    playChoice = inputScanner.nextLine();
                    if (playChoice.equals("Feed")) {
                        shelter.feedAllPets();
                    } else if (playChoice.equals("Water")){
                        shelter.waterAllPets();
                    } else if (playChoice.equals("Play")) {
                        shelter.playWithAllPets();
                    }
                } else {
                    System.out.println("What do you want to do with " + userInput);
                    System.out.println("- Feed");
                    System.out.println("- Water");
                    System.out.println("- Play");

                    playChoice = inputScanner.nextLine();
                    if (playChoice.equals("Feed")) {
                        shelter.feedPet(userInput);
                    } else if (playChoice.equals("Water")){
                        shelter.waterPet(userInput);
                    } else if (playChoice.equals("Play")) {
                        shelter.playWithPet(userInput);
                    }
                }
            } else if (userInput.equals("0")) {
                keepPlaying = false;
                System.out.println("Cya next time~");
            }

            // END OF LOOP METHODS
            shelter.tickAllPets();
        }
    }
}

