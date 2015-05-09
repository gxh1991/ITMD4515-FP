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
    @NamedQuery(name = "Reservation.findAll", query = "select r from Reservation r"),
})
public class Reservation extends BaseEntity implements Serializable{
    
    @Temporal(TemporalType.DATE)
    private Date rDate;
    private String description;
    @Enumerated(EnumType.STRING)
    ReservationStatus rs;//    private Doctor doctor;

    @ManyToOne
    private Doctor doctor;
    
    @ManyToOne
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

    /**
     *  Constructor
     */
    public Reservation() {
    }
    
    /**
     *
     * @return the date of reservation
     */
    public Date getrDate() {
        return rDate;
    }

    /**
     *
     * @param rDate
     */
    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    /**
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     *
     * @return the value of reservation status
     */
    public ReservationStatus getRs() {
        return rs;
    }

    /**
     *
     * @param rs
     */
    public void setRs(ReservationStatus rs) {
        this.rs = rs;
    }

    /**
     *
     * @return
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     *
     * @return
     */
    public PetOwner getPetOwner() {
        return petOwner;
    }

    /**
     *
     * @param doctor
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     *
     * @param petOwner
     */
    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }
    
    

    @Override
    public String toString() {
        return "Reservation{" + "rDate=" + rDate + ", description=" + description + ", rs=" + rs + '}';
    }
    
}
