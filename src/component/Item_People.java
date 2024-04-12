
package component;

import event.PublicEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Model_User_Account;


public class Item_People extends javax.swing.JPanel {


    public Model_User_Account getUser() {
        return user;
    }

    private boolean mouseOver;
    private final Model_User_Account user;

    public Item_People(Model_User_Account user) {
        initComponents();
        this.user = user;
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.name.setText(user.getUserName());
        init();
        updateStatus(user.getStatus());
        if(this.user.getUserID()==9999){
            this.status.setForeground(new Color(153,153,153));
            this.status.setText("Send to all");
        }
    }

    public void updateStatus(int status){
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
    private void init(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                setBackground(new Color(242,242,242));
                mouseOver = true;
            }
            @Override
            public void mouseExited(MouseEvent me){
                setBackground(new Color(255,255,255));
                mouseOver = false;
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                if (mouseOver) {
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 50));

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setText("Name");

        status.setForeground(new java.awt.Color(0, 204, 51));
        status.setText("Active");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name)
                .addGap(0, 0, 0)
                .addComponent(status)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel name;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
