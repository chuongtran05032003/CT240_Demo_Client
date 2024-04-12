
package component;

import javax.swing.Icon;
import model.Model_File_Sender;


public class Chat_Right extends javax.swing.JPanel {


    public Chat_Right() {
        initComponents();
    }

    public void setText(String text) {
        if (text.equals("")) {
            txt.hideText();
        } else {
            txt.setText(text);
        }

    }
    
    public void setImage(Model_File_Sender fileSender) {
        txt.setImage(true, fileSender);
    }

    public void setFile(Model_File_Sender fileSender) {
        txt.setFile(fileSender);
    }
    
    public void setImage(String fileSender) {
        txt.setImage(true, fileSender);
    }

    public void setFile(String fileSender) {
        txt.setFile(true, fileSender);
    }
    
    public void setEmoji(Icon icon) {
        txt.hideText();
        txt.setEmoji(true, icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new component.Chat_Item();

        setBackground(new java.awt.Color(255, 255, 255));

        txt.setBackground(new java.awt.Color(72, 202, 228));

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
