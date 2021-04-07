/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author S_Ale AKA S0Ale
 */
public class LoginPanel extends javax.swing.JPanel {
    
    private AppWindow window;

    /**
     * Creates new form LoginPanel
     * @param window
     */
    public LoginPanel(AppWindow window) {
        this.window = window;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ticketField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JPanel();

        setBackground(new java.awt.Color(231, 233, 242));

        jPanel1.setBackground(new java.awt.Color(246, 248, 254));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));

        ticketField.setBackground(new java.awt.Color(238, 240, 250));
        ticketField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ticketField.setForeground(new java.awt.Color(112, 121, 138));
        ticketField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ticketField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(211, 215, 225)));
        ticketField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ticketField.setMargin(new java.awt.Insets(2, 32, 2, 6));
        ticketField.setName(""); // NOI18N
        ticketField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ticketFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ticketFieldFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(112, 121, 138));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ticket.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(112, 121, 138));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/key.png"))); // NOI18N

        passwordField.setBackground(new java.awt.Color(238, 240, 250));
        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passwordField.setForeground(new java.awt.Color(112, 121, 138));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passwordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(211, 215, 225)));
        passwordField.setMargin(new java.awt.Insets(2, 32, 2, 6));
        passwordField.setName(""); // NOI18N
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(69, 75, 93));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        submitButton.setBackground(new java.awt.Color(248, 250, 255));
        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        submitButton.setForeground(new java.awt.Color(112, 121, 138));
        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));
        submitButton.setFocusPainted(false);
        submitButton.setOpaque(true);
        submitButton.setRolloverEnabled(false);
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButtonMouseExited(evt);
            }
        });
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        errorLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 102, 102));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ticketField, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                            .addComponent(passwordField))))))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ticketField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuBar.setBackground(new java.awt.Color(246, 248, 254));
        menuBar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 215, 225)));

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(465, Short.MAX_VALUE))
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseEntered
        submitButton.setBackground(ColorManager.getInstance().getColor("btnHover"));
        submitButton.setForeground(ColorManager.getInstance().getColor("txt"));
        submitButton.setBorder(new LineBorder(ColorManager.getInstance().getColor("color1")));
    }//GEN-LAST:event_submitButtonMouseEntered

    private void submitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseExited
        submitButton.setBackground(ColorManager.getInstance().getColor("boxColor"));
        submitButton.setForeground(ColorManager.getInstance().getColor("txtInactive"));
        submitButton.setBorder(new LineBorder(ColorManager.getInstance().getColor("border")));
    }//GEN-LAST:event_submitButtonMouseExited

    private void ticketFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ticketFieldFocusGained
        ticketField.setBorder(new MatteBorder(0, 0, 2, 0, ColorManager.getInstance().getColor("color1")));
        errorLabel.setText("");
    }//GEN-LAST:event_ticketFieldFocusGained

    private void ticketFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ticketFieldFocusLost
        ticketField.setBorder(new MatteBorder(0, 0, 2, 0, ColorManager.getInstance().getColor("border")));
    }//GEN-LAST:event_ticketFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        passwordField.setBorder(new MatteBorder(0, 0, 2, 0, ColorManager.getInstance().getColor("color2")));
        errorLabel.setText("");
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        passwordField.setBorder(new MatteBorder(0, 0, 2, 0, ColorManager.getInstance().getColor("border")));
    }//GEN-LAST:event_passwordFieldFocusLost

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        checkTicket();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void checkTicket(){
        String ticket = ticketField.getText();
        char[] psw = passwordField.getPassword();
        //System.out.println(ticket);
        //System.out.println(Arrays.toString(psw));
        String password = "";
        for(int i = 0; i < psw.length; i++)
            password += psw[i];
        
        ticketField.setText("");
        passwordField.setText("");
        
        
        
        if(ticket.equals("") || psw.length == 0) errorLabel.setText("Please fill all fields.");
        else{
            //richiesta al db
            boolean s = window.getController().login(ticket, password);
            //System.out.println(s);
            if(s)
                window.showItemsPanel();
            else
                errorLabel.setText("No match");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel menuBar;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField ticketField;
    // End of variables declaration//GEN-END:variables
}
