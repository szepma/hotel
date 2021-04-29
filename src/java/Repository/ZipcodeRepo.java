package Repository;

import Model.Database;
import Model.Zipcodes;
import java.util.List;
import javax.persistence.Entity;
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
    
    public static Zipcodes checkZipcode(String zip) {
        Zipcodes result = new Zipcodes(-1, zip);
        try {
            EntityManager em = Database.getDbConn();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("checkZipcode");
            
            spq.registerStoredProcedureParameter("zipIN", String.class, ParameterMode.IN);
            spq.setParameter("zipIN", zip);
            
            List<Object[]> zipList = spq.getResultList();
            for (Object[] current : zipList) {
                int id = Integer.parseInt(current[0].toString());
                result = result.getZipcodeById(id);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            return result;
        }
    }
}
