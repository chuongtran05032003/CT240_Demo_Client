
package model;

import app.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

public class Model_Send_Message {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Model_File_Sender getFile() {
        return file;
    }

    public void setFile(Model_File_Sender file) {
        this.file = file;
    }

    public Model_Send_Message(MessageType messageType, int fromUserID, String userName, int toUserID, String text) {
        this.messageType = messageType;
        this.fromUserID = fromUserID;
        this.userName = userName;
        this.toUserID = toUserID;
        this.text = new String(text);
    }

    public Model_Send_Message() {
    }

    private MessageType messageType;
    private int fromUserID;
    private String userName;
    private int toUserID;
    private String text;
    private Model_File_Sender file;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("messageType", messageType.getValue());
            json.put("fromUserID", fromUserID);
            json.put("userName", userName);
            json.put("toUserID", toUserID);
            if (messageType == MessageType.FILE || messageType == MessageType.IMAGE) {
                json.put("text", file.getFileExtensions());
                json.put("fileName", file.getFileName());
            } else {
                json.put("text", text);
            }
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}