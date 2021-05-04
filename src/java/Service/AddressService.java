package Service;

import Model.Addresses;
import Repository.AddressRepo;

public class AddressService {
    public static String addNewAddress(Addresses ad) {
        if (ad.getHousenumber() > 0 && ad.getCityid() > 0 && ad.getStreetid() > 0) {
            if (AddressRepo.addNewAddress(ad)) {
                return "A cím rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés sikertelen";
            }
        }
        else {
            return "Az adatok nem megfelelőek - Address";
        }
    }
    
    public static Addresses checkAddress(Integer house, Integer city, Integer street) {
        return AddressRepo.checkAddress(house, city, street);
    }
}
