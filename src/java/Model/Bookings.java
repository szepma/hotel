/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author szepma
 */
@Entity
@Table(name = "bookings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookings.findAll", query = "SELECT b FROM Bookings b"),
    @NamedQuery(name = "Bookings.findByBookingid", query = "SELECT b FROM Bookings b WHERE b.bookingid = :bookingid"),
    @NamedQuery(name = "Bookings.findByBookingdate", query = "SELECT b FROM Bookings b WHERE b.bookingdate = :bookingdate"),
    @NamedQuery(name = "Bookings.findByArrivaldate", query = "SELECT b FROM Bookings b WHERE b.arrivaldate = :arrivaldate"),
    @NamedQuery(name = "Bookings.findByLeavedate", query = "SELECT b FROM Bookings b WHERE b.leavedate = :leavedate"),
    @NamedQuery(name = "Bookings.findByNumberofguests", query = "SELECT b FROM Bookings b WHERE b.numberofguests = :numberofguests"),
    @NamedQuery(name = "Bookings.findByGuestid", query = "SELECT b FROM Bookings b WHERE b.guestid = :guestid"),
    @NamedQuery(name = "Bookings.findByServicesid", query = "SELECT b FROM Bookings b WHERE b.servicesid = :servicesid"),
    @NamedQuery(name = "Bookings.findByBookingstatusid", query = "SELECT b FROM Bookings b WHERE b.bookingstatusid = :bookingstatusid"),
    @NamedQuery(name = "Bookings.findByRoomid", query = "SELECT b FROM Bookings b WHERE b.roomid = :roomid")})
public class Bookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Booking_id")
    private Integer bookingid;
    @Basic(optional = false)
    @Column(name = "Booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingdate;
    @Basic(optional = false)
    @Column(name = "Arrival_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivaldate;
    @Basic(optional = false)
    @Column(name = "Leave_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leavedate;
    @Basic(optional = false)
    @Column(name = "Number_of_guests")
    private int numberofguests;
    @Basic(optional = false)
    @Column(name = "Guest_id")
    private int guestid;
    @Basic(optional = false)
    @Column(name = "Services_id")
    private int servicesid;
    @Basic(optional = false)
    @Column(name = "Booking_status_id")
    private int bookingstatusid;
    @Basic(optional = false)
    @Column(name = "Room_id")
    private int roomid;

    public Bookings() {
    }

    public Bookings(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Bookings(Integer bookingid, Date bookingdate, Date arrivaldate, Date leavedate, int numberofguests, int guestid, int servicesid, int bookingstatusid, int roomid) {
        this.bookingid = bookingid;
        this.bookingdate = bookingdate;
        this.arrivaldate = arrivaldate;
        this.leavedate = leavedate;
        this.numberofguests = numberofguests;
        this.guestid = guestid;
        this.servicesid = servicesid;
        this.bookingstatusid = bookingstatusid;
        this.roomid = roomid;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Date getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(Date arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public int getNumberofguests() {
        return numberofguests;
    }

    public void setNumberofguests(int numberofguests) {
        this.numberofguests = numberofguests;
    }

    public int getGuestid() {
        return guestid;
    }

    public void setGuestid(int guestid) {
        this.guestid = guestid;
    }

    public int getServicesid() {
        return servicesid;
    }

    public void setServicesid(int servicesid) {
        this.servicesid = servicesid;
    }

    public int getBookingstatusid() {
        return bookingstatusid;
    }

    public void setBookingstatusid(int bookingstatusid) {
        this.bookingstatusid = bookingstatusid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookings)) {
            return false;
        }
        Bookings other = (Bookings) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Bookings[ bookingid=" + bookingid + " ]";
    }
    
}
