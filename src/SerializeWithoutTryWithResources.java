import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

class SerializeWithoutTryWithResources {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John Doe", 30));
        people.add(new Person("Jane Smith", 25));

        FileOutputStream fileOut = null;
        BufferedOutputStream bufferOut = null;
        ObjectOutputStream out = null;

        try {
            fileOut = new FileOutputStream("people_list.ser");
            bufferOut = new BufferedOutputStream(fileOut);
            out = new ObjectOutputStream(bufferOut);
            out.writeObject(people);
            System.out.println("Serialized data is saved in people_list.ser");
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            try {
                if (out != null) {
                    out.close();
                }
                if (bufferOut != null) {
                    bufferOut.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
