package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "room_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomStatus.findAll", query = "SELECT r FROM RoomStatus r"),
    @NamedQuery(name = "RoomStatus.findByRoomstatusid", query = "SELECT r FROM RoomStatus r WHERE r.roomstatusid = :roomstatusid"),
    @NamedQuery(name = "RoomStatus.findByStatus", query = "SELECT r FROM RoomStatus r WHERE r.status = :status")})
public class RoomStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Room_status_id")
    private Integer roomstatusid;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public RoomStatus() {
    }

    public RoomStatus(Integer roomstatusid) {
        this.roomstatusid = roomstatusid;
    }

    public RoomStatus(Integer roomstatusid, String status) {
        this.roomstatusid = roomstatusid;
        this.status = status;
    }

    public Integer getRoomStatusId() {
        return roomstatusid;
    }

    public void setRoomStatusId(Integer roomstatusid) {
        this.roomstatusid = roomstatusid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomstatusid != null ? roomstatusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomStatus)) {
            return false;
        }
        RoomStatus other = (RoomStatus) object;
        if ((this.roomstatusid == null && other.roomstatusid != null) || (this.roomstatusid != null && !this.roomstatusid.equals(other.roomstatusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.RoomStatus[ roomstatusid=" + roomstatusid + " ]";
    }
    
}
