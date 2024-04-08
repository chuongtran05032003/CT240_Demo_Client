/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import form.Chat;

/**
 *
 * @author Chuong Tran
 */
public class ChatLs {

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    private Chat chat;

    public ChatLs(Chat chat, int userID) {
        this.chat = chat;
        this.userID = userID;
    }
    private int userID;
    
}
