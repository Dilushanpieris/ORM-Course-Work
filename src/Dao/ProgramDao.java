package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Program;
import Entity.Student;

import java.io.IOException;

public interface ProgramDao {
    public boolean saveNewProgram(Program program) throws IOException;
    public Program readData(String p_id) throws IOException;
    public boolean deleteData(String p_id) throws IOException;
    public String getLastId() throws IOException;
    public String gearateNewID() throws IOException;
    public boolean isExists(String p_pid) throws IOException;
}
