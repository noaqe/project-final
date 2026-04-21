package service;

import model.Student;
import java.util.ArrayList;

public class StudentService {

    private ArrayList<Student> list = new ArrayList<>();

    public void add(Student s) {
        list.add(s);
    }

    public ArrayList<Student> getAll() {
        return list;
    }

    public Student find(String name) {
        for (Student s : list) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    public Student top() {
        if (list.isEmpty()) return null;

        Student best = list.get(0);

        for (Student s : list) {
            if (s.getAverage() > best.getAverage()) {
                best = s;
            }
        }
        return best;
    }
}