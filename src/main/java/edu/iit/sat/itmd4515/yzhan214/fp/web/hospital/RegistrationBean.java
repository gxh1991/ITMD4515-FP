/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Doctor;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.VetAssistant;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.Group;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.User;
import edu.iit.sat.itmd4515.yzhan214.fp.service.DoctorService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.GroupService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetOwnerService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.UserService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.VetAssistantService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */

@Named
@RequestScoped
public class RegistrationBean extends AbstractJSFBean{
    
    private User user;
    @EJB private UserService userService;
    @EJB private GroupService groupService;
    @EJB private VetAssistantService vetAssistantService;
    @EJB private PetOwnerService petOwnerService;
    @EJB private DoctorService doctorService;
    
    private String role;
    private String firstName;
    private String lastName;
    private String phone;
    
    public RegistrationBean() {
    }
    
    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        user = new User();
    }
    
    public String doRegister() {
        userService.create(user);
        if(role.equals("vetassistant")) {
            Group group = groupService.findByGroupName("ASSISTANT");
            user.addGroup(group);
            group.addUser(user);
            
            VetAssistant va = new VetAssistant();
            va.setFirstName(firstName);
            va.setLastName(lastName);
            va.setPhone(phone);
            vetAssistantService.create(va);
            return "login.xhtml";
        }
        else if(role.equals("doctor")) {
            Group group = groupService.findByGroupName("DOCTOR");
            user.addGroup(group);
            group.addUser(user);
            Doctor doctor = new Doctor();
            doctor.setFirstName(firstName);
            doctor.setLastName(lastName);
            doctor.setPhone(phone);
            doctorService.create(doctor);
            return "login.xhtml";
        }
        else if (role.equals("petowner")) {
            Group group = groupService.findByGroupName("PETOWNER");
            user.addGroup(group);
            group.addUser(user);
            PetOwner petOwner = new PetOwner();
            petOwner.setName(firstName+lastName);
            petOwner.setPhone(phone);
            petOwnerService.create(petOwner);
            return "login.xhtml";
        }
        return "index.xhtml";
    }

    public User getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
}
