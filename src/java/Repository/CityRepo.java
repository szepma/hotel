package Repository;

import Model.Database;
import Model.Cities;
import java.util.List;
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
    
    public static Cities checkCity(String cityName) {
        Cities result = new Cities(-1, cityName);
        try {
            EntityManager em = Database.getDbConn();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("checkCity");
            
            spq.registerStoredProcedureParameter("cityIN", String.class, ParameterMode.IN);
            spq.setParameter("cityIN", cityName);
            
            List<Object[]> cityList = spq.getResultList();
            for (Object[] current : cityList) {
                int id = Integer.parseInt(current[0].toString());
                result = result.getCityById(id);
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
