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
@Table(name = "addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a"),
    @NamedQuery(name = "Addresses.findByAddressid", query = "SELECT a FROM Addresses a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Addresses.findByHousenumber", query = "SELECT a FROM Addresses a WHERE a.housenumber = :housenumber"),
    @NamedQuery(name = "Addresses.findByCityid", query = "SELECT a FROM Addresses a WHERE a.cityid = :cityid"),
    @NamedQuery(name = "Addresses.findByStreetid", query = "SELECT a FROM Addresses a WHERE a.streetid = :streetid")})
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Address_id")
    private Integer addressid;
    @Basic(optional = false)
    @Column(name = "House_number")
    private int housenumber;
    @Basic(optional = false)
    @Column(name = "City_id")
    private int cityid;
    @Basic(optional = false)
    @Column(name = "Street_id")
    private int streetid;

    public Addresses() {
    }

    public Addresses(Integer addressid) {
        this.addressid = addressid;
    }

    public Addresses(Integer addressid, int housenumber, int cityid, int streetid) {
        this.addressid = addressid;
        this.housenumber = housenumber;
        this.cityid = cityid;
        this.streetid = streetid;
    }
    
    public static Addresses getAddressById(int id) {
        return Database.getDbConn().find(Addresses.class, id);
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getStreetid() {
        return streetid;
    }

    public void setStreetid(int streetid) {
        this.streetid = streetid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Addresses[ addressid=" + addressid + " ]";
    }
    
}
