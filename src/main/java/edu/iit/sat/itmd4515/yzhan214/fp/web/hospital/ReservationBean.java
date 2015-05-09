/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Doctor;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Pet;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.PetOwner;
import edu.iit.sat.itmd4515.yzhan214.fp.domain.Reservation;
import edu.iit.sat.itmd4515.yzhan214.fp.service.DoctorService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.PetOwnerService;
import edu.iit.sat.itmd4515.yzhan214.fp.service.ReservationService;
import java.util.Date;
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
public class ReservationBean extends AbstractJSFBean{
    
    private static final Logger LOG = Logger.getLogger(Reservation.class.getName());
    private Reservation reservation;
    @EJB private ReservationService reservationService;
    @EJB private DoctorService doctorService;
    @EJB private PetOwnerService petOwnerService;
    @Inject private LoginBean loginBean;
    
    /**
     *
     */
    public ReservationBean() {
    }
    
    @PostConstruct
    private void postConstruct() {
        super.postContruct();
        reservation = new Reservation();
        reservation.setDoctor(new Doctor());
        reservation.setPetOwner(new PetOwner());
    }

    /**
     *
     * @return
     */
    public boolean isAdmin() {
        return facesContext.getExternalContext().isUserInRole("admin");
    }

    /**
     *
     * @return
     */
    public boolean isDoctor() {
        return facesContext.getExternalContext().isUserInRole("doctor");
    }

    /**
     *
     * @return
     */
    public boolean isAssistant() {
        return facesContext.getExternalContext().isUserInRole("vetassistant");
    } 
    
    /**
     *
     * @return
     */
    public boolean isPetOwner() {
        return facesContext.getExternalContext().isUserInRole("petowner");
    }
    
    /**
     *
     * @param path
     * @return
     */
    public String getPortalPathByRole(String path) {
        LOG.info("Inside LoginBean getPortal");
        if (isAdmin()) {
            return "/admin" + path;
        } else if (isDoctor()) {
            return "/doctorPortal" + path;
        } else if (isAssistant()) {
            return "/assistantPortal" + path;
        } else if(isPetOwner()) {
            return "/petownerPortal" + path;
        }
          else {
            return path ;
        }
    }
    
    /**
     *
     * @return
     */
    public String doCreate() {
        reservation = new Reservation();
        return "/assistantPortal/reservation.xhtml";
    }
    
    /**
     *
     * @param re
     * @return
     */
    public String doUpdate(Reservation re) {
        reservation = re;
        return getPortalPathByRole("/reservation.xhtml");
    }
    
    /**
     *
     * @param re
     * @return
     */
    public String doDelete(Reservation re) {
        reservation = re;
        if(isPetOwner()) {
            reservationService.delete(re,petOwnerService.findByUsername(loginBean.getRemoteUser()));
        }
        
        return getPortalPathByRole("/welcome.xhtml");
    }
    
    /**
     *
     * @return
     */
    public String executeSave() {
        if (this.reservation.getId() != null) {
            LOG.info("Executing update on " + this.reservation.toString());
            
            Doctor doc = doctorService.find(reservation.getDoctor().getId());
            PetOwner po = petOwnerService.find(reservation.getPetOwner().getId());
            reservation.setPetOwner(po);
            reservation.setDoctor(doc);
            reservation.setrDate(new Date());
            reservationService.update(reservation);
            return loginBean.getPortalPathByRole("/welcome.xhtml");
        } else {
            LOG.info("Creating " + this.reservation.toString());
            // TODO - fix create!  It is creating a new station
            Doctor doc = doctorService.find(reservation.getDoctor().getId());
            PetOwner po = petOwnerService.find(reservation.getPetOwner().getId());
            reservation.setPetOwner(po);
            reservation.setDoctor(doc);
            reservation.setrDate(new Date());
            reservationService.create(reservation);
            return loginBean.getPortalPathByRole("/welcome.xhtml");
        } 
        
        // TODO - fix create!  It is creating a new station
        
        
    }

    /**
     *
     * @return
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     *
     * @param reservation
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
    
    
}
