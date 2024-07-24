package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate birthday;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthday, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    // Приватный метод для расчета возраста
    private int calculateAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthday, endDate).getYears();
    }

    // Метод для установки родительских связей
    public void addParents(Human father, Human mother) {
        setFather(father);
        setMother(mother);
        if (father != null) {
            father.addChild(this);
        }
        if (mother != null) {
            mother.addChild(this);
        }
    }

    // Метод для добавления ребенка
    public void addChild(Human child) {
        this.children.add(child);
    }

    // Метод toString
    @Override
    public String toString() {
        return getInfo();
    }

    // Метод getInfo
    public String getInfo() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + calculateAge() +
                ", gender=" + gender +
                '}';
    }

    // Метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(birthday, human.birthday) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, gender);
    }
}
