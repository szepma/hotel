package Repository;

import Model.Database;
import Model.Addresses;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class AddressRepo {
    public static boolean addNewAddress(Addresses ad) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewAddress");
            
            spq.registerStoredProcedureParameter("houseIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("cityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("streetIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("houseIN", ad.getHousenumber());
            spq.setParameter("cityIN", ad.getCityid());
            spq.setParameter("streetIN", ad.getStreetid());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Addresses checkAddress(Integer house, Integer city, Integer street) {
        Addresses result = new Addresses(-1, house, city, street);
        try {
            EntityManager em = Database.getDbConn();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("checkAddress");
            
            spq.registerStoredProcedureParameter("houseIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("cityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("streetIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("houseIN", house);
            spq.setParameter("cityIN", city);
            spq.setParameter("streetIN", street);
            
            List<Object[]> addressList = spq.getResultList();
            for (Object[] current : addressList) {
                int id = Integer.parseInt(current[0].toString());
                result = result.getAddressById(id);
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
