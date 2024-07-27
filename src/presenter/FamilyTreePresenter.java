package presenter;

import family_three.FamilyThree;
import human.Human;
import view.FamilyTreeView;
import writer.FamilyTreeIO;

import java.io.IOException;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyThree<Human> model;

    public FamilyTreePresenter(FamilyTreeView view, FamilyThree<Human> model) {
        this.view = view;
        this.model = model;
    }

    public void addMember(Human member) {
        model.addMember(member);
        view.showMessage("Member added: " + member.getName());
    }

    public void displayFamilyTree() {
        List<Human> members = model.getMembers();
        view.showFamilyTree(members);
    }

    public void saveFamilyTree(String filename) {
        try {
            FamilyTreeIO.writeFamilyTree(model, filename);
            view.showMessage("Family tree saved to " + filename);
        } catch (IOException e) {
            view.showMessage("Error saving family tree: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String filename) {
        try {
            model = FamilyTreeIO.readFamilyTree(filename);
            view.showMessage("Family tree loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage("Error loading family tree: " + e.getMessage());
        }
    }

    public void sortByName() {
        model.sortByName();
        view.showMessage("Family tree sorted by name.");
    }

    public void sortByBirthday() {
        model.sortByBirthday();
        view.showMessage("Family tree sorted by birthday.");
    }
}

