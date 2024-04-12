
package component;

import app.MessageType;
import emoji.Emoji;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollBar;
import model.Model_History_Message;
import model.Model_Receive_Message;
import model.Model_Send_Message;
import net.miginfocom.swing.MigLayout;
import service.Service;
import swing.ScrollBar;


public class Chat_Body extends javax.swing.JPanel {

    public List<Chat_Left> itemLeft;
    public List<Chat_Right> itemRight;
    
    public Chat_Body() {
        initComponents();
        init();
    }

    private void init() {
        body.setLayout(new MigLayout("fillx", "", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        itemLeft = new ArrayList<>();
        itemRight = new ArrayList<>();
    }
    
    public void addItemLeft(Model_Receive_Message data) throws IOException {
        if (data.getMessageType() == MessageType.TEXT) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getUserName());
            item.setText(data.getText());
            body.add(item, "wrap, w 100::80%");
            itemLeft.add(item);
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getUserID(), data.getUserName(), 1, data.getText(), 0);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        } else if (data.getMessageType() == MessageType.EMOJI) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getUserName());
            item.setEmoji(Emoji.getInstance().getImoji(Integer.parseInt(data.getText())).getIcon());
            body.add(item, "wrap, w 100::80%");
            itemLeft.add(item);
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getUserID(), data.getUserName(), 2, data.getText(), 0);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        }else if (data.getMessageType() == MessageType.IMAGE) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getUserName());
            item.setText("");
            item.setImage(data.getDataImage());
            body.add(item, "wrap, w 100::80%");
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getUserID(), data.getUserName(), 3, data.getDataImage().getFileID() +"_"+ data.getDataImage().getFileName(), 0);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        }else if(data.getMessageType() == MessageType.FILE) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getUserName());
            item.setText("");
            item.setFile(data);
            body.add(item, "wrap, w 100::80%");
            itemLeft.add(item);
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getUserID(), data.getUserName(), 4, data.getDataImage().getFileID()+"_"+data.getDataImage().getFileName(), 0);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        }
        repaint();
        revalidate();
    }
    
    public void addItemLeft(Model_History_Message data) throws IOException {
        if (data.getMessageType() == 1) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getName());
            item.setText(data.getMess());
            body.add(item, "wrap, w 100::80%");
            itemLeft.add(item);
        } else if (data.getMessageType() == 2) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getName());
            item.setEmoji(Emoji.getInstance().getImoji(Integer.parseInt(data.getMess())).getIcon());
            body.add(item, "wrap, w 100::80%");
            itemLeft.add(item);
        }else if (data.getMessageType() == 3) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getName());
            item.setText("");
            item.setImage(data.getMess());
            body.add(item, "wrap, w 100::80%");
        }else if(data.getMessageType() == 4) {
            Chat_Left item = new Chat_Left();
            item.setUserProfile(data.getName());
            item.setText("");
            item.setFile(data.getMess());
            body.add(item, "wrap, w 100::80%");
            itemLeft.add(item);
        }
        repaint();
        revalidate();
    }
    
    public void addItemRight(Model_History_Message data) {
        if (data.getMessageType() == 1) {
            Chat_Right item = new Chat_Right();
            item.setText(data.getMess());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
        } else if (data.getMessageType() == 2) {
            Chat_Right item = new Chat_Right();
            item.setEmoji(Emoji.getInstance().getImoji(Integer.valueOf(data.getMess())).getIcon());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
        }
        else if (data.getMessageType() == 3) {
            Chat_Right item = new Chat_Right();
            item.setText("");
            item.setImage(data.getMess());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
        }else if(data.getMessageType() == 4){
            Chat_Right item = new Chat_Right();
            item.setText("");
            item.setFile(data.getMess());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
        }
        repaint();
        revalidate();
        scrollToBottom();
    }
    
    public void addItemRight(Model_Send_Message data) {
        if (data.getMessageType() == MessageType.TEXT) {
            Chat_Right item = new Chat_Right();
            item.setText(data.getText());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getToUserID(), data.getUserName(), 1, data.getText(), 1);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        } else if (data.getMessageType() == MessageType.EMOJI) {
            Chat_Right item = new Chat_Right();
            item.setEmoji(Emoji.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getToUserID(), data.getUserName(), 2, data.getText(), 1);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        } else if (data.getMessageType() == MessageType.IMAGE) {
            Chat_Right item = new Chat_Right();
            item.setText("");
            item.setImage(data.getFile());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
            Model_History_Message mess = new Model_History_Message(data.getFromUserID(), data.getToUserID(), data.getUserName(), 3, data.getFile().getFileName(), 1);
            Service.getInstance().getClient().emit("saveMessage", mess.toJsonObject());
        }else if(data.getMessageType() == MessageType.FILE){
            Chat_Right item = new Chat_Right();
            item.setText("");
            item.setFile(data.getFile());
            body.add(item, "wrap, al right, w 100::80%");
            itemRight.add(item);
        }
        repaint();
        revalidate();
        scrollToBottom();
    }
    
    
    
    public void clearChat() {
        body.removeAll();
        repaint();
        revalidate();
    }
    
    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
