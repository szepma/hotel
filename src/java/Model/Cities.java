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
@Table(name = "cities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findByCityid", query = "SELECT c FROM Cities c WHERE c.cityid = :cityid"),
    @NamedQuery(name = "Cities.findByCityname", query = "SELECT c FROM Cities c WHERE c.cityname = :cityname")})
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "City_id")
    private Integer cityid;
    @Basic(optional = false)
    @Column(name = "City_name")
    private String cityname;

    public Cities() {
    }

    public Cities(Integer cityid) {
        this.cityid = cityid;
    }

    public Cities(Integer cityid, String cityname) {
        this.cityid = cityid;
        this.cityname = cityname;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityid != null ? cityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Cities[ cityid=" + cityid + " ]";
    }
    
}
