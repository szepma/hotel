package Repository;

import Model.Database;
import Model.Rooms;
import java.util.ArrayList;
import java.util.List;
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
            spq.registerStoredProcedureParameter("priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("pictureIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("descIN", String.class, ParameterMode.IN);
            
            spq.setParameter("capacityIN", room.getCapacity());
            spq.setParameter("room_statusIN", room.getRoomStatusId());
            spq.setParameter("extraIN", room.getExtraId());
            spq.setParameter("priceIN", room.getPrice());
            spq.setParameter("pictureIN", room.getPicture());
            spq.setParameter("descIN", room.getDescription());
            
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
    
    public static List<Rooms> getAllRooms() {
        List<Rooms> result = new ArrayList<>();
        
        try {
            EntityManager em = Database.getDbConn();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllRooms");
            
            List<Object[]> rooms = spq.getResultList();
            for (Object[] room : rooms) {
                int id = Integer.parseInt(room[0].toString());
                Rooms r = em.find(Rooms.class, id);
                result.add(r);
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
