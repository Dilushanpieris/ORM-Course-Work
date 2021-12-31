package Dao;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Program;
import Util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class ProgramDaoImpl implements ProgramDao{
    @Override
    public boolean saveNewProgram(Program program) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(program);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Program readData(String p_id) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Program pro=session.get(Program.class,p_id);
        transaction.commit();
        session.close();
        return pro;
    }
    @Override
    public ArrayList<String> getAllIds() throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        String hql="FROM Program";
        Query query = session.createQuery(hql);
        List<Program> result=query.list();
        ArrayList<String> Ids=new ArrayList<>();
        for (Program program:result) {
            Ids.add(program.getP_id());
        }
        transaction.commit();
        session.close();
        return Ids;
    }

    @Override
    public boolean deleteData(String p_id) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
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
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
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
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
        String lastId=getLastId();
        int lastChar= Integer.parseInt(lastId.substring(lastId.length() - 1));
        String newId=removeLastCharOptional(lastId);
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
    public boolean isExists(String p_pid) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //Code
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
