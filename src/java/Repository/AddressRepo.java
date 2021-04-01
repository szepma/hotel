package Repository;

import Model.Database;
import Model.Addresses;
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
}
