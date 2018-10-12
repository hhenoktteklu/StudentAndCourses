package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here

        Scanner input = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<Student>();
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        ArrayList<Courses> courseList = new ArrayList<Courses>();
        ArrayList studentCourseRegistered = new ArrayList();
        ArrayList teacherCourseRegistered = new ArrayList();
        long studentId = 101;
        long teacherId = 10100;
        long courseId = 1010010;
        boolean studentMoreCourse = false;
        boolean teacherMoreCourse = false;


        do {
            System.out.print("\n\n 1. Add Student\n 2. Add Teacher\n 3. Add Course\n 4. List of students\n 5. List of Teacher\n 6. List of Courses\n");

            switch (input.nextInt()) {
                case 1:
                    Student student = new Student();


                    System.out.print("First Name: ");
                    student.setFirstName(input.next());

                    System.out.print("Last Name: ");
                    student.setLastName(input.next());

                    System.out.print("e-mail: ");
                    student.setEmailAddress(input.next());

                    do {

                        System.out.println("Enter the course you want to register? ");
                        String course = input.next();
                        studentCourseRegistered.add(course);
                        System.out.print("Do you want to add more? (y/n)");
                        if (input.next().equalsIgnoreCase("y")) {
                            studentMoreCourse = true;
                        } else {
                            student.setCourseList(studentCourseRegistered);
                            System.out.println("--> " + studentCourseRegistered);
                            studentMoreCourse = false;
                            break;
                        }
                    } while (studentMoreCourse);

                    student.setId(studentId);
                    studentId++;
                    studentList.add(student);
                    break; // optional

                case 2:
                    Teacher teacher = new Teacher();

                    System.out.print("First Name: ");
                    teacher.setFirstName(input.next());

                    System.out.print("Last Name: ");
                    teacher.setLastName(input.next());

                    System.out.print("e-mail: ");
                    teacher.setEmailAddress(input.next());
                    do {
                        ArrayList courseRegistered = new ArrayList();
                        System.out.print("Enter the course you teaching: ");
                        String course = input.next();
                        teacherCourseRegistered.add(course);
                        System.out.print("Are you teaching more course? (y/n)");
                        if (input.next().equalsIgnoreCase("y")) {
                            teacherMoreCourse = true;
                        } else {
                            teacher.setCourseList(teacherCourseRegistered);
                            teacherMoreCourse = false;
                            break;
                        }
                    } while (teacherMoreCourse);
                    teacher.setId(teacherId);
                    teacherId++;

                    teacherList.add(teacher);
                    break; // optional

                case 3:
                    Courses course = new Courses();

                    System.out.print("Course Name: ");
                    course.setCourseName(input.next());

                    System.out.print("ID: ");
                    course.setId(courseId);
                    courseId++;
                    courseList.add(course);
                    break; // optional

                case 4:
                    System.out.println("List of Students");
                    for (Student stList : studentList) {
                        System.out.println("ID Number: " + stList.getId() + "\n" + "First Name: " + stList.getFirstName() + "\n" + "Last Name: " + stList.getLastName() + "\n" + "Email: " + stList.getEmailAddress());

                        ArrayList stCour = stList.getCourseList();

                        System.out.print("Takes: ");
                        for (int i = 0; i < stCour.size(); i++) {
                            System.out.print(stCour.get(i)+" ");
                        }
                    }

                    break; // optional
                case 5:
                    System.out.println("List of Teachers");
                    for (Teacher tList : teacherList) {
                        System.out.println("ID Number: " + tList.getId() + "\n" + "First Name: " + tList.getFirstName() + "\n" + "Last Name: " + tList.getLastName() + "\n" + "Email: " + tList.getEmailAddress() + "\n");

                        ArrayList stCour = tList.getCourseList();

                        for (int i = 0; i < stCour.size(); i++) {
                            System.out.print(stCour.get(i));
                        }
                    }
                    break; // optional

                case 6:
                    System.out.println("List of Courses");
                    for (Courses cList : courseList) {
                        System.out.println("Course ID Number: " + cList.getId() + "\n" + "Course Name: " + cList.getCourseName() + "\n");
                    }
                    break; // optional
                // You can have any number of case statements.
                default: // Optional

            }
        } while (true);
    }
}
