/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ln1878
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="STAFF_TYPE")
@NamedQueries({
    @NamedQuery(name="Staff.findByName",query="select p from Staff p where p.name= :name"),
    @NamedQuery(name = "Staff.findAll", query = "select r from Staff r")
})
public abstract class Staff extends BaseEntity implements Serializable {
        
    @Temporal(TemporalType.DATE)
    private Date joinDate;
    @Embedded
    private Name name;
    
    /**
     *  Constructor
     */
    public Staff() {
        name = new Name();
    }
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param joinDate
     */
    public Staff(String firstName, String lastName,Date joinDate) {
        this.joinDate = joinDate;
        name = new Name();
        name.setFirstName(firstName);
        name.setLastName(lastName);
    }
        
    /**
     * Get the value of joinDate
     *
     * @return the value of joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * Set the value of joinDate
     *
     * @param joinDate new value of joinDate
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return name.getLastName();
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        name.setLastName(lastName);
    }

    

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return name.getFirstName();
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        name.setFirstName(firstName);
    }

    @Override
    public String toString() {
        return "Staff{" + "joinDate=" + joinDate + ", name=" + name.toString() + '}';
    }
    



}
