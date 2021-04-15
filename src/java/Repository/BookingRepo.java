package Repository;

import Model.Database;
import Model.Bookings;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class BookingRepo {
    public static boolean addNewBooking(Bookings bo) {
        try {
            EntityManager em = Database.getDbConn();
            
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewBooking");
            
            spq.registerStoredProcedureParameter("bookingDateIN", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("arrivalIN", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("leaveIN", Date.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("noGuestsIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("guestIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("servicesIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("statusIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("roomIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("bookingDateIN", bo.getBookingdate());
            spq.setParameter("arrivalIN", bo.getArrivaldate());
            spq.setParameter("leaveIN", bo.getLeavedate());
            spq.setParameter("noGuestsIN", bo.getNumberofguests());
            spq.setParameter("guestIN", bo.getGuestid());
            spq.setParameter("servicesIN", bo.getServicesid());
            spq.setParameter("statusIN", bo.getBookingstatusid());
            spq.setParameter("roomIN", bo.getRoomid());
            
            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
