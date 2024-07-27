import family_three.FamilyThree;
import human.Human;
import view.ConsoleFamilyTreeView;
import view.FamilyTreeView;
import presenter.FamilyTreePresenter;

public class Main {
    public static void main(String[] args) {
        FamilyThree<Human> familyTree = new FamilyThree<>();
        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view, familyTree);

        presenter.loadFamilyTree();
        presenter.saveFamilyTree();
        presenter.showFamilyTree();
    }
}

