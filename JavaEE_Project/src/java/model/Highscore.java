/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomas
 */
@Entity
@Table(name = "Highscore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Highscore.findAll", query = "SELECT h FROM Highscore h"),
    @NamedQuery(name = "Highscore.findById", query = "SELECT h FROM Highscore h WHERE h.id = :id"),
    @NamedQuery(name = "Highscore.findByName", query = "SELECT h FROM Highscore h WHERE h.name = :name"),
    @NamedQuery(name = "Highscore.findByPoints", query = "SELECT h FROM Highscore h WHERE h.points = :points"),
    @NamedQuery(name = "Highscore.findByTimestamp", query = "SELECT h FROM Highscore h WHERE h.timestamp = :timestamp")})
public class Highscore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Points")
    private int points;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Timestamp")
    @Temporal(TemporalType.DATE)
    private Date timestamp;

    public Highscore() {
    }

    public Highscore(Integer id) {
        this.id = id;
    }

    public Highscore(Integer id, String name, int points, Date timestamp) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Highscore)) {
            return false;
        }
        Highscore other = (Highscore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Highscore[ id=" + id + " ]";
    }
    
}
