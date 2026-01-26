public class Student {
    private String imie;
    private int wiek;
    private String email;
    private String dataUrodzenia;

    public Student(String imie, int wiek, String email, String dataUrodzenia) {
        this.imie = imie;
        this.wiek = wiek;
        this.email = email;
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getEmail() {
        return email;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String toFileString() {
        return imie + ";" + wiek + ";" + email + ";" + dataUrodzenia;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(";");
        if (parts.length >= 4) {
            return new Student(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student: " + imie + " | Wiek: " + wiek + " | Email: " + email + " | Ur.: " + dataUrodzenia;
    }
}