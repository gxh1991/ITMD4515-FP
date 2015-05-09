/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ln1878
 */
@Entity
@Table(name = "Owner")
@NamedQueries({
    @NamedQuery(name="PetOwner.findByName",query="select p from PetOwner p where p.name= :name"),
    @NamedQuery(name="PetOwner.findById",query="select p from PetOwner p where p.id= :id"),
    @NamedQuery(name = "PetOwner.findAll", query = "select r from PetOwner r"),
    @NamedQuery(name="PetOwner.findByUsername",query="select p from PetOwner p where p.user.userName=:username")
})
public class PetOwner extends BaseEntity implements Serializable{   
    
    private String name;
    private String phone;
    private String address;
    
    @OneToMany(mappedBy = "petOwner")
    private List<Pet> pets = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    @OneToMany
    @JoinColumn(name="PETOWNER_ID",referencedColumnName = "ID")
    private List<Reservation> reservations = new ArrayList<>();
    
    /**
     *  Constructor
     */
    public PetOwner() {
    }
     /**
    * Constructor.
    * 
    * @param name value of name
    * @param phone value of phone
    * @param address value of address
    */   
    public PetOwner(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
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
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    } 

    /**
     *
     * @return the value of phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return value of address 
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return list of pets
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     *
     * @param pets
     */
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
    /**
     *
     * @param p
     */
    public void addPet(Pet p) {
        if(!pets.contains(p)) {
            pets.add(p);
        }
    }

    /**
     *
     * @return
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

    /**
     *
     * @return
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    

    @Override
    public String toString() {
        return "PetOwner{" + "name=" + name + ", phone=" + phone + ", address=" + address + '}';
    }
    
    
    
}
