package Repository;

import Model.Database;
import Model.BookingStatus;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class BookingStatusRepo {
    public static boolean addNewBookingStatus(BookingStatus bs) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewBookingStatus");
            
            spq.registerStoredProcedureParameter("statusIN", String.class, ParameterMode.IN);
            
            spq.setParameter("statusIN", bs.getStatus());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
