/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Model_History_Message;


public class PublicEvent {


    private int userID;
    private static PublicEvent instance;
    private EventMain eventMain;
    private EventImageView eventImageView;
    private EventChatSend eventChatSend;
    private Map<Integer, EventChatReceive> userEventChatReceives;
    private EventLogin eventLogin;
    private EventMenuLeft eventMenuLeft;
    private EventMenuChat eventMenuChat;
    private List<Model_History_Message> mess;

    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() {
        userEventChatReceives = new HashMap<>();
        mess = new ArrayList<>();
    }

    
    public void addEventMain(EventMain event) {
        this.eventMain = event;
    }

    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }

    public void addEventChatSend(EventChatSend event) {
        this.eventChatSend = event;
    }

    public void addEventChatReceive(int userId, EventChatReceive event) {
        userEventChatReceives.put(userId, event);
    }

    public void removeEventChatReceive(int userId) {
        userEventChatReceives.remove(userId);
    }
    
    public void addEventLogin(EventLogin event) {
        this.eventLogin = event;
    }

    public void addEventMenuLeft(EventMenuLeft event) {
        this.eventMenuLeft = event;
    }
    
    public void addEventMenuChat(EventMenuChat event) {
        this.eventMenuChat = event;
    }
    


    public EventMain getEventMain() {
        return eventMain;
    }

    public EventImageView getEventImageView() {
        return eventImageView;
    }

    public EventChatSend getEventChatSend() {
        return eventChatSend;
    }
    
    public EventChatReceive getEventChatReceive(int userId) {
        return userEventChatReceives.get(userId);
    }
    
    public void removeEventChatReceive() {
        this.userEventChatReceives.clear();
    }

    public EventLogin getEventLogin() {
        return eventLogin;
    }

    public EventMenuLeft getEventMenuLeft() {
        return eventMenuLeft;
    }
    
    public EventMenuChat getEventMenuChat() {
        return eventMenuChat;
    }
    
    public void setUserID(int id){
        this.userID = id;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
    public List<Model_History_Message> getMess() {
        return mess;
    }
    
    public void setMess(List<Model_History_Message> mess) {
        this.mess = mess;
    }
    
    public void removeMess() {
        this.mess.clear();
    }
}
