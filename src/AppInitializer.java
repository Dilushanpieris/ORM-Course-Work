import Dao.StudentDao;
import Dao.StudentDaoImpl;
import Entity.Student;
import dto.StudentDTO;

import java.io.IOException;
import java.util.logging.Level;

public class AppInitializer {
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); //or whatever level you need

        StudentDao studentDao=new StudentDaoImpl();
        Student std=new Student("S004","Namal","Nuwara","078121345");
        studentDao.saveNewStudent(std);

        //Code For Save etc

    }

}
