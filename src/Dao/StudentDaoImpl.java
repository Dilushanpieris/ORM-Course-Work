package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Student;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean saveNewStudent(Student S) throws IOException {//save/update
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(S);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student readData(String st_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Student stu=session.get(Student.class,st_id);
        transaction.commit();
        session.close();
        return stu;
    }

    @Override
    public boolean deleteData(String st_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Student stu=session.get(Student.class,st_id);
        session.delete(stu);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String getLastId() throws IOException {
        String tempId="S000";
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        String hql="FROM Student";
        Query query = session.createQuery(hql);
        List<Student> result=query.list();
        for (Student student:result) {
            tempId=student.getSt_id();
        }
        transaction.commit();
        session.close();
        return tempId;
    }

    @Override
    public String gearateNewID() throws IOException {
        String lastId=getLastId();
        int lastChar= Integer.parseInt(lastId.substring(lastId.length() - 1));
        String newId=lastId+"\b";
        lastChar++;
        newId=newId+lastChar;
        return newId;
    }

    @Override
    public boolean isExists(String st_id) throws IOException {
        boolean exists=false;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Student";
        Query query = session.createQuery(hql);
        List<Student> result=query.list();
        for (Student student:result) {
            if(student.getSt_id().equals(st_id)){
                exists=true;
            }
        }
        return exists;
    }


}
