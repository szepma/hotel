package Service;

import Model.Streets;
import Repository.StreetRepo;

public class StreetService {
    public static String addNewStreet(Streets st) {
        if (st.getStreetname().length() > 0 && st.getZipcodeid() > 0) {
            if (StreetRepo.addNewStreet(st)) {
                return "Az utca rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés sikertelen";
            }
        }
        else {
            return "Helytelen adatok";
        }
    }
    
    public static Streets checkStreet(String streetName) {
        return StreetRepo.checkStreet(streetName);
    }
}
