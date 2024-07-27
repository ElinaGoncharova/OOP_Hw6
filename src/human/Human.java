package human;

import family_three.FamilyMember;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember {
    private static final long serialVersionUID = 1L;
    private String name;
    private String birthday;
    private FamilyMember parent;
    private List<FamilyMember> children = new ArrayList<>();

    public Human(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public List<FamilyMember> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<FamilyMember> children) {
        this.children = children;
    }

    @Override
    public FamilyMember getParent() {
        return parent;
    }

    @Override
    public void setParent(FamilyMember parent) {
        this.parent = parent;
    }
}

