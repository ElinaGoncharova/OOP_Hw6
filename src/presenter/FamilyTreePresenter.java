package presenter;

import view.FamilyTreeView;
import family_three.FamilyThree;
import human.Human;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyThree<Human> familyTree;

    public FamilyTreePresenter(FamilyTreeView view, FamilyThree<Human> familyTree) {
        this.view = view;
        this.familyTree = familyTree;
    }

    public void saveFamilyTree() {
        view.saveFamilyTree(familyTree);
    }

    public void loadFamilyTree() {
        view.loadFamilyTree();
    }

    public void showFamilyTree() {
        view.displayFamilyTree(familyTree);
    }
}
