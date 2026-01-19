import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- System Studentów (Commit 5_1.3) ---");

        while (running) {
            System.out.println("\nMENU:");
            System.out.println("1. Dodaj nowego studenta");
            System.out.println("2. Wypisz wszystkich studentów");
            System.out.println("3. Znajdź studenta po imieniu");
            System.out.println("4. Usuń studenta");
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
                        System.out.print("Podaj datę urodzenia: ");
                        String dataUr = scanner.nextLine();

                        Student nowy = new Student(imie, wiek, email, dataUr);
                        service.addStudent(nowy);
                        System.out.println("Dodano studenta!");
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

                    case "3":
                        System.out.print("Podaj imię szukanego studenta: ");
                        String szukaneImie = scanner.nextLine();
                        Student znaleziony = service.findStudentByName(szukaneImie);
                        if (znaleziony != null) {
                            System.out.println("Znaleziono: " + znaleziony);
                        } else {
                            System.out.println("Nie ma studenta o takim imieniu.");
                        }
                        break;

                    case "4":
                        System.out.print("Podaj imię studenta do usunięcia: ");
                        String doUsuniecia = scanner.nextLine();
                        boolean usunieto = service.deleteStudent(doUsuniecia);

                        if (usunieto) {
                            System.out.println("Student został usunięty z bazy.");
                        } else {
                            System.out.println("Nie znaleziono studenta o takim imieniu.");
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