package family_three;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyThree<T> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members;

    public FamilyThree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    // Метод для сортировки по имени
    public void sortByName() {
        members.sort((m1, m2) -> {
            if (m1 instanceof FamilyMember && m2 instanceof FamilyMember) {
                return ((FamilyMember) m1).getName().compareTo(((FamilyMember) m2).getName());
            }
            return 0;
        });
    }

    // Метод для сортировки по дате рождения
    public void sortByBirthday() {
        members.sort((m1, m2) -> {
            if (m1 instanceof FamilyMember && m2 instanceof FamilyMember) {
                return ((FamilyMember) m1).getBirthday().compareTo(((FamilyMember) m2).getBirthday());
            }
            return 0;
        });
    }
}
