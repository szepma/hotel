package Service;

import Model.Extras;
import Repository.ExtraRepo;

public class ExtrasService {
    public static String addNewExtra(Extras extra) {
        if (extra.getExtraName().length() < 45 && extra.getExtraName().length() > 0 && extra.getExtraDesc().length() < 45 && extra.getExtraDesc().length() > 0) {
            if (ExtraRepo.addNewExtra(extra)) {
                return "Az extra rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés nem sikerült";
            }
        }
        else {
            return "A név és a leírás hossza 1 és 45 közé kell, hogy essen";
        }
    }
    
}
