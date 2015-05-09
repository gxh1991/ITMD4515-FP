/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Pet;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetClass;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetOwnerService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */
@Named
@RequestScoped
public class PetBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(PetBean.class.getName());
    private Pet pet;
    private PetOwner petOwner;
    private String petclass_;
    @EJB
    private PetService petService;
    @Inject
    private LoginBean loginBean;
    @EJB
    private PetOwnerService petOwnerService;

    /**
     *
     */
    public PetBean() {
    }

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        LOG.info("Inside PetBean.postConstruct");
        pet = new Pet();
    }
    
    /**
     *
     * @return
     */
    public String doCreate() {
        pet = new Pet();
        return "/petownerPortal/pet.xhtml";
    }

    /**
     *
     * @param pet
     * @return
     */
    public String doUpdate(Pet pet) {
        this.pet = pet;
        return "/petownerPortal/pet.xhtml";
    }
    
    /**
     *
     * @param pet
     * @return
     */
    public String doDelete(Pet pet) {
        petService.delete(pet);
        return "welcome.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String executeSave() {
        if (this.pet.getId() != null) {
            LOG.info("Executing update on " + this.pet.toString());
            petOwner = petOwnerService.findByUsername(loginBean.getRemoteUser());
            pet.setPetOwner(petOwner);
            petService.update(pet);
            return loginBean.getPortalPathByRole("/welcome.xhtml");
        } else {
            LOG.info("Creating " + this.pet.toString());
            // TODO - fix create!  It is creating a new station
            petService.create(pet);
            return loginBean.getPortalPathByRole("/welcome.xhtml");
        }        
    }

    /**
     * Get the value of pet
     *
     * @return the value of pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Set the value of pet
     *
     * @param pet new value of pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    /**
     *
     * @return
     */
    public List<String> getClasses() {
        List<PetClass> tmp  = Arrays.asList(PetClass.values());
        List<String> re = new ArrayList<String>();
        for(PetClass p:tmp) {
            re.add(p.toString());
        }
        return re;
    }
    //JSF does not have special support for enum, add a string variable petclass_ to solve this problem

    /**
     *
     * @param petclass_
     */
        public void setPetclass_(String petclass_) {
        this.petclass_ = petclass_;
        pet.setPetClass(petclass_);
    }

    /**
     *
     * @return
     */
    public String getPetclass_() {
        return petclass_;
    }
    
    
    

}
