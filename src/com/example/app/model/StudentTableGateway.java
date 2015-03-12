package com.example.app.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentTableGateway {
    private static final String TABLE_NAME = "students";
    private static final Integer COLUMN_stu_id = "stu_id";
    private static final String COLUMN_stu_name = "stu_name";
    private static final String COLUMN_stu_address = "stu_address";
    private static final String COLUMN_stu_phone_no = "stu_phone_no";
    private static final String COLUMN_stu_DOB = "stu_DOB";
   
    
    private final Connection mConnection;

    public StudentTableGateway(Connection connection) {
        mConnection = connection;
    }
    public List<Student> getStudents() throws SQLException {
        String query;       // the SQL query to execute
        Statement stmt;     // the java.sql.Statement object used to execute the
                            // SQL query
        ResultSet rs;       // the java.sql.ResultSet representing the result of
                            // SQL query 
        List<Student> students;   // the java.util.List containing the Student objects
                            // created for each row in the result of the query
        int stu_id, stu_phone_no, stu_DOB;             // the id of a student
        String stu_name, stu_address;
        Student s;       // a Student object created from a row in the result of
                            // the query

        // execute an SQL SELECT statement to get a java.util.ResultSet representing
        // the results of the SELECT statement
        query = "SELECT * FROM " + TABLE_NAME;
        stmt = this.mConnection.createStatement();
        rs = stmt.executeQuery(query);

        // iterate through the result set, extracting the data from each row
        // and storing it in a Student object, which is inserted into an initially
        // empty ArrayList
        students = new ArrayList<>();
        while (rs.next()) {
            //stu_id = rs.getint(COLUMN_stu_id); 
            stu_id = Integer.parseInt(COLUMN_stu_id);
            
            stu_name = rs.getString(COLUMN_stu_name);
            stu_address = rs.getString(COLUMN_stu_address);
            stu_phone_no = rs.getString(COLUMN_stu_phone_no);
            stu_DOB = rs.getString(COLUMN_stu_DOB);
            

            s = new Student(stu_id, stu_name, stu_address, stu_phone_no, stu_DOB);
            students.add(s);
        }

        return students;
    }
    
}
