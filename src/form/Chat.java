
package form;

import component.Chat_Body;
import component.Chat_Bottom;
import component.Chat_Top;

import event.EventChatReceive;
import event.EventChatSend;
import event.PublicEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_History_Message;
import model.Model_Receive_Message;
import model.Model_Send_Message;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import service.Service;

public class Chat extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }

    private Chat_Top chatTitle;
    private Chat_Body chatBody;
    private Chat_Bottom chatBottom;
    private Model_User_Account user;
    
    public Chat(){
        initComponents();
        init();
        
    }
     private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]1[100%, fill]1[shrink 0]0"));
        chatTitle = new Chat_Top();
        chatBody = new Chat_Body();
        chatBottom = new Chat_Bottom();

        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");
        
    }
     
    public void setUser(Model_User_Account user){
        this.user = new Model_User_Account(user);
        chatTitle.setUser(this.user);
        chatBottom.setUser(this.user);
        
    }
    public void startSend() {
        PublicEvent.getInstance().addEventChatSend(new EventChatSend() {
            @Override
            public void sendMessage(Model_Send_Message data) {
                chatBody.addItemRight(data);
            }
        });
    }

    

    public void startReceive() throws IOException {
        PublicEvent publicEvent = PublicEvent.getInstance();
        if (publicEvent != null) {
            publicEvent.addEventChatReceive(user.getUserID(), new EventChatReceive() {
                @Override
                public void receiveMessage(Model_Receive_Message data) {
                    if (data.getUserID() == PublicEvent.getInstance().getUserID()) {
                        try {
                            chatBody.addItemLeft(data);
                        } catch (IOException ex) {
                            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
        }
        List<Model_History_Message> list = PublicEvent.getInstance().getMess();
        if(list.size() != 0){
            for(Model_History_Message mess : list){
                if(mess.getToUserID() == user.getUserID() && mess.getFromUserID() == Service.getInstance().getUser().getUserID() && mess.getSide() == 1){
                    chatBody.addItemRight(mess);
                }else if(mess.getToUserID() == Service.getInstance().getUser().getUserID() && mess.getFromUserID() == user.getUserID() && mess.getSide() == 0){
                    chatBody.addItemLeft(mess);
                }
            }
        }
    }

    public void updateUser(Model_User_Account user) {
        chatTitle.updateStatus(user.getStatus());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
