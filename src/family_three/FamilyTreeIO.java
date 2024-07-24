package family_three;

import java.io.*;

public class FamilyTreeIO implements FamilyTreeSerializable {
    private FamilyThree familyTree;

    public FamilyTreeIO(FamilyThree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(familyTree);
        }
    }

    @Override
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree = (FamilyThree) in.readObject();
        }
    }

    public FamilyThree getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyThree familyTree) {
        this.familyTree = familyTree;
    }
}
