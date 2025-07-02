package org.example;

public class App
{
    public static void main( String[] args )
    {

        int[] marks = {85, 78, 92, 88, 75};
        Student student = new Student("Sanjith", "SECE123", "Computer and Communication", marks);
        student.displayDetails();
    }
}
