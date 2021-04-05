/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author S_Ale AKA S0Ale
 */
public class ItemList extends javax.swing.JPanel {
    
    private final CardLayout layout;
    private final JPanel parent;

    /**
     * Creates new form ItemList
     * @param layout
     * @param parent
     */
    public ItemList(CardLayout layout, JPanel parent) {
        this.layout = layout;
        this.parent = parent;
        initComponents();
        jScrollPane1.getVerticalScrollBar().setBackground(new Color(240, 241, 248));
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        HomeBtn = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(231, 233, 242));

        jPanel1.setBackground(new java.awt.Color(246, 248, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 215, 225)));

        HomeBtn.setBackground(new java.awt.Color(248, 250, 255));
        HomeBtn.setForeground(new java.awt.Color(112, 121, 138));
        HomeBtn.setText("Home");
        HomeBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(211, 215, 225)));
        HomeBtn.setFocusPainted(false);
        HomeBtn.setOpaque(true);
        HomeBtn.setRolloverEnabled(false);
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeBtnMouseExited(evt);
            }
        });
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        logOutButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(112, 121, 138));
        logOutButton.setText("Log out");
        logOutButton.setBorder(null);
        logOutButton.setBorderPainted(false);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setFocusable(false);
        logOutButton.setRequestFocusEnabled(false);
        logOutButton.setRolloverEnabled(false);
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
        });
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(HomeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addComponent(logOutButton))
        );

        jPanel3.setBackground(new java.awt.Color(246, 248, 254));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(69, 75, 93));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reperti");
        jLabel2.setToolTipText("");

        jScrollPane1.setBackground(new java.awt.Color(238, 240, 250));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        itemsPanel.setBackground(new java.awt.Color(238, 240, 250));
        itemsPanel.setLayout(null);
        jScrollPane1.setViewportView(itemsPanel);

        jPanel2.setBackground(new java.awt.Color(246, 248, 254));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(112, 121, 138));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(211, 215, 225)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(112, 121, 138));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Larghezza");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(211, 215, 225)));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(112, 121, 138));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Altezza");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(211, 215, 225)));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(112, 121, 138));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Profondità");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(211, 215, 225)));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(112, 121, 138));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        refreshButton.setBackground(new java.awt.Color(246, 248, 254));
        refreshButton.setForeground(new java.awt.Color(112, 121, 138));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redo.png"))); // NOI18N
        refreshButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));
        refreshButton.setFocusPainted(false);
        refreshButton.setOpaque(true);
        refreshButton.setRolloverEnabled(false);
        refreshButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshButtonMouseExited(evt);
            }
        });
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        layout.show(parent, "items");
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void HomeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseEntered
        HomeBtn.setBackground(ColorManager.getInstance().getColor("btnHover"));
        HomeBtn.setForeground(ColorManager.getInstance().getColor("txt"));
        HomeBtn.setBorder(new MatteBorder(0, 0, 0, 2, ColorManager.getInstance().getColor("color1")));
    }//GEN-LAST:event_HomeBtnMouseEntered

    private void HomeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBtnMouseExited
        HomeBtn.setBackground(ColorManager.getInstance().getColor("boxColor"));
        HomeBtn.setForeground(ColorManager.getInstance().getColor("txtInactive"));
        HomeBtn.setBorder(new MatteBorder(0, 0, 0, 1, ColorManager.getInstance().getColor("border")));
    }//GEN-LAST:event_HomeBtnMouseExited

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        updateItemPanel();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void refreshButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseEntered
        refreshButton.setBackground(ColorManager.getInstance().getColor("btnHover"));
        refreshButton.setForeground(ColorManager.getInstance().getColor("color2Strong"));
    }//GEN-LAST:event_refreshButtonMouseEntered

    private void refreshButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseExited
        refreshButton.setBackground(ColorManager.getInstance().getColor("boxColor"));
        refreshButton.setForeground(ColorManager.getInstance().getColor("txtInactive"));
    }//GEN-LAST:event_refreshButtonMouseExited

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        logOutButton.setForeground(ColorManager.getInstance().getColor("color2Strong"));
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        logOutButton.setForeground(ColorManager.getInstance().getColor("txtInactive"));
    }//GEN-LAST:event_logOutButtonMouseExited

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        layout.show(parent, "login");
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void updateItemPanel(){
        itemsPanel.removeAll();
        int n = 5;
        for(int i = 0; i < n; i++){
            itemsPanel.setPreferredSize(new Dimension(jScrollPane1.getWidth(), (i + 1) * 32));
            itemsPanel.setSize(new Dimension(jScrollPane1.getWidth(), (i + 1) * 32));
            JPanel panel = buildItemPanel(0, i * 32, "Nome", "Larghezza", "Altezza", "Profondità");
            if(i == n - 1) panel.setBorder(new MatteBorder(0, 0, 1, 0, ColorManager.getInstance().getColor("border")));
            itemsPanel.add(panel);
        }
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }
    
    private JPanel buildItemPanel(int x, int y, String name, String width, String height, String depth){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setLocation(x, y);
        panel.setBackground(ColorManager.getInstance().getColor("boxColor"));
        panel.setPreferredSize(new Dimension(jScrollPane1.getWidth(), 32));
        panel.setSize(new Dimension(jScrollPane1.getWidth(), 32));
        
        JLabel[] labels = {new JLabel(name), new JLabel(width), new JLabel(height), new JLabel(depth)};
        
        int size = labels.length;
        for(int i = 0; i < size; i++){
            labels[i].setPreferredSize(new Dimension(250, 32));
            labels[i].setSize(new Dimension(250, 32));
            labels[i].setLocation(i * 250, 0);
            labels[i].setBackground(ColorManager.getInstance().getColor("boxColor"));
            labels[i].setForeground(ColorManager.getInstance().getColor("txtInactive"));
            labels[i].setBorder(new MatteBorder(0, 0, 0, 1, ColorManager.getInstance().getColor("border")));
            labels[i].setHorizontalAlignment(JLabel.CENTER);
            panel.add(labels[i]);
        }
        
        panel.add(new ViewButton(1075, 5));
        
        return panel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeBtn;
    private javax.swing.JPanel itemsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton refreshButton;
    // End of variables declaration//GEN-END:variables
}
