/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Hospital;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */
@Named
@Stateless
public class HospitalService extends AbstractService<Hospital> {

    /**
     *
     */
    public HospitalService() {
        super(Hospital.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Hospital> findAll() {
        return getEntityManager().createNamedQuery("Hospital.findAll", Hospital.class).getResultList();
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public Hospital findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
