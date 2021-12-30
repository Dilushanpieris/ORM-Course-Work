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
import java.util.List;

public class ProgramDaoImpl implements ProgramDao{
    @Override
    public boolean saveNewProgram(Program program) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Program readData(String p_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Program pro=session.get(Program.class,p_id);
        transaction.commit();
        session.close();
        return pro;
    }

    @Override
    public boolean deleteData(String p_id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Program program=session.get(Program.class,p_id);
        session.delete(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String getLastId() throws IOException {
        String tempId="CT000";
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        String hql="FROM Program";
        Query query = session.createQuery(hql);
        List<Program> result=query.list();
        for (Program program:result) {
            tempId=program.getP_id();
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
    public boolean isExists(String p_pid) throws IOException {
        boolean exists=false;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Program";
        Query query = session.createQuery(hql);
        List<Program> result=query.list();
        for (Program program:result) {
            if(program.getP_id().equals(p_pid)){
                exists=true;
            }
        }
        return exists;
    }
}
