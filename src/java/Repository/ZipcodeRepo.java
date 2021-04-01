package Repository;

import Model.Database;
import Model.Zipcodes;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class ZipcodeRepo {
    public static boolean addNewZipcode(Zipcodes zip) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewZipcode");
            
            spq.registerStoredProcedureParameter("zipIN", String.class, ParameterMode.IN);
            
            spq.setParameter("zipIN", zip.getZipcode());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
