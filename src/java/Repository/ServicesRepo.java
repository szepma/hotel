package Repository;

import Model.Database;
import Model.Services;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class ServicesRepo {
    public static boolean addNewService(Services ser) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewService");
            
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
            
            spq.setParameter("nameIN", ser.getServicename());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
