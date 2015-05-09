/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.VetAssistant;
import edu.iit.sat.itmd4515.yzhan214.fp.service.VetAssistantService;
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
public class VetAssistantBean extends AbstractJSFBean{
    
    private static final Logger LOG = Logger.getLogger(VetAssistantBean.class.getName());
    private VetAssistant vetAssistant;
    @EJB VetAssistantService vetAssistantService;
    @Inject LoginBean loginBean;
    
    /**
     *
     */
    public VetAssistantBean() {
    }
    
    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        vetAssistant = vetAssistantService.findByUsername(loginBean.getRemoteUser());
        LOG.info("Inside VetAssistantBean.postConstruct");
    }

    /**
     *
     * @return
     */
    public VetAssistant getVetAssistant() {
        return vetAssistant;
    }

    /**
     *
     * @param vetAssistant
     */
    public void setVetAssistant(VetAssistant vetAssistant) {
        this.vetAssistant = vetAssistant;
    }
    
    /**
     *
     * @return
     */
    public String executeUpdate() {
        LOG.info("Inside PetOwnerBean.executeUpdate() with " + vetAssistant.toString());
        vetAssistantService.update(vetAssistant);
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }
    
    
    
    
}
