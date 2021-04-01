package Repository;

import Model.Database;
import Model.RoomStatus;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class RoomStatusRepo {
    public static boolean addNewRoomStatus(RoomStatus rs) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewRoomStatus");
            
            spq.registerStoredProcedureParameter("statusIN", String.class, ParameterMode.IN);
            
            spq.setParameter("statusIN", rs.getStatus());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    } 
}
