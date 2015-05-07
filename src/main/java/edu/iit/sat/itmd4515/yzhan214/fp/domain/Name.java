/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ln1878
 */
@Embeddable
public class Name implements Serializable {
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;

    /**
     *
     * @return the value of first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return the value of last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName; //To change body of generated methods, choose Tools | Templates.
    }
}
