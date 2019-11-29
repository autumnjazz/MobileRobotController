/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipackage.component;

import java.awt.Graphics;

/**
 *
 * @author Darae
 */
public class MapBoard extends javax.swing.JPanel {
	int row; int col;
	int SIZE = 30;
	//TODO: add spot list
	
	public MapBoard(int row, int col) {
		this.row = row; this.col = col;
        initComponents();
//		setPreferredSize(new Dimension(row*30,col*30));
	}
	
    @Override
	public void paint(Graphics g) {
		super.paint(g);
		drawMap(g);
	}
	
	public void drawMap(Graphics g) {
		int xpos, ypos;
		for(int y = 0; y < row; y++) {
			for(int x = 0; x < col; x++) {
				xpos = x*SIZE; ypos = y*SIZE;
				g.drawRect(xpos, ypos, SIZE, SIZE);
			}
		}
	}
	
	

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(700, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
