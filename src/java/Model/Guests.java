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
@Table(name = "guests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guests.findAll", query = "SELECT g FROM Guests g"),
    @NamedQuery(name = "Guests.findByGuestid", query = "SELECT g FROM Guests g WHERE g.guestid = :guestid"),
    @NamedQuery(name = "Guests.findByFirstname", query = "SELECT g FROM Guests g WHERE g.firstname = :firstname"),
    @NamedQuery(name = "Guests.findByLastname", query = "SELECT g FROM Guests g WHERE g.lastname = :lastname"),
    @NamedQuery(name = "Guests.findByEmail", query = "SELECT g FROM Guests g WHERE g.email = :email"),
    @NamedQuery(name = "Guests.findByMobile", query = "SELECT g FROM Guests g WHERE g.mobile = :mobile"),
    @NamedQuery(name = "Guests.findByAddressid", query = "SELECT g FROM Guests g WHERE g.addressid = :addressid")})
public class Guests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Guest_id")
    private Integer guestid;
    @Basic(optional = false)
    @Column(name = "Firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "Lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Mobile")
    private String mobile;
    @Basic(optional = false)
    @Column(name = "Address_id")
    private int addressid;

    public Guests() {
    }

    public Guests(Integer guestid) {
        this.guestid = guestid;
    }

    public Guests(Integer guestid, String firstname, String lastname, String email, String mobile, int addressid) {
        this.guestid = guestid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.addressid = addressid;
    }
    
    public static Guests getGuestById(int id) {
        return Database.getDbConn().find(Guests.class, id);
    }
    
    public Integer getGuestid() {
        return guestid;
    }

    public void setGuestid(Integer guestid) {
        this.guestid = guestid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestid != null ? guestid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guests)) {
            return false;
        }
        Guests other = (Guests) object;
        if ((this.guestid == null && other.guestid != null) || (this.guestid != null && !this.guestid.equals(other.guestid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Guests[ guestid=" + guestid + " ]";
    }
    
}
