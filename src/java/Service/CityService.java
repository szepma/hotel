package Service;

import Model.Cities;
import Repository.CityRepo;

public class CityService {
    public static String addNewCity(Cities city) {
        if (city.getCityname().length() > 0 && city.getCityname().length() < 45) {
            if (CityRepo.addNewCity(city)) {
                return "A város rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés nem sikerült";
            }
        }
        else {
            return "A városnév hossza 1 és 45 közé kell essen";
        }
    }
}
