package main;

import model.Student;
import service.StudentService;
import util.FileManager;
import exception.InvalidGradeException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        service.getAll().addAll(FileManager.load());

        while (true) {
            System.out.println("\n1 Add");
            System.out.println("2 View");
            System.out.println("3 Search");
            System.out.println("4 Top");
            System.out.println("5 Exit");

            int c = sc.nextInt();

            if (c == 1) {
                try {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    Student s = new Student(id, name);

                    System.out.print("Grades count: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        int g = sc.nextInt();
                        if (g < 0 || g > 100)
                            throw new InvalidGradeException("Wrong grade");
                        s.addGrade(g);
                    }

                    service.add(s);

                } catch (Exception e) {
                    System.out.println("Error");
                    sc.nextLine();
                }
            }

            else if (c == 2) {
                for (Student s : service.getAll()) {
                    System.out.println(s);
                }
            }

            else if (c == 3) {
                System.out.print("Name: ");
                String name = sc.next();

                Student s = service.find(name);
                System.out.println(s != null ? s : "Not found");
            }

            else if (c == 4) {
                System.out.println(service.top());
            }

            else if (c == 5) {
                FileManager.save(service.getAll());
                break;
            }
        }
    }
}