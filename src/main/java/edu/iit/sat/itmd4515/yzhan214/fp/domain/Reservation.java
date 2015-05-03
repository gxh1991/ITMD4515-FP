/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ln1878
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Reservation.findById",query="select p from Reservation p where p.id= :id"),
    @NamedQuery(name = "Reservation.findAll", query = "select r from Reservation r")
        
})
public class Reservation extends BaseEntity implements Serializable{
    
    @Temporal(TemporalType.DATE)
    private Date rDate;
    private String description;
    @Enumerated(EnumType.STRING)
    ReservationStatus rs;
    @ManyToOne
    @JoinColumn(name="DOCTOR_ID")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name="PETOWNER_ID")
    private PetOwner petOwner;

    /**
    * Constructor.
    * 
    * @param rDate (optional) Date of reservation 
    * @param description (optional) description of the reservation.
    * 
    */
    public Reservation(Date rDate, String description) {
        this.rDate = rDate;
        this.description = description;
        rs = ReservationStatus.Active;
    }

    public Reservation() {
    }
    
    
    
    
    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public ReservationStatus getRs() {
        return rs;
    }

    public void setRs(ReservationStatus rs) {
        this.rs = rs;
    }

    @Override
    public String toString() {
        return "Reservation{" + "rDate=" + rDate + ", description=" + description + ", rs=" + rs + '}';
    }
    
}
