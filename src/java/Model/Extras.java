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
@Table(name = "extras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extras.findAll", query = "SELECT e FROM Extras e"),
    @NamedQuery(name = "Extras.findByExtraid", query = "SELECT e FROM Extras e WHERE e.extraid = :extraid"),
    @NamedQuery(name = "Extras.findByExtraname", query = "SELECT e FROM Extras e WHERE e.extraname = :extraname"),
    @NamedQuery(name = "Extras.findByExtradesc", query = "SELECT e FROM Extras e WHERE e.extradesc = :extradesc")})
public class Extras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Extra_id")
    private Integer extraid;
    @Basic(optional = false)
    @Column(name = "Extra_name")
    private String extraname;
    @Basic(optional = false)
    @Column(name = "Extra_desc")
    private String extradesc;

    public Extras() {
    }

    public Extras(Integer extraId) {
        this.extraid = extraid;
    }

    public Extras(Integer extraid, String extraname, String extradesc) {
        this.extraid = extraid;
        this.extraname = extraname;
        this.extradesc = extradesc;
    }
    
    public static Extras getExtrasById(int id) {
        EntityManager em = Database.getDbConn();
        return em.find(Extras.class, id);
    }

    public Integer getExtraId() {
        return extraid;
    }

    public void setExtraId(Integer extraid) {
        this.extraid = extraid;
    }

    public String getExtraName() {
        return extraname;
    }

    public void setExtraName(String extraname) {
        this.extraname = extraname;
    }

    public String getExtraDesc() {
        return extradesc;
    }

    public void setExtraDesc(String extradesc) {
        this.extradesc = extradesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (extraid != null ? extraid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extras)) {
            return false;
        }
        Extras other = (Extras) object;
        if ((this.extraid == null && other.extraid != null) || (this.extraid != null && !this.extraid.equals(other.extraid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Extras[ extraid=" + extraid + " ]";
    }
    
}
