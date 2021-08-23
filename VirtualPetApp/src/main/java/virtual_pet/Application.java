package virtual_pet;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Application {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Application virtualPetShelter = new Application();
        virtualPetShelter.play();
    }

    public void play() {
        boolean continueGame = true;

        String userSelection;
        VirtualPetShelter PowndTown = new VirtualPetShelter("PowndTown");
        VirtualPet rogerWilco = new OrganicPet<>("Roger Wilco",5);
        VirtualPet georgia = new RoboticPet("Georgia",8,15);
        PowndTown.addPet(rogerWilco);
        PowndTown.addPet(georgia);
        System.out.println("Welcome to PowndTown");
        while (continueGame) {
            userSelection = getUserChoice(PowndTown);

           // if (userSelection.equalsIgnoreCase("n")) {
          //      addNewPet(PowndTown);
           // }
          //  if (userSelection.equalsIgnoreCase("a")) {
           //     adoptPet(PowndTown);
           // }
           switch (userSelection.toLowerCase()) {
                case "f":
                    PowndTown.feedAllOrganicPets();
                    break;
               case "w":
                   PowndTown.waterAllOrganicPets();
                   break;
               case "n":
                   addNewPet(PowndTown);
                   break;
               case "a":
                   adoptPet(PowndTown);
                   break;
               case "c":
                   PowndTown.chargeRoboPet();
                   break;
               case "e":
                   PowndTown.exerciseAllVirtualPets();
                   break;
               case "x":
                   PowndTown.cleanCages();
                   break;
            }
        }
    }

    public void addNewPet(VirtualPetShelter shelter) {
        int lifeSpan = ThreadLocalRandom.current().nextInt(10, 21);

        System.out.println("Is it Orgo or Robo?");
        String choice = input.nextLine();
        System.out.print("Enter pet name: ");
        String name = input.nextLine();
        System.out.println("Enter pet age (must be younger than 20): ");
        int age = input.nextInt();

        if (choice.equalsIgnoreCase("Robo")) {
            RoboticPet roboPet = new RoboticPet(name, age, lifeSpan) {
            };
            shelter.addPet(roboPet);
        } else if (choice.equalsIgnoreCase("Orgo")) {
            OrganicPet orgoPet = new OrganicPet(name, age) {
            };
            shelter.addPet(orgoPet);
        }
//        input.nextLine();

//        OrganicPet orgoPet = new OrganicPet(name, age, lifeSpan){};
//       shelter.addPet(orgoPet);
        // VirtualPet userPet = new VirtualPet(name, age, lifeSpan){};
        //shelter.addPet(userPet);
    }

    public void adoptPet(VirtualPetShelter shelter) {
        String petName;
        while (true) {
            System.out.println("Enter name of pet to adopt");
            petName = input.nextLine();
            if (shelter.petIsInShelter(petName)) {
                shelter.adoptPet(shelter.getPetByName(petName));
                break;
            } else {
                System.out.println("A pet of that name does not currently reside in our shelter");
                System.out.println("Would you like to keep looking?  Y or N");
                if (input.nextLine().equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }

    private String getUserChoice(VirtualPetShelter shelter) {

        System.out.flush();
        String Output = shelter.listOfPets();
        System.out.println(Output);
        System.out.println("Press N to add new pet");
        System.out.println("Press A to adopt pet");
        System.out.println("Press F to feed all organic pets");
        System.out.println("Press W to give water to all organic pets");
        System.out.println("Press C to charge all robo pets");
        System.out.println("Press E to exercise all virtual pets");
        System.out.println("Press X to clean all virtual cages");
        return input.nextLine();

    }

}
