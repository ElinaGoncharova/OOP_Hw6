package view;

import human.Human;
import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showFamilyTree(List<Human> members) {
        for (Human member : members) {
            System.out.println(member.getName() + ", " + member.getBirthday());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
}
