/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.web.hospital;


import edu.iit.sat.itmd4515.yzhan214.fp.web.hospital.AbstractJSFBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author ln1878
 */
@Named
@RequestScoped
public class LoginBean extends AbstractJSFBean{
    
    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    
    @NotNull(message = "You shall not pass without a username!")
    private String username;
    @NotNull(message = "You shall not pass without a password!")
    @Size(min = 5, message = "Password must be at least 5 characters in length.")
    private String password;
    
    /**
     *
     */
    public LoginBean() {
    }
    
    @PostConstruct
    private void postConstruct() {
        super.postContruct();
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
    public String doLogin() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            req.login(username, password);
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            facesContext.addMessage(null, new FacesMessage("Bad Login", "Detail: You made a bad login!"));
            return "/login.xhtml";
        }
        return getPortalPathByRole("/welcome.xhtml");
    }

    /**
     *
     * @return
     */
    public String doLogout() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
        req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE,"There has been a problem invoking HttpServletRequest.logout",ex);
            facesContext.addMessage(null, new FacesMessage("Bad Logout", "Detail:There was a problem with the logout"));
            return "/error.xhtml";
        }
        return "/index.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String getRemoteUser() {
        return facesContext.getExternalContext().getRemoteUser();
    }
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
}
