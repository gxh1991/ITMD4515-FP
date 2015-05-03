/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Doctor;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Hospital;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Pet;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetClass;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.VetAssistant;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.Group;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.User;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author spyrisos
 */
@Singleton
@Startup
public class DatabasePopulator {
    
    @EJB
    private DoctorService doctorService;
    
    @EJB
    private PetOwnerService petOwnerService;
    
    @EJB
    private UserService userService;
    
    @EJB
    private GroupService groupService;
    
    @EJB
    private PetService petService;
    
    @EJB
    private VetAssistantService vetAssistantService;
    
    @EJB
    private HospitalService hospitalService;
    
    public DatabasePopulator() {
    }
    
    
    @PostConstruct
    public void testGroup() {
        Group doctorG = new Group("DOCTOR", "Doctor Group");
        Group petOwnerG = new Group("PETOWNER", "Petowner Group");
        Group assistantG = new Group("ASSISTANT","Assistant Group");
        groupService.create(doctorG);
        groupService.create(petOwnerG);
        groupService.create(assistantG);
        User scott = new User("scott","test123");
        User yiming = new User("yiming","test123");
        User brian = new User("brian","test123");
        scott.addGroup(doctorG);
        yiming.addGroup(petOwnerG);
        brian.addGroup(assistantG);
        doctorG.addUser(brian);
        petOwnerG.addUser(yiming);
        assistantG.addUser(brian);
        groupService.update(doctorG);
        groupService.update(petOwnerG);
        groupService.update(assistantG);
        
        userService.create(scott);
        userService.create(yiming);
        userService.create(brian);
        Hospital hospital = new Hospital("IIT Hospital");
        Doctor doctor1 = new Doctor("M.D.", "scott@iit.edu", "312-123-1234","Expert" , "scott","spyriso", new GregorianCalendar(2012,7,24).getTime());
        doctor1.setUser(scott);
        doctorService.create(doctor1);
        hospitalService.create(hospital);
        doctor1.addHospital(hospital);
        hospital.getDocs().add(doctor1);
        doctorService.update(doctor1);
        hospitalService.update(hospital);
        
        Pet p1 = new Pet("Ann", PetClass.Dog);
        PetOwner po1 = new PetOwner("Yiming", "847-123-1233", "1130 Halsted St");
        VetAssistant assistant1 = new VetAssistant("brian", "johnson",new GregorianCalendar(2013,8,13).getTime() , "1120 Halsted St", "224-123-1234");
        petService.create(p1);
        po1.setUser(yiming);
        po1.addPet(p1);
        petOwnerService.create(po1);
        assistant1.setHospital(hospital);
        assistant1.setUser(brian);
        vetAssistantService.create(assistant1);
        p1.setPetOwner(po1);
        petService.update(p1);
    }
    

}
