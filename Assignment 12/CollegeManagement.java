package jav;

import student.Student;
import faculty.Faculty;

public class CollegeManagement {

    public static void main(String args[]) {

        Student s = new Student();
        Faculty f = new Faculty();

        s.displayStudent();

        System.out.println();

        f.displayFaculty();
    }
}
