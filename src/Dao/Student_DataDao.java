package Dao;/*
Author-:dilus
Date:-30/12/2021
*/

import Entity.Program;
import Entity.Student_Data;

import java.io.IOException;
import java.util.List;

public interface Student_DataDao {
    public boolean saveNewData(Student_Data student_data) throws IOException;
    public Student_Data readData(String st_id,String p_id) throws IOException;
    public List<Student_Data> readData() throws IOException;
    public boolean deleteData(String st_id,String p_id) throws IOException;
    public boolean isExists(String st_id,String p_id) throws IOException;

}
