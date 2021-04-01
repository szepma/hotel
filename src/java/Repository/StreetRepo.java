package Repository;

import Model.Database;
import Model.Streets;
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
}
