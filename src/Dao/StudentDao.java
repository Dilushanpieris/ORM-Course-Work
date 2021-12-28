package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Student;

import java.io.IOException;

public interface StudentDao {
    public void saveNewStudent(Student S) throws IOException;
}
