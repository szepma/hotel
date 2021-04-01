package Service;

import Model.Services;
import Repository.ServicesRepo;

public class ServicesService {
    public static String addNewService(Services ser) {
        if (ser.getServicename().length() > 0 && ser.getServicename().length() < 45) {
            if (ServicesRepo.addNewService(ser)) {
                return "A szolgáltatás rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés nem sikerült";
            }
        }
        else {
            return "A leírás hossza 1 és 45 karakter közé kell, hogy essen";
        }

    }
}
