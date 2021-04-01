package Service;

import Model.BookingStatus;
import Repository.BookingStatusRepo;

public class BookingStatusService {
    public static String addNewBookingStatus(BookingStatus bs) {
        if (bs.getStatus().length() > 0 && bs.getStatus().length() < 45) {
            if (BookingStatusRepo.addNewBookingStatus(bs)) {
                return "A foglalás státusz sikeresen rögzítésre került";
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
