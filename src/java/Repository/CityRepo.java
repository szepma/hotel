package Repository;

import Model.Database;
import Model.Cities;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class CityRepo {
    public static boolean addNewCity(Cities city) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewCity");
            
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
            
            spq.setParameter("nameIN", city.getCityname());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
