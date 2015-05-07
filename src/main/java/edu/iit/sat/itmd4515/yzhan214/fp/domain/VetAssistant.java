/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ln1878
 */
@Entity
@Table(name="Assistant")
@DiscriminatorValue("VA")
@NamedQueries({
    @NamedQuery(name="VetAssistant.findById",query="select p from VetAssistant p where p.id= :id"),
    @NamedQuery(name = "VetAssistant.findAll", query = "select r from VetAssistant r"),
    @NamedQuery(name="VetAssistant.findByUsername",query="select v from VetAssistant v where v.user.userName=:username")
})
public class VetAssistant extends Staff implements Serializable{
    
    private String address;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "HOSPITAL_ID")
    private Hospital hospital;
    
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;
    
    /**
     *  Constructor
     */
    public VetAssistant() {
    }
     /**
    * Constructor.
    * 
    * @param firstname value of first name
    * @param lastname value of last name
    * @param joinDate value of join date
    * @param address value of address
    * @param phone value of phone number
    */  
    public VetAssistant(String firstname,String lastname,Date joinDate,String address, String phone) {
        super(firstname,lastname,joinDate);
        this.address = address;
        this.phone = phone;
    }
    
    /**
     *
     * @return the instance of assistant's hospital
     */
    public Hospital getHospital() {
        return hospital;
    }
    
    /**
     *
     * @param hospital
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
    
    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    

    /**
     * Get the value of phone
     *
     * @return the value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value of phone
     *
     * @param phone new value of phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return the assistant's user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    

    @Override
    public String toString() {
        return "VetAssistant{" + super.toString()+"address=" + address + ", phone=" + phone +", hospital=" + hospital + '}';
    }
    
    

}
