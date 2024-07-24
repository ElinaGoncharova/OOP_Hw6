package family_three;

import java.io.IOException;

public interface FamilyTreeSerializable {
    void saveToFile(String filename) throws IOException;
    void loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
