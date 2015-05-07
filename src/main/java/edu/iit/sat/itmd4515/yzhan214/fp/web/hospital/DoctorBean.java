/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.Doctor;
import edu.iit.sat.itmd4515.yzhan214.fp.service.DoctorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */
@Named
@RequestScoped
public class DoctorBean extends AbstractJSFBean {
    
    private static final Logger LOG = Logger.getLogger(DoctorBean.class.getName());
    private Doctor doctor;
    @Inject private LoginBean loginBean;
    @EJB private DoctorService doctorService;
    
    public DoctorBean() {
        super();
        LOG.info("Inside DoctorBean.Constructor");
    }
    
    @PostConstruct
    private void PostConstruct() {
        super.postContruct();
        doctor = doctorService.findByUsername(loginBean.getRemoteUser());
        LOG.info("Inside DoctorBean.postConstruct() with " + doctor.toString());
    }
    
    public String executeUpdate() {
        LOG.log(Level.INFO, "Inside DoctorBean.executeUpdate() with '{'0'}'", doctor.toString());
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
    
}
