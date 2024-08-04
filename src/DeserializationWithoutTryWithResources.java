import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

class DeserializationWithoutTryWithResources {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        BufferedInputStream bufferIn = null;
        ObjectInputStream in = null;

        try {
            fileIn = new FileInputStream("people_list.ser");
            bufferIn = new BufferedInputStream(fileIn);
            in = new ObjectInputStream(bufferIn);
            List<Person> people = (List<Person>) in.readObject();
            for (Person person : people) {
                System.out.println("Deserialized Person: " + person);
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        } finally {
            // Close resources in reverse order of their creation
            try {
                if (in != null) {
                    in.close();
                }
                if (bufferIn != null) {
                    bufferIn.close();
                }
                if (fileIn != null) {
                    fileIn.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
