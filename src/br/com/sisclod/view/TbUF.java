/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 *
 * @author rootux
 */
@Entity
@Table(name = "tbUF", catalog = "sisclod", schema = "")
@NamedQueries({
    @NamedQuery(name = "TbUF.findAll", query = "SELECT t FROM TbUF t"),
    @NamedQuery(name = "TbUF.findByIdUF", query = "SELECT t FROM TbUF t WHERE t.idUF = :idUF"),
    @NamedQuery(name = "TbUF.findByNoUF", query = "SELECT t FROM TbUF t WHERE t.noUF = :noUF"),
    @NamedQuery(name = "TbUF.findBySgUF", query = "SELECT t FROM TbUF t WHERE t.sgUF = :sgUF")})
public class TbUF implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUF")
    private Integer idUF;
    @Basic(optional = false)
    @Column(name = "noUF")
    private String noUF;
    @Basic(optional = false)
    @Column(name = "sgUF")
    private String sgUF;

    public TbUF() {
    }

    public TbUF(Integer idUF) {
        this.idUF = idUF;
    }

    public TbUF(Integer idUF, String noUF, String sgUF) {
        this.idUF = idUF;
        this.noUF = noUF;
        this.sgUF = sgUF;
    }

    public Integer getIdUF() {
        return idUF;
    }

    public void setIdUF(Integer idUF) {
        Integer oldIdUF = this.idUF;
        this.idUF = idUF;
        changeSupport.firePropertyChange("idUF", oldIdUF, idUF);
    }

    public String getNoUF() {
        return noUF;
    }

    public void setNoUF(String noUF) {
        String oldNoUF = this.noUF;
        this.noUF = noUF;
        changeSupport.firePropertyChange("noUF", oldNoUF, noUF);
    }

    public String getSgUF() {
        return sgUF;
    }

    public void setSgUF(String sgUF) {
        String oldSgUF = this.sgUF;
        this.sgUF = sgUF;
        changeSupport.firePropertyChange("sgUF", oldSgUF, sgUF);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUF != null ? idUF.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUF)) {
            return false;
        }
        TbUF other = (TbUF) object;
        if ((this.idUF == null && other.idUF != null) || (this.idUF != null && !this.idUF.equals(other.idUF))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sisclod.view.TbUF[ idUF=" + idUF + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
