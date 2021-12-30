package Dao;/*
Author-:dilus
Date:-30/12/2021
*/

import Entity.Program;
import Entity.Student_Data;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class Student_DataDaoImpl implements Student_DataDao{

    @Override
    public boolean saveNewData(Student_Data student_data) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(student_data);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student_Data readData(String st_id, String p_id) throws IOException {
        Student_Data obj=null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Student_Data WHERE st_id=:st_id AND p_id=:p_id";
        Query query = session.createQuery(hql);
        query.setParameter("st_id",st_id);
        query.setParameter("p_id",p_id);
        List<Student_Data> list = query.list();
        for (Student_Data student_data:list) {
            obj=student_data;
        }
        transaction.commit();
        session.close();
        return obj;
    }

    @Override
    public List<Student_Data> readData() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Student_Data";
        Query query = session.createQuery(hql);
        List<Student_Data> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean deleteData(String st_id, String p_id) throws IOException {
        Student_Data obj=null;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Student_Data WHERE st_id=:st_id AND p_id=:p_id";
        Query query = session.createQuery(hql);
        query.setParameter("st_id",st_id);
        query.setParameter("p_id",p_id);
        List<Student_Data> list = query.list();
        for (Student_Data student_data:list) {
            obj=student_data;
        }
        session.delete(obj);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean isExists(String st_id, String p_id) throws IOException {
        boolean exists=false;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Student_Data";
        Query query = session.createQuery(hql);
        List<Student_Data> result=query.list();
        for (Student_Data student_data:result) {
            if(student_data.getSt_id().equals(st_id)&&student_data.getP_id().equals(p_id)){
                exists=true;
            }
        }
        return exists;
    }
}
