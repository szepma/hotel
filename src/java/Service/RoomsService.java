package Service;

import Model.Rooms;
import Repository.RoomsRepo;
import java.util.List;

public class RoomsService {
    public static String addNewRoom(Rooms room) {
        if (room.getCapacity() > 0 && room.getRoomStatusId() > 0 && room.getExtraId() > 0 && room.getPrice() > 0 && room.getPicture().length() > 0 && room.getDescription().length() > 0) {
            if (RoomsRepo.addNewRoom(room)) {
                return "Az új szoba rögzítése sikeresen megtörtént";
            }
            else {
                return "Az adatok helyesek, de a rögzítés nem sikerült";
            }
        }
        else {
            return "A megadott adatok helytelenek";
        }
    }
    
    public static String updateRoomStatusById(Rooms room) {
        if (RoomsRepo.updateRoomStatusById(room)) {
            return "A szobastátusz módosítása sikeresen megtörtént";
        }
        else {
            return "A módosítás sikertelen";
        }
    }
    
    public static List<Rooms> getAllRooms() {
        return RoomsRepo.getAllRooms();
    }
}
