/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package component;

import java.awt.Color;
import model.Model_User_Account;

/**
 *
 * @author Chuong Tran
 */
public class Chat_Top extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }

    private Model_User_Account user;
    
    public void setUser(Model_User_Account user) {
        this.user = new Model_User_Account(user);
        name.setText(this.user.getUserName());
        if(getUser().getStatus()==1){
            this.status.setForeground(new Color(0,204,51));
            this.status.setText("Active");
        }else if(getUser().getStatus()==0){
            this.status.setForeground(Color.red);
            this.status.setText("Inactive");
        }
        if(this.user.getUserID()==9999){
            this.status.setForeground(new Color(153,153,153));
            this.status.setText("Send to all");
        }
    }
    
    public void updateStatus(int status) {
        this.user.setStatus(status);
        if(getUser().getStatus()==1){
            this.status.setForeground(new Color(0,204,51));
            this.status.setText("Active");
        }else if(getUser().getStatus()==0){
            this.status.setForeground(new Color(153,153,153));
            this.status.setText("Offline");
        }
        if(this.user.getUserID()==9999){
            this.status.setForeground(new Color(153,153,153));
            this.status.setText("Send to all");
        }
    }
    
    public Chat_Top() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        name = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setText("Name");

        status.setForeground(new java.awt.Color(0, 204, 0));
        status.setText("Active");

        jLayeredPane1.setLayer(name, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(status, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name)
                .addGap(0, 0, 0)
                .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
