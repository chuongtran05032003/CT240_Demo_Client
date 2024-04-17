
package form;

import event.EventLogin;
import event.EventMessage;

import event.PublicEvent;
import io.socket.client.Ack;
import model.Model_Login;
import model.Model_Message;
import model.Model_Register;
import model.Model_User_Account;
import service.Service;



public class Login extends javax.swing.JPanel {


    public Login() {
        initComponents();
        init();
    }
    
    private void init() {
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            
            @Override
            public void login(Model_Login data, EventMessage message) {
                Service.getInstance().getClient().emit("login", data.toJsonObject(), new Ack() {
                    @Override
                    public void call(Object... os) {
                        if (os.length > 0) {
                            Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());
                            if (ms.isAction()) {
                                Service.getInstance().setUser(new Model_User_Account(os[2]));
                                message.callMessage(ms);
                            }else{
                                message.callMessage(ms);
                            }
                        }
                    }
                });
            }

            @Override
            public void register(Model_Register data, EventMessage message) {
                Service.getInstance().getClient().emit("register", data.toJsonObject(), new Ack() {
                    @Override
                    public void call(Object... os) {
                        if (os.length > 0) {
                            Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());
                            if (ms.isAction()) {
                                Service.getInstance().setUser(new Model_User_Account(os[2]));
                                message.callMessage(ms);
                            }else{
                                message.callMessage(ms);
                            }
                        }
                    }
                });
            }


            @Override
            public void goRegister() {
                slide.show(1);
            }

            @Override
            public void goLogin() {
                slide.show(0);
            }
        });
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        slide.init(login, register);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slide = new swing.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
