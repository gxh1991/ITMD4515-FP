/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ln1878
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Hospital.findById",query="select r from Hospital r where r.id= :id"),
    @NamedQuery(name="Hospital.findByName",query="select r from Hospital r where r.name= :name"),
    @NamedQuery(name = "Hospital.findAll", query = "select r from Hospital r")
})
public class Hospital extends BaseEntity implements Serializable {
    
    private String name;
    
    @OneToMany(mappedBy="hospital")
    private List<VetAssistant> vas = new ArrayList<>();
    
    
    @ManyToMany(mappedBy = "hospitals")
    private List<Doctor> docs = new ArrayList<>();
    
    @OneToMany
    @JoinColumn(name="HOSPITAL_ID",referencedColumnName = "ID")
    private List<Reservation> reservations = new ArrayList<>();    

    /**
     *  Constructor
     */
    public Hospital() {
    }
    /**
    * Constructor.
    * 
    * @param name value of name
    */
    public Hospital(String name) {
        this.name = name;
    }
    
    
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     *
     * @param vas
     */
    public void setVas(List<VetAssistant> vas) {
        this.vas = vas;
    }
    
    /**
     *
     * @return
     */
    public List<VetAssistant> getVas() {
        return vas;
    }
    
        /**
     * Get the value of doctor
     *
     * @return the value of doctor
     */
    public List<Doctor> getDocs() {
        return docs;
    }

    /**
     * Set the value of doctor
     *
     * @param docs new value of doctor
     */
    public void setDocs(List<Doctor> docs) {
        this.docs = docs;
    }
    
    /**
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    
    /**
     *
     * @param re
     */
    public void addReservation(Reservation re) {
        if(!reservations.contains(re)) {
            reservations.add(re);
        }
    }

    @Override
    public String toString() {
        return "Hospital{" + "name=" + name + '}';
    }



    
    
    
}
