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

import java.util.ArrayList;

/**
 * The class contains method constructor, all properties have <code>get</code>
 * <code>set</code> method
 *
 * @author LongPHHE141469
 */
public class Department {

    //Create Atributes
    private int id;
    private String name;
    private ArrayList<Request> requests = new ArrayList<>();

    /**
     * Get value of id attribute of <code>Department</code> object
     *
     * @return id of <code>Department</code> object it is a int
     */
    public int getId() {
        return id;
    }

    /**
     * Set value of id attribute of <code>Department</code> object
     *
     * @param id is the id of <code>Department</code>, it is an int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value of name attribute of <code>Department</code> object
     *
     * @return name of <code>Department</code> object it is a String
     */
    public String getName() {
        return name;
    }

    /**
     * Set value of name attribute of <code>Department</code> object
     *
     * @param name is the name of <code>Department</code>, it is a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value of requests attribute of <code>Department</code> object
     *
     * @return requests of <code>Department</code> object it is
     * <code>java.util.ArrayList</code> object
     */
    public ArrayList<Request> getRequests() {
        return requests;
    }

    /**
     * Set value of requests attribute of <code>Department</code> object
     *
     * @param requests is the requests of <code>Department</code>, it is a
     * <code>java.util.ArrayList</code> object
     */
    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

}
