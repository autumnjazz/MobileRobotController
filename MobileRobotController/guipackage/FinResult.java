package guipackage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mappackage.Map;

/**
 *
 * @author Darae
 */
public class FinResult extends javax.swing.JPanel {

    /**
     * Creates new form FinResult
     */
    public FinResult(Map m) {
        mapBoard2 = new guipackage.component.MapBoard(m.row,m.col);
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

        infoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        boardPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        jLabel1.setText("Final Result");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(449, 449, 449)
                .addComponent(jLabel1)
                .addContainerGap(462, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(infoPanel, java.awt.BorderLayout.PAGE_START);

        boardPanel.setBackground(new java.awt.Color(255, 204, 204));
        boardPanel.setLayout(new javax.swing.OverlayLayout(boardPanel));

        javax.swing.GroupLayout mapBoard2Layout = new javax.swing.GroupLayout(mapBoard2);
        mapBoard2.setLayout(mapBoard2Layout);
        mapBoard2Layout.setHorizontalGroup(
            mapBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 978, Short.MAX_VALUE)
        );
        mapBoard2Layout.setVerticalGroup(
            mapBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mapBoard2);

        boardPanel.add(jScrollPane1);

        add(boardPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private guipackage.component.MapBoard mapBoard2;
    // End of variables declaration//GEN-END:variables
}