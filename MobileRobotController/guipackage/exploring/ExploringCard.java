/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage.exploring;

import java.awt.CardLayout;

import guipackage.component.Notification;
import mappackage.DynamicMap;
import mappackage.Map;
import mappackage.RealMap;
import repositorypackage.Repository;
import robotpackage.Robot;

/**
 *
 * @author Darae
 */
public class ExploringCard extends javax.swing.JPanel {
    CardLayout layout = new CardLayout();
    HideMap hidemapPanel;
    public ShowMap showmapPanel;
    
    public ExploringCard() {
        initComponents();
        showmapPanel = new ShowMap();
        hidemapPanel = new HideMap();
        createCard();
    }
    
    public void setNoti(String message) {
    	showmapPanel.setNoti(message);
    	hidemapPanel.setNoti(message);
    }
    
    private void createCard(){
        setLayout(layout);
        add(hidemapPanel,"hide");
        add(showmapPanel, "show");
        layout.show(this, "hide");
    }
    
    public void changeCard(String s){
        layout.show(this,s);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
