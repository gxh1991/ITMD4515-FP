/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ln1878
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Pet.findByName",query="select r from Pet r where r.name= :name"),
    @NamedQuery(name="Pet.findById",query="select r from Pet r where r.id= :id"),
    @NamedQuery(name = "Pet.findAll", query = "select r from Pet r"),
})
public class Pet extends BaseEntity implements Serializable{
   
    private String name;
    @Enumerated(EnumType.STRING)
    PetClass petClass;
    @ManyToOne
    private PetOwner petOwner;

    /**
     *  Constructor
     */
    public Pet() {
    }
    /**
    * Constructor.
    * 
    * @param name value of name
    * @param petClass value of pet class
    */
    public Pet(String name, PetClass petClass) {
        this.name = name;
        this.petClass = petClass;
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
     * @return the value of pet class
     */
    public PetClass getPetClass() {
        return petClass;
    }

    /**
     *
     * @param petClass
     */
    public void setPetClass(PetClass petClass) {
        this.petClass = petClass;
    }
    
    /**
     *
     * @param petClass
     */
    public void setPetClass(String petClass) {
        this.petClass = PetClass.valueOf(petClass);
    }    

    /**
     *
     * @return return the value of pet owner
     */
    public PetOwner getPetOwner() {
        return petOwner;
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
        return "Pet{" + "name=" + name + ", petClass=" + petClass + ", petOwner=" + petOwner + '}';
    }
    
}
