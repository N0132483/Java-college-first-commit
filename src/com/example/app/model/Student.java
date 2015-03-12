package com.example.app.model;

public class Student {

    private int stu_id;
    private String stu_name;
    private String stu_address;
    private int stu_phone_no;
    private int stu_DOB;
    

    public Student(int id, String n, String a, int m, int DOB) {
        this.stu_id =  id;
        this.stu_name = n;
        this.stu_address = a;
        this.stu_phone_no = m;
        this.stu_DOB = DOB;        
    }

   // Student(String n, String a, int m, int DOB) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    public int getstu_id(){
        return stu_id;
    }
    
    public void setstu_id(int id) {
        this.stu_id = stu_id;
    }
    
    public String getstu_name() {
        return stu_name;
    }

    public void setstu_name(String n) {
        this.stu_name = stu_name;
    }

    public String getstu_address() {
        return stu_address;
    }

    public void setstu_address(String a) {
        this.stu_address = stu_address;
    }

    public int getstu_phone_no() {
        return stu_phone_no;
    }

    public void setstu_phone_no(int m) {
        this.stu_phone_no = stu_phone_no;
    }

    public int getstu_DOB() {
        return stu_DOB;
    }

    public void setstu_DOB (int DOB) {
        this.stu_DOB = stu_DOB;
    }
}

