/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010
 * FPT Education System
 *
 * Record of change:
 * DATE          Version             AUTHOR             DESCRIPTION
 * 2021-07-22    1.0              LongPHHE141469       First Implement
 */
package dao.impl;

import context.DBContext;
import dao.IAccountDAO;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class implement from IAccountDAO contain methods to get information from
 * Account table in database.
 *
 * @author LongPHHE141469
 */
public class AccountDAOImpl extends DBContext implements IAccountDAO {

    /**
     * This method used to get account by userName and password from Account
     * table
     *
     * @param userName is a <code>String</code>
     * @param password is a <code>String</code>
     * @return account is a <code>Account</code> object
     * @throws Exception
     */
    @Override
    public Account getAccount(String userName, String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = new Account();
        String sql = "SELECT * FROM Account WHERE "
                + "username=(?) and BINARY_CHECKSUM([password]) = BINARY_CHECKSUM(?)  ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                account.setUserName(rs.getString(1));
                account.setPassword(rs.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return account;
    }

}
