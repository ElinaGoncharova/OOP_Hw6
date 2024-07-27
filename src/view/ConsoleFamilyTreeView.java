package view;

import writer.FamilyTreeIO;
import family_three.FamilyThree;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    @Override
    public void displayError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }

    @Override
    public void displayFamilyTree(FamilyThree<?> familyTree) {
        System.out.println("Displaying family tree:");
        for (var member : familyTree) { // Используем Iterable
            System.out.println(member);
        }
    }

    @Override
    public void saveFamilyTree(FamilyThree<?> familyTree) {
        System.out.println("Enter filename to save:");
        String filename = getInput("Filename: ");
        try {
            FamilyTreeIO.writeFamilyTree(familyTree, filename);
        } catch (IOException e) {
            displayError("An error occurred while saving the family tree: " + e.getMessage());
        }
    }

    @Override
    public void loadFamilyTree() {
        System.out.println("Enter filename to load:");
        String filename = getInput("Filename: ");
        try {
            FamilyThree<?> familyTree = FamilyTreeIO.readFamilyTree(filename);
            displayFamilyTree(familyTree);
        } catch (IOException | ClassNotFoundException e) {
            displayError("An error occurred while loading the family tree: " + e.getMessage());
        }
    }
}

