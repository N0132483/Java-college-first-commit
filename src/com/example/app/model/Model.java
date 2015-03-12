package com.example.app.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {

    private static Model instance = null;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    private List<Student> students;

    private Model() {

        try {
            Connection conn = DBConnection.getInstance();
            StudentTableGateway gateway = new StudentTableGateway(conn);
            
            this.students = gateway.getStudents();
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Student> getStudents() {
        return new ArrayList<>(this.students);
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }
    
    public boolean removeStudent(Student s) {
        return this.students.remove(s);
    }

    public Student findStudentByStudentid(int stu_id) {
        Student s = null;
        int i = 0;
        boolean found = false;
        while (i < this.students.size() && !found) {
            s = this.students.get(i);
            if (s.getstu_id() == stu_id) {
                found = true;
            } else {
                i++;
            }
        }
        if (!found) {
            s = null;
        }
        return s;
    }
}
