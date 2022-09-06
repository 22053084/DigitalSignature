package com.digitalsignature.project;

import java.io.Serializable;
import java.sql.Timestamp;


public class Project implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int projectID;
    protected String projectName;
    protected String status;
    protected int user;
    protected Timestamp creationDate;
    protected Timestamp completionDate;




    public Project() {
    }

    public Project(int projectID, String projectName, int user, String status, Timestamp creationDate, Timestamp completionDate) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.user = user;
        this.status = status;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }


    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        switch (status){
            case "0":
                return "Void";
            case "1":
                return "In Progress";
            case "2":
                return "Completed";
        }



        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }
}
