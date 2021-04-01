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
@Table(name = "zipcodes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zipcodes.findAll", query = "SELECT z FROM Zipcodes z"),
    @NamedQuery(name = "Zipcodes.findByZipcodeid", query = "SELECT z FROM Zipcodes z WHERE z.zipcodeid = :zipcodeid"),
    @NamedQuery(name = "Zipcodes.findByZipcode", query = "SELECT z FROM Zipcodes z WHERE z.zipcode = :zipcode")})
public class Zipcodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Zipcode_id")
    private Integer zipcodeid;
    @Basic(optional = false)
    @Column(name = "zipcode")
    private String zipcode;

    public Zipcodes() {
    }

    public Zipcodes(Integer zipcodeid) {
        this.zipcodeid = zipcodeid;
    }

    public Zipcodes(Integer zipcodeid, String zipcode) {
        this.zipcodeid = zipcodeid;
        this.zipcode = zipcode;
    }

    public Integer getZipcodeid() {
        return zipcodeid;
    }

    public void setZipcodeid(Integer zipcodeid) {
        this.zipcodeid = zipcodeid;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipcodeid != null ? zipcodeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zipcodes)) {
            return false;
        }
        Zipcodes other = (Zipcodes) object;
        if ((this.zipcodeid == null && other.zipcodeid != null) || (this.zipcodeid != null && !this.zipcodeid.equals(other.zipcodeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Zipcodes[ zipcodeid=" + zipcodeid + " ]";
    }
    
}
