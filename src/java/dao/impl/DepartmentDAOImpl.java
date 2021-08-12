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
import dao.IDepartmentDAO;
import entity.Department;
import entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The class implement from IDepartmentDAO contain methods to get information from
 * Department table in database.
 *
 * @author LongPHHE141469
 */
public class DepartmentDAOImpl extends DBContext implements IDepartmentDAO {

    private int count = 0;
    private int count2 = 0;

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
    @Override
    public ArrayList<Department> getDepartmentToday(String date, int pageIndex, int pageSize, boolean detail) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Request r INNER JOIN Department d \n"
                + "on r.id_Department = d.id \n"
                + "WHERE r.dateCreated=? AND r.detail=?";
        try {
            Department department = new Department();
            department.setId(-1);
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setBoolean(2, detail);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (department.getId() != rs.getInt("id_Department")) {
                    department = new Department();
                    department.setId(rs.getInt("id_Department"));
                    department.setName(rs.getString("name"));
                    if (count < (pageIndex * pageSize) && count >= ((pageIndex - 1) * pageSize)) {
                        departments.add(department);
                    }
                    count++;
                }
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setStudentID(rs.getString("studentID"));
                request.setStudentName(rs.getString("studentName"));
                request.setDepartment(department);
                request.setDateCreated(date);
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(rs.getString("closeDate"));
                request.setDetail(detail);
                department.getRequests().add(request);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return departments;
    }

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
    @Override
    public ArrayList<Department> getDepartmentLast2days( int pageIndex, int pageSize, boolean detail) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Request r INNER JOIN Department d \n"
                + "on r.id_Department = d.id \n"
                + "WHERE r.dateCreated between CURRENT_TIMESTAMP-3 and CURRENT_TIMESTAMP-1 AND r.detail=?";
        try {
            Department department = new Department();
            department.setId(-1);
            conn = getConnection();
            ps = conn.prepareStatement(sql);
//            ps.setString(1, date);
            ps.setBoolean(1, detail);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (department.getId() != rs.getInt("id_Department")) {
                    department = new Department();
                    department.setId(rs.getInt("id_Department"));
                    department.setName(rs.getString("name"));
                    if (count2 < (pageIndex * pageSize) && count2 >= ((pageIndex - 1) * pageSize)) {
                        departments.add(department);
                    }
                    count2++;
                }
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setStudentID(rs.getString("studentID"));
                request.setStudentName(rs.getString("studentName"));
                request.setDepartment(department);
                request.setDateCreated("dateCreated");
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(rs.getString("closeDate"));
                request.setDetail(detail);
                department.getRequests().add(request);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return departments;
    }

    /**
     * This method uses to get number of total department from Department table
     *
     * @return number of Department object. It is an <code>int</code>
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        if (count > count2) {
            return count;
        } else {
            return count2;
        }
    }

    /**
     * This method uses to get all data of department from Department table
     *
     * @return list departments of <code>Department</code> object. It is a
     * <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Department> getAllDepartment() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM Department";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return departments;
    }

}
