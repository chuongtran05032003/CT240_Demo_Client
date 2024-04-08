/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import component.Item_People;
import event.EventMenuLeft;

import event.PublicEvent;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import model.Model_User_Account;


import net.miginfocom.swing.MigLayout;
import service.Service;
import swing.ScrollBar;

/**
 *
 * @author Chuong Tran
 */
public class Menu_List extends javax.swing.JPanel {


    public List<Model_User_Account> getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(List<Model_User_Account> userAccount) {
        this.userAccount = userAccount;
    }

    private List<Model_User_Account> userAccount;  
    
    public Menu_List() {
        initComponents();
        init();
    }

    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menu_List.setLayout(new MigLayout("fillx","0[]0", "0[]0"));     
        setUserAccount(new ArrayList<>());
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                for (Model_User_Account d : users) {
                    getUserAccount().add(d);
                    if(btn_mess.isSelected()){
                        showMess();
                    }
                }
            }
            @Override
            public void User(Model_User_Account user){
                username.setText(user.getUserName().toUpperCase());
            }
            @Override
            public void userConnect(int userID) {
                for (Model_User_Account u : getUserAccount()) {
                    if (u.getUserID() == userID) {
                        u.setStatus(1);
                        break;
                    }
                }
                for (Component com : menu_List.getComponents()) {
                    Item_People item = (Item_People) com;
                    if (item.getUser().getUserID() == userID) {
                        item.updateStatus(1);
                        break;
                    }
                }
                if (btn_mess.isSelected()) {
                    showMess();
                } else if (btn_contact.isSelected()) {
                    showContact();
                } else if (btn_group.isSelected()) {
                    showGroup();
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : getUserAccount()) {
                    if (u.getUserID() == userID) {
                        u.setStatus(0);
                        break;
                    }
                }
                for (Component com : menu_List.getComponents()) {
                    Item_People item = (Item_People) com;
                    if (item.getUser().getUserID() == userID) {
                        item.updateStatus(0);
                        break;
                    }
                }
                
                if (btn_mess.isSelected()) {
                    showMess();
                } else if (btn_contact.isSelected()) {
                    showContact();
                } else if (btn_group.isSelected()) {
                    showGroup();
                }
            }
        });
        
    }
    
    public void showContact(){
        menu_List.removeAll();
        for (Model_User_Account d : getUserAccount()) {
            if( d.getUserID()!= 1000){
                menu_List.add(new Item_People(d), "wrap");
            }
        }
        refreshMenuList();
    }
    
    public void showMess(){
        menu_List.removeAll();
        for (Model_User_Account d : getUserAccount()) {
            if(d.getStatus() == 1){
                menu_List.add(new Item_People(d), "wrap");
            }
            
        }
        refreshMenuList();
    }
    
    public void showGroup(){
        menu_List.removeAll();
        for (Model_User_Account d : getUserAccount()) {
            if(d.getUserID() == 1000){
                menu_List.add(new Item_People(d), "wrap");
            }
            
        }
        refreshMenuList();
    }
    
    public void refreshMenuList(){
        menu_List.repaint();
        menu_List.revalidate();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuButton1 = new component.MenuButton();
        menuButton2 = new component.MenuButton();
        menuButton3 = new component.MenuButton();
        menuButton4 = new component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menu_List = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btn_mess = new component.MenuButton();
        btn_contact = new component.MenuButton();
        btn_group = new component.MenuButton();
        logout = new component.MenuButton();
        jPanel2 = new javax.swing.JPanel();
        username = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menu_List.setBackground(new java.awt.Color(255, 255, 255));
        menu_List.setOpaque(true);

        javax.swing.GroupLayout menu_ListLayout = new javax.swing.GroupLayout(menu_List);
        menu_List.setLayout(menu_ListLayout);
        menu_ListLayout.setHorizontalGroup(
            menu_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        menu_ListLayout.setVerticalGroup(
            menu_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        sp.setViewportView(menu_List);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLayeredPane1.setLayout(new javax.swing.BoxLayout(jLayeredPane1, javax.swing.BoxLayout.Y_AXIS));

        btn_mess.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/message_selected.png"))); // NOI18N
        btn_mess.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/message.png"))); // NOI18N
        btn_mess.setSelected(true);
        btn_mess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_messMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_messMouseEntered(evt);
            }
        });
        btn_mess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_messActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_mess);

        btn_contact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/contact.png"))); // NOI18N
        btn_contact.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/contact_selected.png"))); // NOI18N
        btn_contact.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/contact.png"))); // NOI18N
        btn_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_contactMouseClicked(evt);
            }
        });
        btn_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_contactActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_contact);

        btn_group.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        btn_group.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/group_selected.png"))); // NOI18N
        btn_group.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        btn_group.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_groupMouseClicked(evt);
            }
        });
        btn_group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_groupActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btn_group);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(102, 102, 102));
        username.setText("USER NAME");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_messMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_messMouseClicked

    }//GEN-LAST:event_btn_messMouseClicked

    private void btn_messMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_messMouseEntered

    }//GEN-LAST:event_btn_messMouseEntered

    private void btn_messActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_messActionPerformed
        if(!btn_mess.isSelected()){
            btn_mess.setSelected(true);
            btn_group.setSelected(false);
            btn_contact.setSelected(false);
            showMess();
        }
    }//GEN-LAST:event_btn_messActionPerformed

    private void btn_contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_contactMouseClicked

    }//GEN-LAST:event_btn_contactMouseClicked

    private void btn_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_contactActionPerformed
        if(!btn_contact.isSelected()){
            btn_mess.setSelected(false);
            btn_group.setSelected(false);
            btn_contact.setSelected(true);
            showContact();
        }
    }//GEN-LAST:event_btn_contactActionPerformed

    private void btn_groupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_groupMouseClicked

    }//GEN-LAST:event_btn_groupMouseClicked

    private void btn_groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_groupActionPerformed
        if(!btn_group.isSelected()){
            btn_mess.setSelected(false);
            btn_group.setSelected(true);
            btn_contact.setSelected(false);
            showGroup();
        }
    }//GEN-LAST:event_btn_groupActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        menu_List.removeAll();
        refreshMenuList();
        getUserAccount().removeAll(getUserAccount());
        PublicEvent.getInstance().getEventMain().logout();
        Service.getInstance().disconnectFromServer();
        Service.getInstance().startServer();
    }//GEN-LAST:event_logoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.MenuButton btn_contact;
    private component.MenuButton btn_group;
    private component.MenuButton btn_mess;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private component.MenuButton logout;
    private component.MenuButton menuButton1;
    private component.MenuButton menuButton2;
    private component.MenuButton menuButton3;
    private component.MenuButton menuButton4;
    private javax.swing.JLayeredPane menu_List;
    private javax.swing.JScrollPane sp;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
