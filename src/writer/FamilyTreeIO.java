package writer;

import family_three.FamilyThree;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FamilyTreeIO {
    
    // Запись дерева семьи в файл
    public static <T> void writeFamilyTree(FamilyThree<T> familyTree, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    // Чтение дерева семьи из файла
    @SuppressWarnings("unchecked")
    public static <T> FamilyThree<T> readFamilyTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyThree<T>) ois.readObject();
        }
    }
}
