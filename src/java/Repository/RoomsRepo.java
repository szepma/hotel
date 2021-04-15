package Repository;

import Model.Database;
import Model.Rooms;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class RoomsRepo {
    public static boolean addNewRoom(Rooms room) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewRoom");
            
            spq.registerStoredProcedureParameter("capacityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("room_statusIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("extraIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("capacityIN", room.getCapacity());
            spq.setParameter("room_statusIN", room.getRoomStatusId());
            spq.setParameter("extraIN", room.getExtraId());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean updateRoomStatusById(Rooms room) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateRoomStatusById");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("statusIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("idIN", room.getRoomid());
            spq.setParameter("statusIN", room.getRoomStatusId());
            
            spq.execute();
            return true;
            
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
