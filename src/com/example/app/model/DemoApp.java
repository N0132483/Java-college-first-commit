package com.example.app.model;

import java.util.List;
import java.util.Scanner;

public class DemoApp {
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        
        Model model = Model.getInstance();
        
        Student s;
        
        int opt;
        do {
            System.out.println("1. Create new Student");
            System.out.println("2. Delete existing Student");
            System.out.println("3. View all Students");
            System.out.println("4. Exit");
            System.out.println();

            System.out.print("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);

            System.out.println("You chose option " + opt);
            switch (opt) {
                case 1: {
                    System.out.println("Creating student");
                    s = readStudent(keyboard);
                    model.addStudent(s);
                    
                    break;
                }
                case 2: {
                    System.out.println("Deleting student");
                    deleteStudent(keyboard, model);
                    break;
                }
                case 3: {
                    System.out.println("Viewing students");
                    viewStudents(model);
                    break;
                }
            }
        }
        while (opt != 4);
        System.out.println("Goodbye");
    }
    
    private static Student readStudent(Scanner keyb) {
        String stu_name, stu_address;
        int stu_id, stu_phone_no, stu_DOB;
        String line;

        line = getString(keyb, "Enter stu_id: ");
        stu_id= Integer.parseInt(line);       
        stu_name = getString(keyb, "Enter stu_name: ");
        stu_address = getString(keyb, "Enter stu_address: ");
        line = getString(keyb, "Enter stu_phone_no: ");
        stu_phone_no = Integer.parseInt(line);
        line = getString(keyb, "Enter stu_DOB: ");
        stu_DOB = Integer.parseInt(line);

        Student s;
        s = new Student(stu_id, stu_name, stu_address, stu_phone_no, stu_DOB);
        
        return s;
    }
    
    private static void deleteStudent(Scanner kb, Model m) {
        System.out.print("Enter the students id number to delete:");
        int stu_id = Integer.parseInt(kb.nextLine());
        Student s;

        s = m.findStudentByStudentid(stu_id);
        if (s != null) {
            if (m.removeStudent(s)) {
                System.out.println("Student deleted");
            }
            else {
                System.out.println("Student not deleted");
            }
        }
        else {
            System.out.println("Student not found");
        }
    }
    
    private static void viewStudents(Model model) {
        List<Student> students = model.getStudents();
        students.stream().forEach((st) -> {
            System.out.println("Name: " + st.getstu_name());
        });
    }

    private static String getString(Scanner keyboard, String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }
}
