import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class SerializeWithTryWithResources {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John Doe", 30));
        people.add(new Person("Jane Smith", 25));

        try (FileOutputStream fileOut = new FileOutputStream("people_list.ser");
             BufferedOutputStream bufferOut = new BufferedOutputStream(fileOut);
             ObjectOutputStream out = new ObjectOutputStream(bufferOut)) {
            out.writeObject(people);
            System.out.println("Serialized data is saved in people_list.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
