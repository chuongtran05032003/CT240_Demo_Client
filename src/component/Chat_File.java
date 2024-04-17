
package component;

import event.EventFileReceiver;
import event.EventFileSender;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Model_File_Sender;
import model.Model_Receive_Message;
import service.Service;

public class Chat_File extends javax.swing.JPanel {
    
    private File file;
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public Chat_File() {
        initComponents();
        setOpaque(false);
    }

    public void setFileL(String fileName){
        progress.setVisible(false);
        String fn = "client_data/" + fileName;
        file = new File(fn);
        if (fileName.contains("_")) {
            lbFileName.setText(file.getName().substring(file.getName().indexOf("_") + 1));
        } else {
            lbFileName.setText(file.getName());
        }
        
        setSize(file.length());
        addEvent(file);
        setFile(file);
    }
    
    public void setFileR(String fileName){
        progress.setVisible(false);
        String fn = "client_data/" + fileName;
        file = new File(fn);
        if (fileName.contains("_")) {
            lbFileName.setText(file.getName().substring(file.getName().indexOf("_") + 1));
        } else {
            lbFileName.setText(file.getName());
        }
        
        setSize(file.length());
        addEvent(file);
        setFile(file);
    }
    
    public void setFile(Model_Receive_Message fileReceiver) throws IOException {
        try {
            Service.getInstance().addFileReceiver(fileReceiver.getDataImage().getFileID(), new EventFileReceiver() {
                @Override
                public void onReceiving(double percentage) {
                    progress.setValue((int) percentage);
                }

                @Override
                public void onStartReceiving() {
                    
                }

                @Override
                public void onFinish(File file) {
                    progress.setVisible(false);
                    lbFileName.setText(file.getName().substring(file.getName().indexOf("_") + 1));
                    setSize(file.length());
                    addEvent(file);
                    setFile(file);
                    
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public void setFile(Model_File_Sender fileSender) {
        fileSender.addEvent(new EventFileSender() {
            @Override
            public void onSending(double percentage) {
                progress.setValue((int) percentage);
            }

            @Override
            public void onStartSending() {
            }

            @Override
            public void onFinish() {
                progress.setVisible(false);
                setFile(fileSender.getFile());
            }
        });
        lbFileName.setText(fileSender.getFile().getName());
        long fileSize = fileSender.getFileSize();
        setSize(fileSize);
        addEvent(fileSender.getFile());
    }
    private void setSize(long fileSize){
        String fileSizeStr;
        if (fileSize < 1024) {
            fileSizeStr = fileSize + " bytes";
        } else if (fileSize < 1024 * 1024) {
            double sizeKB = fileSize / 1024.0;
            fileSizeStr = String.format("%.2f KB", sizeKB);
        } else if (fileSize < 1024 * 1024 * 1024) {
            double sizeMB = fileSize / (1024.0 * 1024.0);
            fileSizeStr = String.format("%.2f MB", sizeMB);
        } else {
            double sizeGB = fileSize / (1024.0 * 1024.0 * 1024.0);
            fileSizeStr = String.format("%.2f GB", sizeGB);
        }
        lbFileSize.setText(fileSizeStr);
    }
    private void addEvent(File file) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                     try {
                        // Kiểm tra xem hệ thống có hỗ trợ mở tệp không
                        if (Desktop.isDesktopSupported()) {
                            // Mở tệp sử dụng ứng dụng mặc định của hệ thống
                            Desktop.getDesktop().open(file);
                        } else {
                            System.out.println("Desktop is not supported.");
                        }
                    } catch (IOException e) {
                        // Xử lý các ngoại lệ nếu có
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    
    
    
    private static String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex != -1) {
            return filename.substring(dotIndex + 1);
        }
        return "";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progress = new swing.Progress();
        jPanel1 = new javax.swing.JPanel();
        lbFileName = new javax.swing.JLabel();
        lbFileSize = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        progress.setForeground(new java.awt.Color(0, 51, 255));
        progress.setProgressType(swing.Progress.ProgressType.FILE);

        jPanel1.setOpaque(false);

        lbFileName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbFileName.setText("My File Name");

        lbFileSize.setForeground(new java.awt.Color(0, 51, 255));
        lbFileSize.setText("5 MB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lbFileSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbFileName)
                .addGap(0, 0, 0)
                .addComponent(lbFileSize))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/download.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showDialog(null, "Select");

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String fileName = getFile().getName();
            String fileExtension = getFileExtension(fileName);
            File fileToSaveInDirectory = new File(selectedDirectory, fileName);

            try {
                FileInputStream inputStream = new FileInputStream(getFile());
                FileOutputStream outputStream = new FileOutputStream(fileToSaveInDirectory);
                byte[] buffer = new byte[1024];
                int length;

                // Đọc từng phần và ghi vào file đích
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }

                inputStream.close();
                outputStream.close();

                JOptionPane.showMessageDialog(null, "File đã được lưu thành công.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFileName;
    private javax.swing.JLabel lbFileSize;
    private swing.Progress progress;
    // End of variables declaration//GEN-END:variables


    
}
