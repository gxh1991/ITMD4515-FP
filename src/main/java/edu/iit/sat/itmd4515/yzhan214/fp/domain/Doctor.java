/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ln1878
 */
@Entity
@DiscriminatorValue("DOC")
@NamedQueries({
    @NamedQuery(name="Doctor.findById",query="select r from Doctor r where r.id= :id"),
    @NamedQuery(name="Doctor.findByEmail",query="select r from Doctor r where r.email= :email"),
    @NamedQuery(name="Doctor.findByPhone",query="select r from Doctor r where r.phone= :phone"),
    @NamedQuery(name = "Doctor.findAll", query = "select r from Doctor r"),
    @NamedQuery(name = "Doctor.findByUsername",query="select d from Doctor d where d.user.userName=:username")
})
public class Doctor extends Staff implements Serializable{
    
    private String title;
    private String email;
    private String phone;
    private String profile;
    @ManyToMany
    @JoinTable(name = "hos_doc",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    private List<Hospital> hospitals = new ArrayList<>();
    
    @OneToMany
    private List<Reservation> reservations = new ArrayList<>();
    
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    public Doctor() {
    }
    /**
    * Constructor.
    * 
    * @param title value of title.Ex. M.D
    * @param email value of email
    * @param phone value of phone
    * @param profile value of profile
    * @param firstName value of first name
    * @param lastName value of last name
    * @param joinDate date of join
    */
    public Doctor(String title, String email, String phone, String profile, String firstName, String lastName, Date joinDate) {
        super(firstName, lastName, joinDate);
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.profile = profile;
    }
    
    
        
    public Doctor(String firstname,String lastname,Date joinDate,String title) {
        super(firstname,lastname,joinDate);
        this.title = title;
    }
    
    public List<Hospital> getHospitals() {
        return hospitals;
    }
    
    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfile() {
        return profile;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
    
    public void addHospital(Hospital h) {
        if(!this.hospitals.contains(h)) {
            hospitals.add(h);
        }
    }

//    public List<Reservation> getReservations() {
//        return reservations;
//    }
//
//    public void setReservations(List<Reservation> reservations) {
//        this.reservations = reservations;
//    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    
    
    @Override
    public String toString() {
        return "Doctor{" + super.toString()+"title=" + title + ", email=" + email + ", phone=" + phone + ", profile=" + profile + ", hospitals=" + hospitals + '}';
    }
    
    
    

    
}
