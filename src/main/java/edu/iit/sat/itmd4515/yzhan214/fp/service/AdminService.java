/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;


import edu.iit.sat.itmd4515.yzhan214.fp.domain.Doctor;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Hospital;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.VetAssistant;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ln1878
 */
@Stateless
public class AdminService {
    @PersistenceContext(name="itmd4515PU")
    private EntityManager em;    
    
    @EJB
    private DoctorService doctorService;
    
    @EJB
    private HospitalService hospitalService;
    
    @EJB
    private PetOwnerService petOwnerService;
    
    @EJB
    private VetAssistantService vetAssistantService;
    
    /**
     *
     */
    public AdminService() {
        
    }
    
    /**
     *
     * @return
     */
    public List<Doctor> findDoctors() {
        return doctorService.findAll();
    }
    
    /**
     *
     * @return
     */
    public List<Hospital> findHospitals(){
        return  hospitalService.findAll();
    }
    
    /**
     *
     * @return
     */
    public List<PetOwner> findPetOwners(){
        return petOwnerService.findAll();
    }
    
    /**
     *
     * @return
     */
    public List<VetAssistant> findVetAssistants(){ 
        return vetAssistantService.findAll();
    }
    
    
    
    
}
