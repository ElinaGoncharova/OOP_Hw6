package writer;

import family_three.FamilyThree;
import family_three.FamilyTreeIO;
import human.Gender;
import human.Human;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создание семейного древа
        FamilyThree familyTree = new FamilyThree();

        // Создание членов семьи
        Human john = new Human("John Doe", LocalDate.of(1980, 5, 15), Gender.Male);
        Human jane = new Human("Jane Doe", LocalDate.of(1982, 8, 25), Gender.Female);
        Human child1 = new Human("Chris Doe", LocalDate.of(2005, 1, 10), Gender.Male);
        Human child2 = new Human("Anna Doe", LocalDate.of(2008, 6, 20), Gender.Female);

        // Установка родительских связей
        child1.addParents(john, jane);
        child2.addParents(john, jane);

        // Добавление членов семьи в древо
        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        // Добавление нового члена семьи
        Human alice = new Human("Alice Doe", LocalDate.of(2010, 12, 1), Gender.Female);
        alice.addParents(john, jane);
        familyTree.addMember(alice);

        // Сортировка по имени
        familyTree.sortByName();
        System.out.println("Family members sorted by name:");
        familyTree.printFamilyTree();

        // Сортировка по дате рождения
        familyTree.sortByBirthday();
        System.out.println("\nFamily members sorted by birthday:");
        familyTree.printFamilyTree();

        // Создание объекта для работы с файлами
        FamilyTreeIO familyTreeIO = new FamilyTreeIO(familyTree);

        // Запись семейного древа в файл
        try {
            familyTreeIO.saveToFile("familyTree.ser");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Чтение семейного древа из файла
        try {
            familyTreeIO.loadFromFile("familyTree.ser");
            System.out.println("\nFamily tree loaded from file.");
            familyTreeIO.getFamilyTree().printFamilyTree();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
