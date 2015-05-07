/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.VetAssistant;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */
@Named
@Stateless
public class VetAssistantService extends AbstractService<VetAssistant>{

    /** Constructor
     *
     */
    public VetAssistantService() {
        super(VetAssistant.class);
    }

    /**
     *
     * @return return all Vet Assistants
     */
    @Override
    public List<VetAssistant> findAll() {
        return getEntityManager().createNamedQuery("VetAssistant.findAll", VetAssistant.class).getResultList();
    }

    /**
     *
     * @param username
     * @return return Vet Assistant
     */
    @Override
    public VetAssistant findByUsername(String username) {
        return getEntityManager().createNamedQuery("VetAssistant.findByUsername", VetAssistant.class).setParameter("username", username).getSingleResult();
    }
    
}
