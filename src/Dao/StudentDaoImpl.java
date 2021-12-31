package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Program;
import Entity.Student;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean saveNewStudent(Student S) throws IOException {//save/update
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(S);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student readData(String st_id) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Student stu=session.get(Student.class,st_id);
        transaction.commit();
        session.close();
        return stu;
    }

    @Override
    public boolean deleteData(String st_id) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
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
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
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
    public ArrayList<String> getAllIds() throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Student ";
        Query query = session.createQuery(hql);
        List<Student> result=query.list();
        ArrayList<String> Ids=new ArrayList<>();
        for (Student student:result) {
            Ids.add(student.getSt_id());
        }
        transaction.commit();
        session.close();
        return Ids;
    }

    @Override
    public String gearateNewID() throws IOException {

        String lastId=getLastId();
        int lastChar= Integer.parseInt(lastId.substring(lastId.length() - 1));
        String newId=removeLastCharOptional(lastId);//lastId+"\b";
        lastChar++;
        newId=newId+lastChar;
        return newId;
    }
    @Override
    public  String removeLastCharOptional(String s) {
        return Optional.ofNullable(s)
                .filter(str -> str.length() != 0)
                .map(str -> str.substring(0, str.length() - 1))
                .orElse(s);
    }

    @Override
    public boolean isExists(String st_id) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
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
