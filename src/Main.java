import family_three.FamilyThree;
import human.Human;
import presenter.FamilyTreePresenter;
import view.ConsoleFamilyTreeView;

public class Main {
    public static void main(String[] args) {
        // Создание корневого элемента
        Human root = new Human("John Doe", "01/01/1980");

        // Создание дерева
        FamilyThree<Human> familyTree = new FamilyThree<>(root);

        // Создание представления и презентера
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view, familyTree);

        // Пример работы с презентером
        presenter.addMember(new Human("Jane Doe", "02/02/2010"));
        presenter.displayFamilyTree();

        // Работа с пользовательским вводом
        view.showMessage("Enter filename to save:");
        String filename = view.getUserInput();
        presenter.saveFamilyTree(filename);

        view.showMessage("Enter filename to load:");
        filename = view.getUserInput();
        presenter.loadFamilyTree(filename);

        presenter.sortByName();
        presenter.displayFamilyTree();

        presenter.sortByBirthday();
        presenter.displayFamilyTree();
    }
}
