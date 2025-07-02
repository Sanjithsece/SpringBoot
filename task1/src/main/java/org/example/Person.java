package org.example;
public abstract class Person {
    protected String name;
    protected String rollNo;

    public Person(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public abstract void displayDetails();
}

