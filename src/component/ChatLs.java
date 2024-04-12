
package component;

import form.Chat;



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
