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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author szepma
 */
@Entity
@Table(name = "streets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Streets.findAll", query = "SELECT s FROM Streets s"),
    @NamedQuery(name = "Streets.findByStreetid", query = "SELECT s FROM Streets s WHERE s.streetid = :streetid"),
    @NamedQuery(name = "Streets.findByStreetname", query = "SELECT s FROM Streets s WHERE s.streetname = :streetname"),
    @NamedQuery(name = "Streets.findByZipcodeid", query = "SELECT s FROM Streets s WHERE s.zipcodeid = :zipcodeid")})
public class Streets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Street_id")
    private Integer streetid;
    @Basic(optional = false)
    @Column(name = "Street_name")
    private String streetname;
    @Basic(optional = false)
    @Column(name = "Zipcode_id")
    private int zipcodeid;

    public Streets() {
    }

    public Streets(Integer streetid) {
        this.streetid = streetid;
    }

    public Streets(Integer streetid, String streetname, int zipcodeid) {
        this.streetid = streetid;
        this.streetname = streetname;
        this.zipcodeid = zipcodeid;
    }
    
    public static Streets getStreetById(int id) {
        EntityManager em = Database.getDbConn();
        return em.find(Streets.class, id);
    }

    public Integer getStreetid() {
        return streetid;
    }

    public void setStreetid(Integer streetid) {
        this.streetid = streetid;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public int getZipcodeid() {
        return zipcodeid;
    }

    public void setZipcodeid(int zipcodeid) {
        this.zipcodeid = zipcodeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (streetid != null ? streetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Streets)) {
            return false;
        }
        Streets other = (Streets) object;
        if ((this.streetid == null && other.streetid != null) || (this.streetid != null && !this.streetid.equals(other.streetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Streets[ streetid=" + streetid + " ]";
    }
    
}
