package util;

import model.Student;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void save(ArrayList<Student> list) {
        try (ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
            a.writeObject(list);
        } catch (Exception e) {
            System.out.println("Save error");
        }
    }

    public static ArrayList<Student> load() {
        try (ObjectInputStream a = new ObjectInputStream(new FileInputStream("data.dat"))) {
            return (ArrayList<Student>) a.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}