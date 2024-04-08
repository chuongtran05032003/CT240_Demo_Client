/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Chuong Tran
 */
public class Model_User_Account {
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Model_User_Account(int userID, String userName, int status) {
        this.userID = userID;
        this.userName = userName;
        this.status = status;
    }

    public Model_User_Account(Model_User_Account user) {
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.status = user.getStatus();
    }
    
    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            userID = obj.getInt("userID");
            userName = obj.getString("userName");
            status = obj.getInt("status");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    private int userID;
    private String userName;
    private int status;
}
