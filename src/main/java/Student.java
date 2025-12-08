public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String GetName() {
        return name;
    }

    public int GetAge() {
        return age;
    }

    public String ToString() {
        return name + " " + Integer.toString(age); 
    }

    public static Student Parse(String str) {
        String[] data = str.split(" ");
        if (data.length != 2) {
            return new Student("Parse Error", -1);
        }
        return new Student(data[0], Integer.parseInt(data[1]));
    }
}