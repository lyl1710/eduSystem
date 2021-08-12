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

import entity.Request;
import java.util.ArrayList;

/**
 * The interface of RequestDAOimpl defines method to get information from
 * Request table in database.
 *
 * @author LongPHHE141469
 */
public interface IRequestDAO {

    /**
     * This method uses to get all data of request by title and id_Department
     * from Request table
     *
     * @param title is a <code>String</code>
     * @param id_Department is an <code>int</code>
     * @param pageIndex is an <code>int</code>
     * @param pageSize is an <code>int</code>
     *
     * @return requests. It is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Request> getRequests(String title, int id_Department, int pageIndex, int pageSize) throws Exception;

    /**
     * This method uses to get number of all requests content that title and
     * id_Department in Request table
     *
     * @param title is a <code>String</code>
     * @param id_Department is an <code>int</code>
     *
     * @return count. It is an<code>int</code>
     * @throws Exception
     */
    public int count(String title, int id_Department) throws Exception;

    /**
     * This method uses to get the last request from Request table
     *
     * @param top is an <code>int</code>
     *
     * @return request. It is a <code>Request</code> object
     * @throws Exception
     */
    public Request getLatestRequest(int top) throws Exception;

    /**
     * This method uses to get a request by id from Request table
     *
     * @param id is an <code>int</code>
     *
     * @return request. It is a <code>Request</code> object
     * @throws Exception
     */
    public Request getRequest(int id) throws Exception;

    /**
     * This method uses to update a request to the Request table
     *
     * @param id is an <code>int</code>
     * @param status is a <code>String</code>
     * @param closeDate is a <code>String</code>
     * @param detail is a <code>String</code>
     * @param solution is a <code>String</code>
     *
     * @throws Exception
     */
    public void updateRequest(int id, String status, String closeDate, boolean detail, String solution) throws Exception;
}
