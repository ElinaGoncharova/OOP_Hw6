package family_three;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class FamilyThree implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;

    private List<Human> members;

    public FamilyThree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Human human) {
        this.members.add(human);
    }

    public Optional<Human> findMemberByName(String name) {
        return members.stream()
                .filter(human -> human.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Human> getMembers() {
        return members;
    }

    public void printFamilyTree() {
        System.out.println("Family members:");
        for (Human member : this) {
            System.out.println(member);
        }
    }

    // Метод для сортировки по имени
    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Human::getName));
    }

    // Метод для сортировки по дате рождения
    public void sortByBirthday() {
        Collections.sort(members, Comparator.comparing(Human::getBirthday));
    }

    @Override
    public Iterator<Human> iterator() {
        return members.iterator();
    }
}
