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
public class Model_History_Message {

    /**
     * @return the messageType
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    /**
     * @return the fromUserID
     */
    public int getFromUserID() {
        return fromUserID;
    }

    /**
     * @param fromUserID the fromUserID to set
     */
    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    /**
     * @return the toUserID
     */
    public int getToUserID() {
        return toUserID;
    }

    /**
     * @param toUserID the toUserID to set
     */
    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mess
     */
    public String getMess() {
        return mess;
    }

    /**
     * @param mess the mess to set
     */
    public void setMess(String mess) {
        this.mess = mess;
    }
    
    public Model_History_Message(int fromUserID, int toUserID, String userName,int messageType,String text) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.name = userName;
        this.toUserID = toUserID;
        this.mess = text;
    }

    public Model_History_Message() {
    }

    private int messageType;
    private int fromUserID;
    private int toUserID;
    private String name;
    private String mess;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            
            json.put("fromUserID", getFromUserID());
            json.put("name", getName());
            json.put("toUserID", getToUserID());
            json.put("messageType", getMessageType());
            json.put("mess", getMess());
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
    
    public Model_History_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            
            fromUserID = obj.getInt("fromUserID");
            name = obj.getString("name");
            toUserID = obj.getInt("toUserID");
            messageType = obj.getInt("messageType");
            mess = obj.getString("mess");

        } catch (JSONException e) {
            System.err.println(e);
        }
    }
}
