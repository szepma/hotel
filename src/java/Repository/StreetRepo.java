package Repository;

import Model.Database;
import Model.Streets;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class StreetRepo {
    public static boolean addNewStreet(Streets st) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em. createStoredProcedureQuery("addNewStreet");
            
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("zipIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("nameIN", st.getStreetname());
            spq.setParameter("zipIN", st.getZipcodeid());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Streets checkStreet(String streetName) {
        Streets result = new Streets(-1, streetName, -1);
        try {
            EntityManager em = Database.getDbConn();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("checkStreet");
            
            spq.registerStoredProcedureParameter("streetIN", String.class, ParameterMode.IN);
            spq.setParameter("streetIN", streetName);
            
            List<Object[]> streetList = spq.getResultList();
            for (Object[] current : streetList) {
                int id = Integer.parseInt(current[0].toString());
                result = result.getStreetById(id);
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
