
package guipackage.settings;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import basic.Point;
import guipackage.component.MapBoard;
import mappackage.Map;
import spotpackage.Hazard;
import spotpackage.Predefined;
import spotpackage.Spot;

public class SetPos extends javax.swing.JPanel {
	
    Map m;
    public Point current;
    
    public SetPos(Map m) {
    	this.m = m;
        mapBoard1 = new MapBoardForSet(m.row,m.col);
        initComponents();
    }


    public void addPos(int realx, int realy) { 
    	int r = (int)(realy/mapBoard1.SIZE); 
		int c = (int)(realx/mapBoard1.SIZE);
		Point p = new Point(r,c);
		Spot obj = new Spot(p);
    	if(current==null || !current.equals(p)) {
    		if(!m.checkcontains(m.hlist, obj) 
    				&& !m.checkcontains(m.plist, obj)) {
        		current = p;
        		repaint();
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        sizePanel = new javax.swing.JPanel();
        infoLabel = new java.awt.Label();
        sizeLabel = new java.awt.Label();
        boardPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new java.awt.BorderLayout());

        infoLabel.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        infoLabel.setText("Set start position on map.");

        sizeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        sizeLabel.setText("Map Size: ");

        javax.swing.GroupLayout sizePanelLayout = new javax.swing.GroupLayout(sizePanel);
        sizePanel.setLayout(sizePanelLayout);
        sizePanelLayout.setHorizontalGroup(
            sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sizePanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(sizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(779, Short.MAX_VALUE))
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
            .addGap(0, 978, Short.MAX_VALUE)
        );
        mapBoard1Layout.setVerticalGroup(
            mapBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mapBoard1);

        boardPanel.add(jScrollPane1);

        add(boardPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private java.awt.Label infoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private guipackage.component.MapBoard mapBoard1;
    private java.awt.Label sizeLabel;
    private javax.swing.JPanel sizePanel;
    // End of variables declaration//GEN-END:variables
    
    
    
    
    
    
    
    
    //inner class
    class MapBoardForSet extends MapBoard {
    	
    	public MapBoardForSet(int row, int col) {
    		super(row,col);
    		addMouseListener(new MouseListener() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	    	
        	    }

    			@Override
    			public void mousePressed(MouseEvent e) {
    				// TODO Auto-generated method stub
    				int realx = e.getX();
        	    	int realy = e.getY();
        	    	if(0<realx && realx<SIZE*col && 0<realy && realy<SIZE*row) {
        	    		addPos(realx,realy);
        	    	}
    			}

    			@Override
    			public void mouseReleased(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}

    			@Override
    			public void mouseEntered(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}

    			@Override
    			public void mouseExited(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
        	});
    	}
    	
    	
    	public void paint(Graphics g) {
    		super.paint(g);
    		g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 

    		int centerr,centerc;
    		if(current != null) {
    			centerr = current.getx()*SIZE+ 10;
    			centerc = current.gety()*SIZE+ 20;
    			g.drawString("*", centerc, centerr);
    		}
    		for(Spot h: m.hlist) {
    			Point p = h.getPosition();
    			centerr = p.getx()*SIZE+ 10;
    			centerc = p.gety()*SIZE+ 20;
    			g.drawString("H", centerc, centerr);
    		}
    		g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
    		for(Spot pd: m.plist) {
    			Point p = pd.getPosition();
    			centerr = p.getx()*SIZE + 10;
    			centerc = p.gety()*SIZE +20;
    			g.drawString("P", centerc, centerr);
    		}
		
    	}

    }

    
    
}
