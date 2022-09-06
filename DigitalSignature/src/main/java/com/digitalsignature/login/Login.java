package com.digitalsignature.login;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.io.Serializable;

public class Login implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int userID;
    protected String loginName;
    protected String password;
    protected String email;
    protected Timestamp lastLogin;


    public Login(String loginName, String password, String email, Timestamp lastLogin) {
        this.loginName = loginName;
        this.password = password;
        this.email = email;
        this.lastLogin = lastLogin;
    }

    public Login() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getUserID() {
        return userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
