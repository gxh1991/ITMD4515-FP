/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Pet;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetOwnerService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetService;
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
public class PetOwnerBean extends AbstractJSFBean{
    
    private static final Logger LOG = Logger.getLogger(PetOwnerBean.class.getName());
    private PetOwner petOwener;
    @EJB
    private PetOwnerService petOwnerService;
    @EJB
    private PetService petService;
    @Inject
    private LoginBean loginBean;
    private List<Pet> pets;

    /**
     *
     */
    public PetOwnerBean() {
    }

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        petOwener = petOwnerService.findByUsername(loginBean.getRemoteUser());
        pets = petOwener.getPets();
    }
    
    /**
     *
     * @return
     */
    public String executeUpdate() {
        LOG.info("Inside PetOwnerBean.executeUpdate() with " + petOwener.toString());
        petOwnerService.update(petOwener);
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }

    /**
     *
     * @return
     */
    public PetOwner getPetOwener() {
        return petOwener;
    }

    /**
     *
     * @param petOwener
     */
    public void setPetOwener(PetOwner petOwener) {
        this.petOwener = petOwener;
    }

    /**
     * Get the value of pets
     *
     * @return the value of pets
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     * Set the value of pets
     *
     * @param pets new value of pets
     */
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}
