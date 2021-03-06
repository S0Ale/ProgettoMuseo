/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.SoundPlayer;
import Logic.ViewWorld;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.j3d.Canvas3D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author S_Ale AKA S0Ale
 */
public class ViewPanel extends javax.swing.JPanel {
    
    private final AppWindow window;
    
    private ViewWorld world;
    
    private Canvas3D viewWindow;
    private SoundPlayer player;
    private Timer audioTimer;

    /**
     * Creates new form VisualizerPanel
     * @param window
     */
    
    public ViewPanel(AppWindow window) {
        
        this.window = window;
        initComponents();
        initVisualizer(); // non utilizzare nel costruttore (solo per test)
        
        audioTimer = new Timer();
        
        imagePanel.getVerticalScrollBar().setBackground(new Color(240, 241, 248));
        descPanel.getVerticalScrollBar().setBackground(new Color(240, 241, 248));
        locationPanel.getVerticalScrollBar().setBackground(new Color(240, 241, 248));
        
        descPanel.getVerticalScrollBar().setUnitIncrement(3);
        imagePanel.getVerticalScrollBar().setUnitIncrement(8);
        //setViewPanel("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "una data a caso", "Italia", "Europa", "/Katana.obj");
    }
    
    public SoundPlayer getPlayer(){
        return player;
    }
    
    private void initVisualizer(){
        GraphicsConfiguration config = SimpleUniverse
        .getPreferredConfiguration();
        
        viewWindow = new Canvas3D(config);
        
        int w = visualizerBox.getWidth();
        int h = visualizerBox.getHeight();
        
        visualizerBox.add(viewWindow);
        world = new ViewWorld(viewWindow);     
        
        visualizerBox.revalidate();
        visualizerBox.repaint();
    }
    
    public void setViewPanel(String nomeReperto, String desc, String date, String state, String continent, String[] category, String[] foto, String modelPath, String audioPath, String ricercatori){
        jSlider1.setValue(0);
        audioTimer = new Timer();
        jLabel1.setText(nomeReperto);
        time.setText("0:00/0:00");
        // file audio
        try{
            player = new SoundPlayer(audioPath);
        }catch(Throwable t){
            t.printStackTrace();
        }
        
        //String[] a = {"1", "2"}; // TEST
        updatePhotos(foto);
        
        world.stop();
        updateLocationPanel(date, state, continent, ricercatori);
        updateDescPanel(desc, category);
        world.changeNewGroup(modelPath);
        world.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel5 = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        HomeBtn = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        visualizerBox = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imagePanel = new javax.swing.JScrollPane();
        photoPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        playPause = new javax.swing.JToggleButton();
        jSlider1 = new javax.swing.JSlider();
        time = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        descPanel = new javax.swing.JScrollPane();
        descArea = new javax.swing.JTextArea();
        locationPanel = new javax.swing.JScrollPane();
        locationArea = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(231, 233, 242));

