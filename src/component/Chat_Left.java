
package component;

import java.awt.Color;
import java.io.IOException;
import javax.swing.Icon;
import model.Model_Receive_Image;
import model.Model_Receive_Message;

public class Chat_Left extends javax.swing.JPanel {

    public Chat_Left() {
        initComponents();
        txt.setBackground(new Color(242, 242, 242));
    }

    public void setText(String text) {
        if (text.equals("")) {
            txt.hideText();
        } else {
            txt.setText(text);
        }

    }

    public void setUserProfile(String user) {
        txt.setUserProfile(user);
    }
    
    
    public void setImage(Model_Receive_Image dataImage) {
        txt.setImage(false, dataImage);
    }
    
    public void setFile(Model_Receive_Message data) throws IOException {
        txt.setFile(data);
    }
    
    public void setImage(String dataImage) {
        txt.setImage(false, dataImage);
    }
    
    public void setFile(String data){
        txt.setFile(false, data);
    }
    
    public void setEmoji(Icon icon) {
        txt.hideText();
        txt.setEmoji(false, icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new component.Chat_Item();

        setBackground(new java.awt.Color(255, 255, 255));

        txt.setBackground(new java.awt.Color(202, 240, 248));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
