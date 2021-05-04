package Service;

import Model.Bookings;
import Repository.BookingRepo;

public class BookingService {
    public static String addNewBooking(Bookings bo) {
        if (bo.getNumberofguests() > 0 && bo.getGuestid() > 0 && bo.getServicesid() > 0 && bo.getServicesid() > 0 && bo.getBookingstatusid() > 0 && bo.getRoomid() > 0) {
            if (BookingRepo.addNewBooking(bo)) {
                return "A foglalás rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés sikertelen";
            }
        }
        else {
            return "Az adatok nem megfelelőek - Booking";
        }
    }
    
    public static String updateBookingStatusById(Bookings bo) {
        if (BookingRepo.updateBookingStatusById(bo)) {
            return "A foglalás státuszának módosítása sikeresen megtörtént";
        }
        else {
            return "A módosítás siertelen";
        }
    }
}
