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

import entity.Department;
import java.util.ArrayList;

/**
 * The interface of DepartmentDAOimpl defines method to get information from
 * Department table in database.
 *
 * @author LongPHHE141469
 */
public interface IDepartmentDAO {

    /**
     * This method uses to get all data of department on today from Department
     * table
     *
     * @param date is date of <code>Department</code> object, it is a
     * <code>String</code>
     * @param pageIndex is pageIndex of <code>Department</code> object, it is an
     * <code>int</code>
     * @param pageSize is pageSize of <code>Department</code> object, it is an
     * <code>int</code>
     * @param detail is detail of <code>Department</code> object, it is a
     * <code>boolean</code>
     * @return departments. It is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Department> getDepartmentToday(String date, int pageIndex, int pageSize, boolean detail) throws Exception;

    /**
     * This method uses to get all data of department on another day from
     * Department table
     *
     * @param pageIndex is pageIndex of <code>Department</code> object, it is an
     * <code>int</code>
     * @param pageSize is pageSize of <code>Department</code> object, it is an
     * <code>int</code>
     * @param detail is detail of <code>Department</code> object, it is a
     * <code>boolean</code>
     * @return departments. It is a <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Department> getDepartmentLast2days( int pageIndex, int pageSize, boolean detail) throws Exception;

    /**
     * This method uses to get number of total department from Department table
     *
     * @return number of Department object. It is an <code>int</code>
     * @throws Exception
     */
    public int count() throws Exception;

    /**
     * This method uses to get all data of department from Department table
     *
     * @return list departments of <code>Department</code> object. It is a
     * <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    public ArrayList<Department> getAllDepartment() throws Exception;
}
