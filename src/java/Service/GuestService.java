package Service;

import Model.Guests;
import Repository.GuestRepo;

public class GuestService {
    public static String addNewGuest(Guests gu) {
        if (gu.getFirstname().length() > 0 && gu.getFirstname().length() < 50 &&
                gu.getLastname().length() > 0 && gu.getLastname().length() < 50 &&
                gu.getEmail().length() > 0 && gu.getEmail().length() < 256 &&
                gu.getMobile().length() > 0 && gu.getMobile().length() < 13 &&
                gu.getAddressid() > 0) {
            if (GuestRepo.addNewGuest(gu)) {
                return "A vendég rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés sikertelen";
            }
        }
        else {
            return "Az adatok nem megfelelőek";
        }
    }
}
