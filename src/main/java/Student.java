public class Student {
    private String imie;
    private int wiek;
    private String email;
    private String dataUrodzenia; // Nowe pole (Zadanie 5_1.1)

    // Konstruktor uwzględniający datę urodzenia
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

    public String getEmail() {
        return email;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    // Zapis do pliku: oddzielamy pola średnikami
    public String toFileString() {
        return imie + ";" + wiek + ";" + email + ";" + dataUrodzenia;
    }

    // Odczyt z pliku: tworzenie obiektu z linii tekstu
    public static Student fromFileString(String line) {
        String[] parts = line.split(";");
        // Sprawdzamy czy są 4 elementy (imię, wiek, email, data)
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