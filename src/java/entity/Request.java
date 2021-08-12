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
public class Request {

    //Create attribute
    private int id;
    private String studentID;
    private String studentName;
    private Department department;
    private String dateCreated;
    private String title;
    private String content;
    private String status;
    private String closeDatel;
    private boolean detail;
    private String solution;

    /**
     * Get value of solution attribute of <code>Request</code> object
     *
     * @return solution of <code>Request</code> object it is a String
     */
    public String getSolution() {
        return solution;
    }

    /**
     * Set value of solution attribute of <code>Request</code> object
     *
     * @param solution is the solution of <code>Request</code>, it is a string
     */
    public void setSolution(String solution) {
        this.solution = solution;
    }

    /**
     * Get value of id attribute of <code>Request</code> object
     *
     * @return id of <code>Request</code> object it is an int
     */
    public int getId() {
        return id;
    }

    /**
     * Get value of title attribute of <code>Request</code> object
     *
     * @return title of <code>Request</code> object it is a String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value of title attribute of <code>Request</code> object
     *
     * @param title is the title of <code>Request</code>, it is a string
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set value of id attribute of <code>Request</code> object
     *
     * @param id is the id of <code>Request</code>, it is a int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value of studentID attribute of <code>Request</code> object
     *
     * @return studentID of <code>Request</code> object it is a String
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Set value of studentID attribute of <code>Request</code> object
     *
     * @param studentID is the studentID of <code>Request</code>, it is a
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Get value of studentName attribute of <code>Request</code> object
     *
     * @return studentName of <code>Request</code> object it is a String
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Set value of studentName attribute of <code>Request</code> object
     *
     * @param studentName is the studentName of <code>Request</code>, it is a string
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get value of department attribute of <code>Request</code> object
     *
     * @return department of <code>Request</code> object it is an object
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Set value of department attribute of <code>Request</code> object
     *
     * @param department is the department of <code>Request</code>, it is a object
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Get value of dateCreated attribute of <code>Request</code> object
     *
     * @return dateCreated of <code>Request</code> object it is a String
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * Set value of dateCreated attribute of <code>Request</code> object
     *
     * @param dateCreated is the dateCreated of <code>Request</code>, it is a string
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Get value of content attribute of <code>Request</code> object
     *
     * @return content of <code>Request</code> object it is a String
     */
    public String getContent() {
        return content;
    }

    /**
     * Set value of content attribute of <code>Request</code> object
     *
     * @param content is the content of <code>Request</code>, it is a string
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get value of status attribute of <code>Request</code> object
     *
     * @return status of <code>Request</code> object it is a String
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set value of status attribute of <code>Request</code> object
     *
     * @param status is the status of <code>Request</code>, it is a string
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get value of closeDatel attribute of <code>Request</code> object
     *
     * @return closeDatel of <code>Request</code> object it is a String
     */
    public String getCloseDatel() {
        return closeDatel;
    }

    /**
     * Set value of closeDatel attribute of <code>Request</code> object
     *
     * @param closeDatel is the closeDatel of <code>Request</code>, it is a
     * string
     */
    public void setCloseDatel(String closeDatel) {
        this.closeDatel = closeDatel;
    }

    /**
     * This method used to get detail
     *
     * @return detail is a <code>boolean</code>
     */
    public boolean isDetail() {
        return detail;
    }

    /**
     * This method used to set detail
     *
     * @param detail is a <code>boolean</code>
     */
    public void setDetail(boolean detail) {
        this.detail = detail;
    }

}
