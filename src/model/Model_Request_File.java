/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONException;
import org.json.JSONObject;

public class Model_Request_File {

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public Model_Request_File(int fileID, String fileName) {
        this.fileID = fileID;
        this.fileName = fileName;
    }

    public Model_Request_File() {
    }

    private int fileID;
    private String fileName;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("fileID", fileID);
            json.put("fileName", fileName);
            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
