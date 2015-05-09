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
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Reservation;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.ReservationStatus;
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
    
    @EJB
    private ReservationService reservationService;
    
    /**
     *
     */
    public DatabasePopulator() {
    }

    /**
     *
     */
    @PostConstruct
    public void testGroup() {
        
        Group doctorG = new Group("DOCTOR", "Doctor Group");
        Group petOwnerG = new Group("PETOWNER", "Petowner Group");
        Group assistantG = new Group("ASSISTANT","Assistant Group");
        Group adminG = new Group("ADMIN", "Administrator Group");
        groupService.create(doctorG);
        groupService.create(petOwnerG);
        groupService.create(assistantG);
        groupService.create(adminG);
        User scott = new User("scott","test123");
        User yiming = new User("yiming","test123");
        User brian = new User("brian","test123");
        User ryan = new User("ryan","test123");
        User zhang = new User("zhang","test123");
        
        userService.create(scott);
        userService.create(yiming);
        userService.create(brian);
        userService.create(ryan);
        userService.create(zhang);
        
        scott.addGroup(doctorG);
        yiming.addGroup(petOwnerG);
        brian.addGroup(assistantG);
        ryan.addGroup(petOwnerG);
        zhang.addGroup(adminG);
        
        petOwnerG.addUser(yiming);
        petOwnerG.addUser(ryan);
        assistantG.addUser(brian);
        adminG.addUser(zhang);
        
        groupService.update(doctorG);
        groupService.update(petOwnerG);
        groupService.update(assistantG);
        groupService.update(adminG);
        userService.update(scott);
        userService.update(yiming);
        userService.update(brian);
        userService.update(ryan);
        userService.update(zhang);
        
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
        Pet p2 = new Pet("Billy",PetClass.Cat);
        PetOwner po1 = new PetOwner("Yiming", "847-123-1233", "1130 Halsted St");
        PetOwner po2 = new PetOwner("Ryan", "847-567-1233", "1110 Halsted St");
        VetAssistant assistant1 = new VetAssistant("brian", "johnson",new GregorianCalendar(2013,8,13).getTime() , "1120 Halsted St", "224-123-1234");
        petService.create(p1);
        petService.create(p2);
        po1.setUser(yiming);
        po1.addPet(p1);
        po2.addPet(p2);
        po2.setUser(ryan);
        petOwnerService.create(po1);
        petOwnerService.create(po2);
        assistant1.setHospital(hospital);
        assistant1.setUser(brian);
        vetAssistantService.create(assistant1);
        p1.setPetOwner(po1);
        p2.setPetOwner(po2);
        petService.update(p1);
        
        Reservation re1 = new Reservation(new GregorianCalendar(2015, 3, 10).getTime(), "Reservation for Ann");
        Reservation re2 = new Reservation(new GregorianCalendar(2014, 12, 4).getTime(), "Reservation for Billy");
        re1.setRs(ReservationStatus.Active);
        re2.setRs(ReservationStatus.Active);
        re1.setDoctor(doctor1);
        re2.setDoctor(doctor1);
        re1.setPetOwner(po1);
        re2.setPetOwner(po2);
        reservationService.create(re1);
        reservationService.create(re2);
        hospital.addReservation(re1);
        hospital.addReservation(re2);
        doctor1.addReservation(re1);
        po1.getReservations().add(re1);
        po2.getReservations().add(re2);
        hospitalService.update(hospital);
        doctorService.update(doctor1);
              
        
        
    }



}
