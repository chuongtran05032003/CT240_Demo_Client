/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Request_File {

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public long getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(long currentLength) {
        this.currentLength = currentLength;
    }

    public Model_Request_File(int fileID, String fileName, long currentLength) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.currentLength = currentLength;
    }

    public Model_Request_File() {
    }

    private int fileID;
    private String fileName;
    private long currentLength;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fileID", fileID);
            json.put("fileName", fileName);
            json.put("currentLength", currentLength);
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
