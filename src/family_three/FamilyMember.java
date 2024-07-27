package family_three;

import java.io.Serializable;
import java.util.List;

public interface FamilyMember extends Serializable {
    String getName();
    void setName(String name);

    String getBirthday();
    void setBirthday(String birthday);

    List<FamilyMember> getChildren();
    void setChildren(List<FamilyMember> children);

    FamilyMember getParent();
    void setParent(FamilyMember parent);
}
