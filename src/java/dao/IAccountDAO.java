/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010
 * FPT Education System
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-22    1.0              LongPHHE141469       First Implement
 */
package dao;

import entity.Account;

/**
 * The interface of AccountDAOimpl defines method to get information from
 * Account table in database.
 *
 * @author LongPHHE141469
 */
public interface IAccountDAO {

    /**
     * This method used to get account by userName and password from Account
     * table
     *
     * @param userName is the userName of Account object a <code>String</code>
     * @param password is the password of Account object a <code>String</code>
     *
     * @return account is a <code>Account</code> object
     * @throws Exception
     */
    public Account getAccount(String userName, String password) throws Exception;
}
