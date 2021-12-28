package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Student;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void saveNewStudent(Student S) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(S);
        transaction.commit();
        session.close();
    }
}
