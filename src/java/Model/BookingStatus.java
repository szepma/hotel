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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author szepma
 */
@Entity
@Table(name = "booking_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingStatus.findAll", query = "SELECT b FROM BookingStatus b"),
    @NamedQuery(name = "BookingStatus.findByBookingstatusid", query = "SELECT b FROM BookingStatus b WHERE b.bookingstatusid = :bookingstatusid"),
    @NamedQuery(name = "BookingStatus.findByStatus", query = "SELECT b FROM BookingStatus b WHERE b.status = :status")})
public class BookingStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Booking_status_id")
    private Integer bookingstatusid;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public BookingStatus() {
    }

    public BookingStatus(Integer bookingstatusid) {
        this.bookingstatusid = bookingstatusid;
    }

    public BookingStatus(Integer bookingstatusid, String status) {
        this.bookingstatusid = bookingstatusid;
        this.status = status;
    }

    public Integer getBookingstatusid() {
        return bookingstatusid;
    }

    public void setBookingstatusid(Integer bookingstatusid) {
        this.bookingstatusid = bookingstatusid;
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
        hash += (bookingstatusid != null ? bookingstatusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingStatus)) {
            return false;
        }
        BookingStatus other = (BookingStatus) object;
        if ((this.bookingstatusid == null && other.bookingstatusid != null) || (this.bookingstatusid != null && !this.bookingstatusid.equals(other.bookingstatusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.BookingStatus[ bookingstatusid=" + bookingstatusid + " ]";
    }
    
}
