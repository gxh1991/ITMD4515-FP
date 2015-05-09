/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Reservation;
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
public class ReservationService extends AbstractService<Reservation>{
    
    private static final Logger LOG = Logger.getLogger(ReservationService.class.getName());
    
    /**Constructor
     *
     */
    public ReservationService() {
        super(Reservation.class);
    }

    /**find all the reservations
     *
     * @return return all reservations
     */
    @Override
    public List<Reservation> findAll() {
        LOG.info("Inside Reservation Service findall");
        List<Reservation> tmp = getEntityManager().createNamedQuery("Reservation.findAll", Reservation.class).getResultList();
        
        for(Reservation r:tmp) {
            r.getDoctor();
            LOG.info("Reservation Doctor:");
        }
        return tmp;
//        return getEntityManager().createNamedQuery("Reservation.findAll", Reservation.class).getResultList();
    }

    /**
     *
     * @param username
     * @return return reservation
     */
    @Override
    public Reservation findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @param re
     * @param po
     */
    public void delete(Reservation re,PetOwner po) {
        po = getEntityManager().getReference(PetOwner.class, po.getId());
        re = getEntityManager().getReference(Reservation.class, re.getId());
        po.getReservations().remove(re);
        super.delete(re);
        
    }
    
    
}
