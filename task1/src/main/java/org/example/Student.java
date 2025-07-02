package org.example;

public class Student extends Person {
    private String department;
    private int[] marks = new int[5];

    public Student(String name, String rollNo, String department, int[] marks) {
        super(name, rollNo);
        this.department = department;
        this.marks = marks;
    }

    public int getTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getAverage() {
        return getTotal() / 5.0;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 50) return "C";
        else return "F";
    }

    @Override
    public void displayDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("Name      : " + name);
        System.out.println("Roll No   : " + rollNo);
        System.out.println("Department: " + department);
        System.out.println("Marks     : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total     : " + getTotal());
        System.out.println("Average   : " + getAverage());
        System.out.println("Grade     : " + getGrade());
        System.out.println("----------------------------");
    }
}
