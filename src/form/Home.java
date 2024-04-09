
package form;

import component.ChatLs;
import component.Item_People;
import event.EventMenuChat;
import event.EventMenuLeft;
import event.PublicEvent;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_History_Message;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;


public class Home extends javax.swing.JLayeredPane {

    public List<ChatLs> getChatls() {
        return chatls;
    }

    public void setChatls(List<ChatLs> chatls) {
        this.chatls = chatls;
    }

    public Menu_List getMenuList() {
        return menuList;
    }

    public void setMenuList(Menu_List menuList) {
        this.menuList = menuList;
    }

    
    private Menu_List menuList;
    private Chat chat;
    private List<ChatLs> chatls;
    private int numberUser;
    public Home() {
        initComponents();
        init();
        
    }
    
    private void init(){
        setLayout(new MigLayout("fillx, filly","0[250!]0[fill, 100%]0","0[fill]0"));
        menuList = new Menu_List();
        chatls = new ArrayList<>();
        chat = new Chat();
        this.add(menuList);
        this.add(chat);
        chat.setVisible(false);
        
    }

    public void initChat(){
        numberUser = 0;
        PublicEvent.getInstance().addEventMenuChat(new EventMenuChat() {
            @Override
            public void listUser(List<Model_User_Account> users) {
                for (Model_User_Account user : users) {
                    Chat chat = new Chat();
                    chatls.add(new ChatLs(chat, 0));
                }
                    for (Model_User_Account user : users) {
                        chatls.get(numberUser).getChat().setUser(user);
                        chatls.get(numberUser).setUserID(user.getUserID());
                    try {
                        chatls.get(numberUser).getChat().startReceive();
                    } catch (IOException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        numberUser++;
                    }
            }
        });

    }

    public void setUser(Model_User_Account user) {
        this.removeAll();
        this.repaint();
        this.revalidate();
        
        int index = findChatIndex(user.getUserID());
        this.add(menuList);
        Chat chat = getChatls().get(index).getChat();
        chat.startSend();
        this.add(chat);
    }

    private int findChatIndex(int id){
        int index = -1;
        for (int i = 0; i < getChatls().size(); i++) {
            if (getChatls().get(i).getUserID() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateUser(Model_User_Account user) {
        int index = findChatIndex(user.getUserID());
        getChatls().get(index).getChat().updateUser(user);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
