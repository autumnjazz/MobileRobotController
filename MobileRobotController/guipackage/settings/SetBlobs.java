/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage.settings;
/**
 *
 * @author Darae
 */
public class SetBlobs extends javax.swing.JPanel {
	
    public SetBlobs(int r, int c) {
        mapBoard1 = new guipackage.component.MapBoard(r,c);
        initComponents();
        //group btns
        btnGroup.add(hazardBtn);
        btnGroup.add(predefinedBtn);
    }

    
    
    
    //gui
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        blobchkPanel = new javax.swing.JPanel();
        hazardBtn = new javax.swing.JRadioButton();
        predefinedBtn = new javax.swing.JRadioButton();
        sizePanel = new javax.swing.JPanel();
        sizeLabel = new java.awt.Label();
        infoLabel = new java.awt.Label();
        boardPanel = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.BorderLayout());

        blobchkPanel.setMinimumSize(new java.awt.Dimension(200, 100));

        hazardBtn.setText("Hazard Blob");

        predefinedBtn.setText("Predefined Blob");

        javax.swing.GroupLayout blobchkPanelLayout = new javax.swing.GroupLayout(blobchkPanel);
        blobchkPanel.setLayout(blobchkPanelLayout);
        blobchkPanelLayout.setHorizontalGroup(
            blobchkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blobchkPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(blobchkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(predefinedBtn)
                    .addComponent(hazardBtn))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        blobchkPanelLayout.setVerticalGroup(
            blobchkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, blobchkPanelLayout.createSequentialGroup()
                .addContainerGap(377, Short.MAX_VALUE)
                .addComponent(hazardBtn)
                .addGap(18, 18, 18)
                .addComponent(predefinedBtn)
                .addGap(31, 31, 31))
        );

        add(blobchkPanel, java.awt.BorderLayout.LINE_END);

        sizeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        sizeLabel.setText("Map Size: ");

        infoLabel.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        infoLabel.setText("Set known blobs on map.");

        javax.swing.GroupLayout sizePanelLayout = new javax.swing.GroupLayout(sizePanel);
        sizePanel.setLayout(sizePanelLayout);
        sizePanelLayout.setHorizontalGroup(
            sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizePanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(781, Short.MAX_VALUE))
        );
        sizePanelLayout.setVerticalGroup(
            sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizePanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(sizePanel, java.awt.BorderLayout.PAGE_START);

        boardPanel.setLayout(new javax.swing.OverlayLayout(boardPanel));

        javax.swing.GroupLayout mapBoard1Layout = new javax.swing.GroupLayout(mapBoard1);
        mapBoard1.setLayout(mapBoard1Layout);
        mapBoard1Layout.setHorizontalGroup(
            mapBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        mapBoard1Layout.setVerticalGroup(
            mapBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        scroll.setViewportView(mapBoard1);

        boardPanel.add(scroll);

        add(boardPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blobchkPanel;
    private javax.swing.JPanel boardPanel;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JRadioButton hazardBtn;
    private java.awt.Label infoLabel;
    private guipackage.component.MapBoard mapBoard1;
    private javax.swing.JRadioButton predefinedBtn;
    private javax.swing.JScrollPane scroll;
    private java.awt.Label sizeLabel;
    private javax.swing.JPanel sizePanel;
    // End of variables declaration//GEN-END:variables
}
