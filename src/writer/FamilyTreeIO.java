package writer;

import family_three.FamilyThree;
import family_three.FamilyMember;
import java.io.*;

public class FamilyTreeIO {
    public static <T extends FamilyMember> void writeFamilyTree(FamilyThree<T> familyTree, String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(familyTree);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends FamilyMember> FamilyThree<T> readFamilyTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyThree<T>) in.readObject();
        }
    }
}
