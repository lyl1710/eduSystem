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
import dao.IRequestDAO;
import entity.Department;
import entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * The class implement from IRequestDAO contain methods to get information from
 * Request table in database.
 *
 * @author LongPHHE141469
 */
public class RequestDAOImpl extends DBContext implements IRequestDAO {

    /**
     * This method uses to get all data of request by title and id_Department
     * from Request table
     *
     * @param title is a <code>String</code>
     * @param id_Department is an <code>int</code>
     * @param pageIndex is an <code>int</code>
     * @param pageSize is an <code>int</code>
     *
     * @return list of Request object, it is a
     * <code>java.util.ArrayList<></code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Request> getRequests(String title, int id_Department, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY id ASC) as rid,* \n"
                + "              FROM (SELECT r.id as r_id,r.title,r.dateCreated,r.content,r.status,r.closeDate,r.detail,d.id,d.name "
                + "                    FROM Request r INNER JOIN Department d\n"
                + "                	              on r.id_Department=d.id\n"
                + "              WHERE title like ? ";
        if (id_Department > 0) {
            sql += "AND id_Department= ?";
        }
        sql += ")tba ) tbl \n"
                + "          WHERE rid >= (? - 1)*? + 1\n"
                + "                AND rid <= ? * ?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            if (id_Department > 0) {
                ps.setInt(2, id_Department);
                ps.setInt(3, pageIndex);
                ps.setInt(4, pageSize);
                ps.setInt(5, pageSize);
                ps.setInt(6, pageIndex);
            } else {
                ps.setInt(2, pageIndex);
                ps.setInt(3, pageSize);
                ps.setInt(4, pageSize);
                ps.setInt(5, pageIndex);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("r_id"));
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                request.setDepartment(department);

                request.setDateCreated(format.format(rs.getDate("dateCreated")));
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(format2.format(rs.getDate("closeDate")));
                request.setDetail(rs.getBoolean("detail"));
                requests.add(request);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return requests;

    }

    /**
     * This method uses to get number of all requests content that title and
     * id_Department in Request table
     *
     * @param title is a <code>String</code>
     * @param id_Department is an <code>int</code>
     *
     * @return number of request. It is an<code>int</code>
     * @throws Exception
     */
    @Override
    public int count(String title, int id_Department) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        String sql = "SELECT COUNT(*) FROM (SELECT r.title,r.dateCreated,r.content,r.status,r.closeDate,r.detail,d.id,d.name FROM Request r INNER JOIN Department d\n"
                + "        				on r.id_Department=d.id\n"
                + "        				 WHERE r.title like ? ";
        if (id_Department > 0) {
            sql += "AND id_Department= ?";
        }
        sql += ") tbc";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            if (id_Department > 0) {
                ps.setInt(2, id_Department);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return count;
    }

    /**
     * This method uses to get the last request from Request table
     *
     * @param top is an <code>int</code>
     *
     * @return request. It is a <code>Request</code> object
     * @throws Exception
     */
    @Override
    public Request getLatestRequest(int top) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Request request = new Request();
        String sql = "SELECT TOP(?)* FROM Request r INNER JOIN Department d on r.id_Department=d.id\n"
                + "WHERE r.detail=0\n"
                + "ORDER BY r.id DESC ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, top);
            rs = ps.executeQuery();
            if (rs.next()) {
                Department department = new Department();
                request.setId(rs.getInt(1));
                request.setStudentID(rs.getString("studentID"));
                request.setStudentName(rs.getString("studentName"));
                department.setId(rs.getInt("id_Department"));
                department.setName(rs.getString("name"));
                request.setDepartment(department);
                request.setDateCreated(rs.getString("dateCreated"));
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(rs.getString("closeDate"));
                request.setDetail(rs.getBoolean("detail"));
                request.setSolution(rs.getString("solution"));

            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return request;
    }

    /**
     * This method uses to get a request by id from Request table
     *
     * @param id is an <code>int</code>
     *
     * @return request. It is a <code>Request</code> object
     * @throws Exception
     */
    @Override
    public Request getRequest(int id) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Request request = new Request();
        String sql = "SELECT * FROM Request r INNER JOIN Department d \n"
                + "on r.id_Department=d.id WHERE r.id = ?  ";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Department department = new Department();
                request.setId(id);
                request.setStudentID(rs.getString("studentID"));
                request.setStudentName(rs.getString("studentName"));
                department.setId(rs.getInt("id_Department"));
                department.setName(rs.getString("name"));
                request.setDepartment(department);
                request.setDateCreated(rs.getString("dateCreated"));
                request.setTitle(rs.getString("title"));
                request.setContent(rs.getString("content"));
                request.setStatus(rs.getString("status"));
                request.setCloseDatel(rs.getString("closeDate"));
                request.setDetail(rs.getBoolean("detail"));
                request.setSolution(rs.getString("solution"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
        return request;

    }

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
    @Override
    public void updateRequest(int id, String status, String closeDate, boolean detail, String solution) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [dbo].[Request]\n"
                + "   SET [status] = ?\n"
                + "      ,[closeDate] = ?\n"
                + "      ,[detail] = ?\n"
                + "      ,[solution] = ?\n"
                + " WHERE id=?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, closeDate);
            ps.setBoolean(3, detail);
            ps.setString(4, solution);
            ps.setInt(5, id);
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(conn);
        }
    }

}
