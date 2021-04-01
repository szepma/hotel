package Service;

import Model.RoomStatus;
import Repository.RoomStatusRepo;

public class RoomStatusService {
    public static String addNewRoomStatus(RoomStatus rs) {
        if (rs.getStatus().length() > 0 && rs.getStatus().length() < 45) {
            if (RoomStatusRepo.addNewRoomStatus(rs)) {
                return "A szoba státusz rögzítése sikeresen megtörtént";
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
