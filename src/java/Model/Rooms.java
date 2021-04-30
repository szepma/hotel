/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONObject;

/**
 *
 * @author szepma
 */
@Entity
@Table(name = "rooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findByRoomid", query = "SELECT r FROM Rooms r WHERE r.roomid = :roomid"),
    @NamedQuery(name = "Rooms.findByCapacity", query = "SELECT r FROM Rooms r WHERE r.capacity = :capacity"),
    @NamedQuery(name = "Rooms.findByRoomStatusId", query = "SELECT r FROM Rooms r WHERE r.roomStatusId = :roomStatusId"),
    @NamedQuery(name = "Rooms.findByExtraId", query = "SELECT r FROM Rooms r WHERE r.extraId = :extraId"),
    @NamedQuery(name = "Rooms.findByPrice", query = "SELECT r FROM Rooms r WHERE r.price = :price"),
    @NamedQuery(name = "Rooms.findByPicture", query = "SELECT r FROM Rooms r WHERE r.picture = :picture")})
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Room_id")
    private Integer roomid;
    @Basic(optional = false)
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @Column(name = "room_status_id")
    private int roomStatusId;
    @Basic(optional = false)
    @Column(name = "extra_id")
    private int extraId;
    @Basic(optional = false)
    @Column(name = "Price")
    private int price;
    @Basic(optional = false)
    @Column(name = "Picture")
    private String picture;
    @Basic(optional = false)
    @Lob
    @Column(name = "Description")
    private String description;

    public Rooms() {
    }

    public Rooms(Integer roomid) {
        this.roomid = roomid;
    }

    public Rooms(Integer roomid, int capacity, int roomStatusId, int extraId, int price, String picture, String description) {
        this.roomid = roomid;
        this.capacity = capacity;
        this.roomStatusId = roomStatusId;
        this.extraId = extraId;
        this.price = price;
        this.picture = picture;
        this.description = description;
    }

    public JSONObject toJson() {
        JSONObject object = new JSONObject();
        object.put("roomid", this.roomid);
        object.put("capacity", this.capacity);
        object.put("roomStatusId", this.roomStatusId);
        object.put("extra", Extras.getExtrasById(this.extraId).getExtraName());
        object.put("price", this.price);
        object.put("picture", this.picture);
        object.put("description", this.description);
        
        return object;
    }

    public static Rooms getRoomsById(int id) {
        EntityManager em = Database.getDbConn();
        return em.find(Rooms.class, id);
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public int getRoomStatusId() {
        return roomStatusId;
    }

    public void setRoomStatusId(int roomStatusId) {
        this.roomStatusId = roomStatusId;
    }

    public int getExtraId() {
        return extraId;
    }

    public void setExtraId(int extraId) {
        this.extraId = extraId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomid != null ? roomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomid == null && other.roomid != null) || (this.roomid != null && !this.roomid.equals(other.roomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Rooms[ roomid=" + roomid + " ]";
    }

}
