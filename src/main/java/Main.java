/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        try {
            do {
                System.out.println("\n-------------------------------------------");
                System.out.println("--- MENU DODAWANIA STUDENTÓW ---");
                System.out.println("1. Dodaj nowego studenta");
                System.out.println("2. Wypisz wszystkich studentów"); 
                System.out.println("0. Wyjście");
                System.out.print("Wybierz opcję: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("\n**Opcja musi być liczbą całkowitą (0, 1 lub 2). Spróbuj ponownie.**");
                    scanner.nextLine();
                    choice = -1;
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("\n--- DODAJ NOWEGO STUDENTA ---");
                        String name;
                        int age = 0;
                        boolean ageValid = false;

                        System.out.print("Podaj imię studenta: ");
                        name = scanner.nextLine();

                        while (!ageValid) {
                            System.out.print("Podaj wiek studenta: ");
                            if (scanner.hasNextInt()) {
                                age = scanner.nextInt();
                                scanner.nextLine();
                                ageValid = true;
                            } else {
                                System.out.println("**Wiek musi być liczbą. Spróbuj ponownie.**");
                                scanner.nextLine();
                            }
                        }

                        s.addStudent(new Student(name, age));
                        System.out.println("\n✅ Student " + name + " został dodany i zapisany w db.txt.");
                        break;

                    case 2:
                        System.out.println("\n-------------------------------------------");
                        System.out.println("--- WSZYSCY STUDENCI W SYSTEMIE (z pliku db.txt) ---");

                        Collection<Student> students = s.getStudents();

                        if (students == null || students.isEmpty()) {
                            System.out.println("Brak studentów w pliku.");
                        } else {
                            for (Student current : students) {
                                System.out.println(current.ToString()); 
                            }
                        }

                        System.out.println("-------------------------------------------");
                        break;

                    case 0:
                        System.out.println("\nWyjście z programu dodawania.");
                        break;

                    default:
                        System.out.println("\n**Nieznana opcja. Wybierz 1, aby dodać studenta, 2, aby wypisać, lub 0, aby wyjść.**");
                        break;
                }

            } while (choice != 0);

            // Podsumowanie przy wyjściu z programu
            System.out.println("\n-------------------------------------------");
            System.out.println("--- ZAPISANI STUDENCI (PODSUMOWANIE) ---");

            Collection<Student> students = s.getStudents();

            if (students == null || students.isEmpty()) {
                System.out.println("Brak studentów w pliku.");
            } else {
                for (Student current : students) {
                    System.out.println(current.ToString()); 
                }
            }

            System.out.println("-------------------------------------------");

        } catch (IOException e) {
            System.err.println("\nBłąd operacji wejścia/wyjścia (db.txt): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nWystąpił nieoczekiwany błąd: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}