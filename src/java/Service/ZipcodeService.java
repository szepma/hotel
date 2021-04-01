package Service;

import Model.Zipcodes;
import Repository.ZipcodeRepo;

public class ZipcodeService {
    public static String addNewZipcode(Zipcodes zip) {
        if (zip.getZipcode().length() > 0 && zip.getZipcode().length() < 6) {
            if (ZipcodeRepo.addNewZipcode(zip)) {
                return "Az irányítószám rögzítésre került";
            }
            else {
                return "Az adatok helyesek, de a rögzítés nem sikerült";
            }
        }
        else {
            return "Az irányítószám hosszának 0 és 6 közé kell esnie";
        }
    }
}
