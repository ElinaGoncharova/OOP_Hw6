import family_three.FamilyThree;
import human.Human;
import writer.FamilyTreeIO;

import java.io.IOException;
import java.lang.ClassNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Создание корневого элемента
        Human root = new Human("John Doe", "01/01/1980");

        // Создание дерева
        FamilyThree<Human> familyTree = new FamilyThree<>(root);

        // Добавление членов семьи
        Human child = new Human("Jane Doe", "02/02/2010");
        familyTree.addMember(child);

        // Сортировка
        familyTree.sortByName();
        familyTree.sortByBirthday();

        // Запись и чтение из файла
        try {
            FamilyTreeIO.writeFamilyTree(familyTree, "familyTree.dat");
            FamilyThree<Human> loadedFamilyTree = FamilyTreeIO.readFamilyTree("familyTree.dat");

            // Вывод всех членов семьи
            for (Human member : loadedFamilyTree.getMembers()) {
                System.out.println(member.getName() + ", " + member.getBirthday());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    }
}
