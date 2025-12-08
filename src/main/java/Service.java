import java.util.ArrayList;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

    public void addStudent(Student student) throws IOException {
        try (FileWriter f = new FileWriter("db.txt", true);
             BufferedWriter b = new BufferedWriter(f)) {

            b.append(student.ToString());
            b.newLine();
        }
    }

    public Collection<Student> getStudents() throws IOException {
        Collection<Student> ret = new ArrayList<>();

        try (FileReader f = new FileReader("db.txt");
             BufferedReader reader = new BufferedReader(f)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    ret.add(Student.Parse(line));
                }
            }
        } catch (java.io.FileNotFoundException e) {
            return ret; 
        }
        return ret;
    }

    public Student findStudentByName(String name) {
        return null;
    }
}