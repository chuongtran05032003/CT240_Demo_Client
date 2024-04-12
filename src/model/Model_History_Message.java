
package model;


import org.json.JSONException;
import org.json.JSONObject;


public class Model_History_Message {


    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
    
    public Model_History_Message(int fromUserID, int toUserID, String userName,int messageType,String text, int side) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.name = userName;
        this.toUserID = toUserID;
        this.mess = text;
        this.side = side;
    }

    public Model_History_Message() {
    }

    private int messageType;
    private int fromUserID;
    private int toUserID;
    private String name;
    private String mess;
    private int side;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            
            json.put("fromUserID", getFromUserID());
            json.put("name", getName());
            json.put("toUserID", getToUserID());
            json.put("messageType", getMessageType());
            json.put("mess", getMess());
            json.put("side", getSide());
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
            side = obj.getInt("side");

        } catch (JSONException e) {
            System.err.println(e);
        }
    }
}
