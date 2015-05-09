/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Doctor;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */
@Named
@Stateless
public class DoctorService extends AbstractService<Doctor>{
     private static final Logger LOG = Logger.getLogger(DoctorService.class.getName());
    /**
     *
     */
    public DoctorService() {
        super(Doctor.class);
        
    }

    /**
     *
     * @return
     */
    @Override
    public List<Doctor> findAll() {
        return getEntityManager().createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public Doctor findByUsername(String username) {
        LOG.info("Inside DoctorService");
        return getEntityManager().createNamedQuery("Doctor.findByUsername", Doctor.class).setParameter("username", username).getSingleResult();
    }



}
