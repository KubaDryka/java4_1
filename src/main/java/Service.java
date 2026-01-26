import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final String sciezkaDoPliku = "db.txt";

    public void addStudent(Student student) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(sciezkaDoPliku, true));
        writer.write(student.toFileString());
        writer.newLine();
        writer.close();
    }

    public List<Student> getStudents() throws IOException {
        List<Student> studenci = new ArrayList<>();
        File file = new File(sciezkaDoPliku);

        if (!file.exists()) {
            return studenci;
        }

        BufferedReader reader = new BufferedReader(new FileReader(sciezkaDoPliku));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            Student s = Student.fromFileString(currentLine);
            if (s != null) {
                studenci.add(s);
            }
        }
        reader.close();
        return studenci;
    }

    public Student findStudentByName(String name) throws IOException {
        List<Student> students = getStudents();
        for (Student s : students) {
            if (s.getImie().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(String name) throws IOException {
        List<Student> students = getStudents();
        Student doUsuniecia = null;

        for (Student s : students) {
            if (s.getImie().equalsIgnoreCase(name)) {
                doUsuniecia = s;
                break;
            }
        }

        if (doUsuniecia != null) {
            students.remove(doUsuniecia);
            saveAllStudents(students);
            return true;
        }
        return false;
    }

    public boolean updateStudentAge(String name, int newAge) throws IOException {
        List<Student> students = getStudents();
        boolean znaleziono = false;

        for (Student s : students) {
            if (s.getImie().equalsIgnoreCase(name)) {
                s.setWiek(newAge);
                znaleziono = true;
                break;
            }
        }

        if (znaleziono) {
            saveAllStudents(students);
            return true;
        }
        return false;
    }

    private void saveAllStudents(List<Student> students) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(sciezkaDoPliku, false));
        for (Student s : students) {
            writer.write(s.toFileString());
            writer.newLine();
        }
        writer.close();
    }
}