        menuBar.setBackground(new java.awt.Color(246, 248, 254));
        menuBar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(211, 215, 225)));

        HomeBtn.setBackground(new java.awt.Color(248, 250, 255));
        HomeBtn.setForeground(new java.awt.Color(112, 121, 138));
        HomeBtn.setText("Home");
        HomeBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(211, 215, 225)));
        HomeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HomeBtn.setFocusPainted(false);
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

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(HomeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addComponent(logOutButton))
        );

        visualizerBox.setBackground(new java.awt.Color(246, 248, 254));
        visualizerBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));
        visualizerBox.setToolTipText("");
        visualizerBox.setLayout(new javax.swing.BoxLayout(visualizerBox, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBackground(new java.awt.Color(246, 248, 254));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(69, 75, 93));
        jLabel1.setText("Nome Reperto");

        imagePanel.setBackground(new java.awt.Color(246, 248, 254));
        imagePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));
        imagePanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        photoPanel.setBackground(new java.awt.Color(246, 248, 254));
        photoPanel.setLayout(null);
        imagePanel.setViewportView(photoPanel);

        jPanel2.setBackground(new java.awt.Color(246, 248, 254));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));

        playPause.setBackground(new java.awt.Color(246, 248, 254));
        playPause.setForeground(new java.awt.Color(112, 121, 138));
        playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        playPause.setBorder(null);
        playPause.setContentAreaFilled(false);
        playPause.setFocusable(false);
        playPause.setMargin(new java.awt.Insets(10, 10, 10, 10));
        playPause.setMaximumSize(new java.awt.Dimension(100, 100));
        playPause.setMinimumSize(new java.awt.Dimension(100, 100));
        playPause.setPreferredSize(new java.awt.Dimension(100, 100));
        playPause.setRequestFocusEnabled(false);
        playPause.setRolloverEnabled(false);
        playPause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playPauseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playPauseMouseExited(evt);
            }
        });
        playPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseActionPerformed(evt);
            }
        });

        jSlider1.setBackground(new java.awt.Color(238, 240, 250));
        jSlider1.setForeground(new java.awt.Color(230, 190, 96));
        jSlider1.setMaximum(1000);
        jSlider1.setValue(0);
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSlider1MousePressed(evt);
            }
        });

        time.setForeground(new java.awt.Color(112, 121, 138));
        time.setText("0:00/0:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playPause, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(time)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(time))
                    .addComponent(playPause, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagePanel)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(246, 248, 254));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));

        jTabbedPane1.setBackground(new java.awt.Color(246, 248, 254));
        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(211, 215, 225), 1, true));
        jTabbedPane1.setForeground(new java.awt.Color(112, 121, 138));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setOpaque(true);

        descPanel.setBackground(new java.awt.Color(238, 240, 250));
        descPanel.setBorder(null);
        descPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descArea.setEditable(false);
        descArea.setBackground(new java.awt.Color(238, 240, 250));
        descArea.setColumns(20);
        descArea.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        descArea.setForeground(new java.awt.Color(112, 121, 138));
        descArea.setLineWrap(true);
        descArea.setRows(5);
        descArea.setMargin(new java.awt.Insets(6, 10, 6, 10));
        descArea.setRequestFocusEnabled(false);
        descPanel.setViewportView(descArea);

        jTabbedPane1.addTab("Descrizione", descPanel);

        locationPanel.setBackground(new java.awt.Color(238, 240, 250));
        locationPanel.setBorder(null);
        locationPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        locationArea.setEditable(false);
        locationArea.setBackground(new java.awt.Color(238, 240, 250));
        locationArea.setColumns(20);
        locationArea.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        locationArea.setForeground(new java.awt.Color(112, 121, 138));
        locationArea.setLineWrap(true);
        locationArea.setRows(5);
        locationArea.setMargin(new java.awt.Insets(6, 10, 6, 10));
        locationArea.setRequestFocusEnabled(false);
        locationPanel.setViewportView(locationArea);

        jTabbedPane1.addTab("Ritrovamento", locationPanel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jTabbedPane1)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visualizerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(visualizerBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        endVisualizer();
        window.showItemsPanel();
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

    private void playPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseActionPerformed
        if(!playPause.isSelected()){
            
            player.pause();
            playPause.setIcon(new ImageIcon(getClass().getResource("/play.png")));
        }else {
            if(!player.isStarted()){
                player.playMusic();
                startSliderUpdate();
            }else{
                player.resume();
            }
            playPause.setIcon(new ImageIcon(getClass().getResource("/pause.png")));
        }
    }//GEN-LAST:event_playPauseActionPerformed
    
    private void jSlider1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MousePressed
        boolean b = false;
        if(!player.isStarted()){
            player.playMusic();
            startSliderUpdate();
            b = true;
        }
            
        int v = jSlider1.getValue();
        long durata = player.getClip().getMicrosecondLength();
        int maxV = jSlider1.getMaximum();
        long r = (durata * v / maxV);
        player.setLastPos((int)r);
        
        if(playPause.isSelected() || b){
           player.pause();
           playPause.setSelected(false);
           playPause.setIcon(new ImageIcon(getClass().getResource("/play.png")));
        }
    }//GEN-LAST:event_jSlider1MousePressed

    private void playPauseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playPauseMouseEntered
        playPause.setBackground(ColorManager.getInstance().getColor("btnHover"));
    }//GEN-LAST:event_playPauseMouseEntered

    private void playPauseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playPauseMouseExited
        playPause.setBackground(ColorManager.getInstance().getColor("boxColor"));
    }//GEN-LAST:event_playPauseMouseExited

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        endVisualizer();
        window.getController().logout();
        window.showLoginPanel();
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        logOutButton.setForeground(ColorManager.getInstance().getColor("color2Strong"));
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        logOutButton.setForeground(ColorManager.getInstance().getColor("txtInactive"));
    }//GEN-LAST:event_logOutButtonMouseExited
 
    private void endVisualizer(){
        playPause.setSelected(false);
        playPause.setIcon(new ImageIcon(getClass().getResource("/play.png")));
        
        player.stop();
        world.stop();
        audioTimer.purge();
        audioTimer.cancel();
        audioTimer = null;
        player = null;
    }
    
    private BufferedImage resizeImg(BufferedImage img){
        float larghezza = img.getWidth(), altezza = img.getHeight();
        float proporzioni = larghezza/altezza;
        float passo = 10*proporzioni;
        while(larghezza > 300 || altezza > 300){
            larghezza -= passo*proporzioni;
            altezza -= passo;
        }
        
        BufferedImage resizedImage = new BufferedImage((int)larghezza, (int)altezza, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(img, 0, 0, (int)larghezza, (int)altezza, null);
        graphics2D.dispose();
        return resizedImage;
    }
    
    private void updatePhotos(String[] paths){
        photoPanel.removeAll();
        int w = photoPanel.getWidth();
        photoPanel.setPreferredSize(new Dimension(w, 0));
        photoPanel.setSize(new Dimension(w, 0));
        //dimensione jlabel: 300 con 5 di margine
        
        int size = paths.length;
        
        
        ImageIcon[] f = new ImageIcon[size];
        for(int i = 0; i < size; i++){
            //String filename = null;
            //BufferedImage bimg = ;
            //(new ImageIcon(paths[i]).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)
            JLabel label = new JLabel();
            f[i] = new ImageIcon();
            try {
                f[i] = new ImageIcon(resizeImg(ImageIO.read(new File(paths[i]))));
                label = new JLabel(f[i]);
            } catch (IOException ex) {
                photoPanel.removeAll();
                photoPanel.setSize(new Dimension(0, 0));
                photoPanel.setPreferredSize(new Dimension(0,0));
                photoPanel.revalidate();
                photoPanel.repaint();
                return;
                //Logger.getLogger(ViewPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            label.setHorizontalAlignment(JLabel.CENTER);
            if(i != 0){
                label.setLocation(23, i * (f[i-1].getIconHeight()+10) + 15);
                label.setPreferredSize(new Dimension(300, f[i].getIconHeight()));
                label.setSize(new Dimension(300, f[i].getIconHeight()));
            }else{
                label.setLocation(23, 15);
                label.setPreferredSize(new Dimension(300, f[i].getIconHeight()));
                label.setSize(new Dimension(f[i].getIconWidth(), f[i].getIconHeight()));
            }
            photoPanel.setPreferredSize(new Dimension(w, photoPanel.getHeight()+ f[i].getIconHeight() + 10));
            photoPanel.setSize(new Dimension(w, photoPanel.getHeight()+ f[i].getIconHeight() + 10));
            photoPanel.add(label);
        }
        photoPanel.revalidate();
        photoPanel.repaint();
    }
    
    private void startSliderUpdate(){
        long durata = player.getClip().getMicrosecondLength();
        int maxV = jSlider1.getMaximum();
                    
        audioTimer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                player.writeTime(time);//lo faccio qui cos?? aggiorna anche se non viene avviata la traccia
                if(player.isActive()){
                    long secondaggio = player.getClip().getMicrosecondPosition();

                    long r = secondaggio * maxV / durata;
                    jSlider1.setValue((int)r);
                }
            }
        }, 0, 500);
    }
    
    private void updateDescPanel(String text, String[] category){
        String classificazione = "";
        if(category != null)
            for(int i=0; i< category.length; i++)
                classificazione += category[i]+"\n";
        descArea.setText(classificazione+"\n"+text);
    }
    
    private void updateLocationPanel(String date, String state, String continent, String ricercatori){ //parametro: array di ricercatori
        String text = "Data ritrovamento: " + date + ";\n";
        if(state.equals("")) state = "sconosciuto";
        if(continent.equals("")) continent = "sconosciuto";
        text += "Luogo ritrovamento (stato, continente): " + state + ", " + continent + ";\n";
        text += "Ricercatori coinvolti : " + ricercatori +"\n";
        locationArea.setText(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeBtn;
    private javax.swing.JTextArea descArea;
    private javax.swing.JScrollPane descPanel;
    private javax.swing.JScrollPane imagePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea locationArea;
    private javax.swing.JScrollPane locationPanel;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel menuBar;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JToggleButton playPause;
    private javax.swing.JLabel time;
    private javax.swing.JPanel visualizerBox;
    // End of variables declaration//GEN-END:variables
}
