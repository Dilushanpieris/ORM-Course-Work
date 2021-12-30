import Dao.ProgramDao;
import Dao.ProgramDaoImpl;
import Dao.Student_DataDao;
import Dao.Student_DataDaoImpl;
import Entity.Student_Data;
import dto.Student_DataDTO;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class AppInitializer {
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("unused")
        org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); //or whatever level you need
        //Exe Code

    }

}
