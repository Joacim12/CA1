package view;

import control.Controller;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;

/**
 *
 * @author joaci
 */
public class JFrame extends javax.swing.JFrame implements Observer {

    private Controller control;
    String msg = "";
    Boolean first = true;
    List<String> clients;
    DefaultListModel<String> model = new DefaultListModel<>();
    String userSelected = "ALL";
    String username = "";

    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
        initGui();
        
    }
    
    public void initGui(){
        jTabbedPane1.remove(jPanel2);
        clients = new ArrayList();
        clients.add("Skriv til alle");
        jUserList.removeAll();
        jUserList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelError = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabelError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldServer = new javax.swing.JTextField();
        jTextFieldPort = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jTextFieldMessage = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jUserList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jTextField1.setText("1");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel3.setText("Server:");

        jLabel4.setText("Port:");

        jTextFieldServer.setText("vetterlain.dk");
        jTextFieldServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldServerActionPerformed(evt);
            }
        });

        jTextFieldPort.setText("8081");

        javax.swing.GroupLayout jPanelErrorLayout = new javax.swing.GroupLayout(jPanelError);
        jPanelError.setLayout(jPanelErrorLayout);
        jPanelErrorLayout.setHorizontalGroup(
            jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelErrorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelErrorLayout.createSequentialGroup()
                            .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldPort)
                                .addComponent(jTextFieldServer)))))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanelErrorLayout.setVerticalGroup(
            jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanelError);

        jTextAreaChat.setColumns(20);
        jTextAreaChat.setRows(5);
        jTextAreaChat.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaChat);

        jTextFieldMessage.setText("Write something");
        jTextFieldMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldMessageMouseClicked(evt);
            }
        });
        jTextFieldMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMessageKeyPressed(evt);
            }
        });

        jUserList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUserListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jUserList);

        jLabel2.setText("Users - Click on user to chat");

        jButton2.setText("Send");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addComponent(jTextFieldMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Chat", jPanel2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void signIn() {
        control = new Controller(jTextFieldServer.getText(), Integer.parseInt(jTextFieldPort.getText()));
        control.getMessageHandler().addObserver(this);
        Thread t = new Thread(() -> {
            control.readMessage();
        });
        t.start();
        control.login(jTextField1.getText());
    }

    public void sendMessage() {
        if ((jTextFieldMessage != null) && (!jTextFieldMessage.getText().equals(""))) {
            if (userSelected.equals("Skriv til alle")) {
                userSelected = "ALL";
            }
            String msgPrivate = "";
            if (!userSelected.equals("ALL")) {
                msgPrivate = " [Private: " + userSelected + "]";
            }
            jTextAreaChat.append(username + msgPrivate + ": " + jTextFieldMessage.getText() + "\n");
            control.sendMessage("MSG#" + userSelected + "#" + jTextFieldMessage.getText());
            jTextFieldMessage.setText(null);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        signIn();
        initGui();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserListMouseClicked
        userSelected = clients.get(jUserList.getSelectedIndex());
    }//GEN-LAST:event_jUserListMouseClicked

    private void jTextFieldMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldMessageMouseClicked
        jTextFieldMessage.setText("");
    }//GEN-LAST:event_jTextFieldMessageMouseClicked

    private void jTextFieldMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMessageKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            sendMessage();
        }
    }//GEN-LAST:event_jTextFieldMessageKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            signIn();            
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sendMessage();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldServerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFrame().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelError;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldMessage;
    private javax.swing.JTextField jTextFieldPort;
    private javax.swing.JTextField jTextFieldServer;
    private javax.swing.JList<String> jUserList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object line) {
        msg = (String) line;           
        String msgArr[] = msg.split("#");
        switch (msgArr[0].toLowerCase()) {
            case "msg":
                if (!msgArr[1].equals(username)) {
                    jTextAreaChat.append(msgArr[1] + ": " + msgArr[2] + "\n");
                }
                break;
            case "ok":
                jTabbedPane1.remove(jPanelError);
                jTabbedPane1.add(jPanel2);
                username = msgArr[msgArr.length - 1];
                jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), username);                
                for (int i = 1; i < msgArr.length; i++) {
                    clients.add(msgArr[i]);
                }
                model.removeAllElements();
                clients.forEach((client) -> {
                    model.addElement(client);
                });
                jUserList.setModel(model);
                break;
            case "update":
                if (!first) {
                    clients.add(msgArr[1]);
                    model.addElement(msgArr[1]);
                    jUserList.setModel(model);
                }
                first = false;
                break;
            case "fail":
                jLabelError.setText("Something went wrong");
                break;
            case "delete":
                clients.remove(msgArr[1]);
                model.removeElement(msgArr[1]);
                jUserList.setModel(model);
                break;
            case "dc":
                jTabbedPane1.remove(jPanel2);
                jTabbedPane1.add(jPanelError);
        }
    }
}
