import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class WritingWithoutSerializationWithoutBuffer {
    public static void main(String[] args) {
        Person person1 = new Person("John Doe", 30);
        Person person2 = new Person("Jane Smith", 25);

        PrintWriter writer = null;
        BufferedWriter buffer = null;
        try {
            buffer = new BufferedWriter(new FileWriter("people_buffered.txt"));
            writer = new PrintWriter(buffer);
            writer.println(person1.toString());
            writer.println(person2.toString());
            System.out.println("Data written to people_buffered.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
