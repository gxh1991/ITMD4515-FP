/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.service;

import edu.iit.sat.itmd4515.yzhan214.fp.domain.security.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ln1878
 */
@Stateless
public class UserService extends AbstractService<User>{

    /** Constructor
     *
     */
    public UserService() {
        super(User.class);
    }

    /**
     *
     * @return return all users
     */
    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param username
     * @return return user
     */
    @Override
    public User findByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
