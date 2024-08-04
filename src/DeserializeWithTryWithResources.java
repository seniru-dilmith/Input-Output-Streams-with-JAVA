import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

class DeserializeWithTryWithResources {
    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("people_list.ser");
             BufferedInputStream bufferIn = new BufferedInputStream(fileIn);
             ObjectInputStream in = new ObjectInputStream(bufferIn)) {
            List<Person> people = (List<Person>) in.readObject();
            for (Person person : people) {
                System.out.println("Deserialized Person: " + person);
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }
}
