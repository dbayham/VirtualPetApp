package virtual_pet;

import java.util.ArrayList;

public class VirtualPetShelter {

    private String shelterName;

    public VirtualPetShelter(String shelterName) {
        this.shelterName = shelterName;
    }

    ArrayList<VirtualPet> pets = new ArrayList<VirtualPet>();

    public void addPet(VirtualPet pet) {
        pets.add(pet);
    }

    void adoptPet(VirtualPet pet) {
        pets.remove(pet);
    }

    public VirtualPet getPetByName(String name) {
        for (VirtualPet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return pet;
            }
        }
        return null;
    }

    public boolean petIsInShelter(String name) {
        for (VirtualPet pet : pets) {
            if (pet.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public String listOfPets() {
        String petList = "";
        for (int i = 0; i < 20; i++) {
            petList += "\n";
        }
        petList = petList + "**************************************************** \n"
                + shelterName + " " + "pets available: \n";
        for (VirtualPet pet : pets) {
            petList += pet.status() + "\n";
        }
        return petList;
    }

    public void feedAllOrganicPets() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicPet) {

                ((OrganicPet) pet).eat();
            }
        }
    }

    public void chargeRoboPet() {
        for (VirtualPet pet : pets) {
            if (pet instanceof RoboticPet) {
                ((RoboticPet) pet).charge();
            }
        }
    }

    public void waterAllOrganicPets() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).drink();
            }
        }
    }

    public void cleanCages() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).cageClean();
            }
        }
    }

   /* public void playAllVirtualPets() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicPet && RoboticPet) {
                ((VirtualPet) pet).exercise();
  */

    public void exerciseAllVirtualPets() {
        for (VirtualPet pet : pets) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).exercise();
            }
            if (pet instanceof RoboticPet) {
                ((RoboticPet) pet).exercise();
            }
        }

    }

}