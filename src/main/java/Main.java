import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- System Studentów (Commit 5_1.1) ---");

        while (running) {
            System.out.println("\nMENU:");
            System.out.println("1. Dodaj nowego studenta");
            System.out.println("2. Wypisz wszystkich studentów");
            System.out.println("0. Wyjdź");
            System.out.print("Wybór: ");

            String wybor = scanner.nextLine();

            try {
                switch (wybor) {
                    case "1":
                        System.out.print("Podaj imię i nazwisko: ");
                        String imie = scanner.nextLine();

                        System.out.print("Podaj wiek: ");
                        int wiek = Integer.parseInt(scanner.nextLine());

                        System.out.print("Podaj email: ");
                        String email = scanner.nextLine();

                        // Tutaj pytamy o nową daną - datę urodzenia
                        System.out.print("Podaj datę urodzenia (np. 12-05-2000): ");
                        String dataUr = scanner.nextLine();

                        Student nowy = new Student(imie, wiek, email, dataUr);
                        service.addStudent(nowy);
                        System.out.println("Dodano studenta z datą urodzenia!");
                        break;

                    case "2":
                        List<Student> lista = service.getStudents();
                        if (lista.isEmpty()) {
                            System.out.println("Baza jest pusta.");
                        } else {
                            for (Student s : lista) {
                                System.out.println(s);
                            }
                        }
                        break;

                    case "0":
                        running = false;
                        System.out.println("Koniec programu.");
                        break;

                    default:
                        System.out.println("Niepoprawna opcja.");
                }
            } catch (IOException e) {
                System.out.println("Błąd pliku: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Błąd: Wiek musi być liczbą.");
            }
        }
        scanner.close();
    }
}