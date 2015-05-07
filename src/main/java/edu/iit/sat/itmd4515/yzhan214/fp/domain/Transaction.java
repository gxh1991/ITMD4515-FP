/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.yzhan214.fp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ln1878
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name="Transaction.findById",query="select p from Transaction p where p.id= :id"),
    @NamedQuery(name = "Transaction.findAll", query = "select r from Transaction r")
})
public class Transaction extends BaseEntity implements Serializable{
    @Column(precision = 9,scale=2)
    private BigDecimal payment;
    private String message;
    @Temporal(TemporalType.DATE)
    private Date pDate;

    /**
     *  Constructor
     */
    public Transaction() {
    }

    /**
    * Constructor.
    * 
    * @param payment value of payment
    * @param message detail of payment
    * @param pDate date of payment
    * 
    */    
    public Transaction(BigDecimal payment, String message, Date pDate) {
        this.payment = payment;
        this.message = message;
        this.pDate = GregorianCalendar.getInstance().getTime();
    }

    /**
     *
     * @return  the amount of payment
     */
    public BigDecimal getPayment() {
        return payment;
    }

    /**
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @return the payment date
     */
    public Date getpDate() {
        return pDate;
    }

    /**
     *
     * @param payment
     */
    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @param pDate
     */
    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }
    
}
