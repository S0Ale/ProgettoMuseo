/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author user
 * Questa classe è una versione custom di un normale JButton per comporre la lista di reperti
 * se premuto, questo bottone deve portare alla visualizzazione del reperto.
 */
public class ViewButton extends JButton{
    
    public ViewButton(AppWindow window, int x, int y){
        init(window);
        setLocation(x, y);
    }
    
    private void init(AppWindow window){
        setPreferredSize(new Dimension(85, 22));
        setSize(new Dimension(85, 22));
        setText("View");
        setBackground(ColorManager.getInstance().getColor("boxColor"));
        setForeground(ColorManager.getInstance().getColor("txtInactive"));
        setBorder(new LineBorder(ColorManager.getInstance().getColor("border")));
        setActionCommand("viewItem");
        setRolloverEnabled(false);
        
        //azioni al click
        addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(e.getActionCommand().equals("viewItem")){
                    window.updateViewPanel("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "una data a caso", "Italia", "Europa", "/Katana.obj", "/raindance.wav");
                    window.showViewPanel();
                }
            }
        });
        
        //listener per gli effetti di hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                setBackground(ColorManager.getInstance().getColor("btnHover"));
                setForeground(ColorManager.getInstance().getColor("txt"));
                setBorder(new LineBorder(ColorManager.getInstance().getColor("color1")));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                setBackground(ColorManager.getInstance().getColor("boxColor"));
                setForeground(ColorManager.getInstance().getColor("txtInactive"));
                setBorder(new LineBorder(ColorManager.getInstance().getColor("border")));
            }
        });
    }
}
