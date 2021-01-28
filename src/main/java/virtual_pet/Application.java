package virtual_pet;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String name;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to a fox generator!!");
        System.out.println("What would you like your fox's name to be?");
        name = inputScanner.nextLine();

        VirtualPet demoPet = new VirtualPet(name);
        System.out.println("Your fox's name is " + demoPet.getName() + ".");
        System.out.println("Your fox's current hunger value is " + demoPet.getHunger() + ".");
        demoPet.tick();
        System.out.println("Your fox's current hunger value is " + demoPet.getHunger() + ".");
        System.out.println("You should feed " + demoPet.getName() + ".");

    }
}

