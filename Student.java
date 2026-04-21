package model;

import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Integer> grades = new ArrayList<>();

    public Student(int id, String name) {
        super(id, name);
    }

    public void addGrade(int g) {
        grades.add(g);
    }

    public double getAverage() {
        if (grades.size() == 0) return 0;

        int sum = 0;
        for (int g : grades) sum += g;

        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return id + " " + name + " Avg: " + getAverage();
    }
}