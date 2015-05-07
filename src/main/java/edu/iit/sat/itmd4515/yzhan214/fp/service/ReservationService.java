/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Reservation;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ln1878
 */
@Stateless
public class ReservationService extends AbstractService<Reservation>{

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
        return getEntityManager().createNamedQuery("Reservation.findAll", Reservation.class).getResultList();
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
    
   
    
}
