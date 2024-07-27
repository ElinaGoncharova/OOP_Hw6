package view;

import human.Human;
import java.util.List;

public interface FamilyTreeView {
    void showFamilyTree(List<Human> members);
    void showMessage(String message);
    String getUserInput();
}
