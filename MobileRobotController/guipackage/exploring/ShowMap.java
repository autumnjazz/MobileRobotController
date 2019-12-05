/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage.exploring;

import mappackage.Map;

/**
 *
 * @author Darae
 */
public class ShowMap extends javax.swing.JPanel {

    /**
     * Creates new form ShowMap
     */
    public ShowMap(Map m) {
        mapBoard1 = new guipackage.component.MapBoard(m.row,m.col);
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

        jDialog1 = new javax.swing.JDialog();
        notiPanel = new javax.swing.JPanel();
        notification2 = new guipackage.component.Notification();
        boardPanel = new javax.swing.JPanel();
        pathPanel = new javax.swing.JPanel();
        nowPos = new javax.swing.JLabel();
        nextPos = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.BorderLayout());

        notiPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        notiPanel.setLayout(new java.awt.BorderLayout());
        notiPanel.add(notification2, java.awt.BorderLayout.CENTER);

        add(notiPanel, java.awt.BorderLayout.LINE_END);

        boardPanel.setLayout(new java.awt.BorderLayout());

        nowPos.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        nowPos.setText("from ");

        nextPos.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        nextPos.setText("to ");

        javax.swing.GroupLayout pathPanelLayout = new javax.swing.GroupLayout(pathPanel);
        pathPanel.setLayout(pathPanelLayout);
        pathPanelLayout.setHorizontalGroup(
            pathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pathPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nowPos)
                    .addComponent(nextPos))
                .addContainerGap(619, Short.MAX_VALUE))
        );
        pathPanelLayout.setVerticalGroup(
            pathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pathPanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(nowPos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nextPos)
                .addGap(18, 18, 18))
        );

        boardPanel.add(pathPanel, java.awt.BorderLayout.PAGE_START);

        scroll.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mapBoard1Layout = new javax.swing.GroupLayout(mapBoard1);
        mapBoard1.setLayout(mapBoard1Layout);
        mapBoard1Layout.setHorizontalGroup(
            mapBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        mapBoard1Layout.setVerticalGroup(
            mapBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        scroll.setViewportView(mapBoard1);

        boardPanel.add(scroll, java.awt.BorderLayout.CENTER);

        add(boardPanel, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.JDialog jDialog1;
    private guipackage.component.MapBoard mapBoard1;
    private javax.swing.JLabel nextPos;
    private javax.swing.JPanel notiPanel;
    private guipackage.component.Notification notification2;
    private javax.swing.JLabel nowPos;
    private javax.swing.JPanel pathPanel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
