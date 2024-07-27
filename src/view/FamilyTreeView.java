package view;

import family_three.FamilyThree;

public interface FamilyTreeView {
    void showMessage(String message);
    String getInput(String prompt);
    void displayError(String errorMessage);
    void displayFamilyTree(FamilyThree<?> familyTree);
    void saveFamilyTree(FamilyThree<?> familyTree);
    void loadFamilyTree();
}
