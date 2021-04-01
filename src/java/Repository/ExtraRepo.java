package Repository;

import Model.Database;
import Model.Extras;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class ExtraRepo {
    public static boolean addNewExtra(Extras extra) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewExtra");
            
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("descIN", String.class, ParameterMode.IN);
            
            spq.setParameter("nameIN", extra.getExtraName());
            spq.setParameter("descIN", extra.getExtraDesc());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
