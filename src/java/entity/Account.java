/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010
 * FPT Education System
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-22    1.0              LongPHHE141469       First Implement
 */
package entity;

/**
 * The class contains method constructor, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author LongPHHE141469
 */
public class Account {

    //Create attribute
    private String userName;
    private String password;

    /**
     * Get value of username attribute of <code>Account</code> object
     *
     * @return username of <code>Account</code> object it is a String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set value of userName attribute of <code>Account</code> object
     *
     * @param userName is the userName of <code>Account</code>, it is a string
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get value of password attribute of <code>Account</code> object
     *
     * @return password of <code>Account</code> object it is a String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set value of password attribute of <code>Account</code> object
     *
     * @param password is the password of <code>Account</code>, it is a string
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
