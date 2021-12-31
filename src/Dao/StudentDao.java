package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Student;

import java.io.IOException;

public interface StudentDao {
    public boolean saveNewStudent(Student S) throws IOException;
    public Student readData(String st_id) throws IOException;
    public boolean deleteData(String st_id) throws IOException;
    public String getLastId() throws IOException;
    public String gearateNewID() throws IOException;

    String removeLastCharOptional(String s);

    public boolean isExists(String st_id) throws IOException;
}
