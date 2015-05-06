/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ln1878
 */
@Named
@RequestScoped
public class DoctorBean extends AbstractJSFBean {

    public DoctorBean() {
        super();
    }
    
    @PostConstruct
    private void PostConstruct() {
        super.postContruct();
    }
}
