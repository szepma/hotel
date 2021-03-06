package Repository;

import Model.Database;
import Model.Guests;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

public class GuestRepo {

    public static boolean addNewGuest(Guests gu) {
        try {
            EntityManager em = Database.getDbConn();

            StoredProcedureQuery spq = em.createStoredProcedureQuery("addNewGuest");

            spq.registerStoredProcedureParameter("firstnameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("lastnameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("mobileIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("addressIN", Integer.class, ParameterMode.IN);

            spq.setParameter("firstnameIN", gu.getFirstname());
            spq.setParameter("lastnameIN", gu.getLastname());
            spq.setParameter("emailIN", gu.getEmail());
            spq.setParameter("mobileIN", gu.getMobile());
            spq.setParameter("addressIN", gu.getAddressid());

            spq.execute();
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static Guests checkGuest(String email) {
        Guests result = new Guests(-1, null, null, email, null, -1);
        try {
            EntityManager em = Database.getDbConn();
            StoredProcedureQuery spq = em.createStoredProcedureQuery("checkGuest");

            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.setParameter("emailIN", email);

            List<Object[]> guestList = spq.getResultList();
            for (Object[] current : guestList) {
                int id = Integer.parseInt(current[0].toString());
                result = result.getGuestById(id);
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
