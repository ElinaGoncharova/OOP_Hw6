package family_three;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyThree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private T root;
    private List<T> members = new ArrayList<>();

    public FamilyThree(T root) {
        this.root = root;
        this.members.add(root);
    }

    public void addMember(T member) {
        members.add(member);
    }

    public void sortByName() {
        // Пример сортировки по имени
        members.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
    }

    public void sortByBirthday() {
        // Пример сортировки по дате рождения
        members.sort((m1, m2) -> m1.getBirthday().compareTo(m2.getBirthday()));
    }

    // Getters and Setters
    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public List<T> getMembers() {
        return members;
    }

    public void setMembers(List<T> members) {
        this.members = members;
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
}
