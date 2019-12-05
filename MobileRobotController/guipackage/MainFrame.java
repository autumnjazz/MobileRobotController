package guipackage;

import java.awt.CardLayout;
import java.awt.Graphics;

import basic.Point;
import guipackage.alert.*;
import guipackage.component.*;
import guipackage.exploring.*;
import guipackage.settings.*;
import mappackage.DynamicMap;
import mappackage.Map;
import mappackage.RealMap;
import repositorypackage.Repository;
import robotpackage.Robot;


public class MainFrame extends javax.swing.JFrame {
	// from outside
	public Repository repo = new Repository();
	RealMap rm;
	public Robot robot = new Robot(repo);
	
	public int col; public int row;
	
    FinAlert finalert;
    
    CardLayout layout = new CardLayout();
    ExploringCard exploringCard;
    public SettingsCard settingCard;
    FinResult result;
    
    CardLayout btnlayout = new CardLayout();
    BtnCard btncard = new BtnCard();
    
    public MainFrame() {
        initComponents();
        showFrame();
    }
    
    void sizeInput(){
    	SetMapSize sizeinput = new SetMapSize(new javax.swing.JFrame(), true);
        sizeinput.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        sizeinput.setLocationRelativeTo(null);  
        sizeinput.setVisible(true);
        while(!sizeinput.isPerformed);
    	row = sizeinput.row;
    	col = sizeinput.col;
    }
    
    public void createBtn(){
        btnPanel.setLayout(layout);
        btnPanel.add(btncard,"btn");
        layout.show(btnPanel,"btn");
    }

    public void createCard(Map m){
        settingCard = new SettingsCard(m);
        exploringCard = new ExploringCard();
        result = new FinResult(m);
        contentPanel.setLayout(layout);
        contentPanel.add(settingCard,"set");
        contentPanel.add(exploringCard,"exp");
        contentPanel.add(result,"result");
        layout.show(contentPanel,"set");
    }
    
    public synchronized void setexplore(Point p) {
        robot.setCurrent(p);
        repo.setDM(p);
        repo.p.calculatePath(repo.m, robot.getCurrent());

        rm = new RealMap(repo.m);
        robot.hs.setRM(rm); 
        robot.cs.setRM(rm);
        
        notify();
    }

    public synchronized void startexplore() {
    	try {
    		wait();
    	} catch (Exception e) {	
    	}
		do {
	    	exploringCard.showmapPanel.setDM(repo.dm);
	    	try {
				Thread.sleep(1000);
	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(robot.readpath() == null) {
				break;
			}
			robot.detectSpot();
			repo.p.calculatePath(repo.m, robot.getCurrent());
			robot.move();
			repo.p.checkmotion();
		}while(true);
		System.out.println("finished while");
		finishalert();
    }
    
    public synchronized void finishalert() {
    	System.out.println("started alert()");
		finalert= new FinAlert(new javax.swing.JFrame(), true);
		finalert.setLocationRelativeTo(null);  
		finalert.setVisible(true);
		while(!finalert.isPerformed);
        layout.show(contentPanel,"result");
        btncard.changeCard("btn2");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPanel = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mobiel Robot Monitor");
        setLocation(300,100);  

        btnPanel.setPreferredSize(new java.awt.Dimension(1000, 100));

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(btnPanel, java.awt.BorderLayout.PAGE_END);

        contentPanel.setPreferredSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public void showFrame() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sizeInput();
                repo.m.initBoard(row, col);
                createCard(repo.m);
                createBtn();
                setVisible(true);
            }
        });
    }

    private javax.swing.JPanel btnPanel;
    private javax.swing.JPanel contentPanel;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //inner  class
    class ExpBtn extends javax.swing.JPanel {
        
    public ExpBtn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        showBtn = new javax.swing.JToggleButton();

        showBtn.setText("Show Map");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        testBtn = new javax.swing.JButton();

        testBtn.setText("testBtn");
        testBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testBtnActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(470, Short.MAX_VALUE)
                .addComponent(showBtn)
//                .addGap(427, 427, 427))
                .addGap(326, 326, 326)
                .addComponent(testBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showBtn)
                    .addComponent(testBtn))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(showBtn.isSelected()){
            showBtn.setText("Hide Map");
            exploringCard.changeCard("show");
        }else{
            showBtn.setText("Show Map");
            exploringCard.changeCard("hide");
        }
    }                                       
    
    private void testBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
                layout.show(contentPanel,"result");
                btncard.changeCard("btn2");

    }                                       
          

    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton showBtn;
    
    private javax.swing.JButton testBtn;
    // End of variables declaration                   
}
    class TwoBtn extends javax.swing.JPanel {

        /**
         * Creates new form TwoBtn
         */
        public TwoBtn() {
            initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            againBtn = new javax.swing.JButton();
            exitBtn = new javax.swing.JButton();

            againBtn.setText("Do again");
            againBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    againBtnActionPerformed(evt);
                }
            });

            exitBtn.setText("Exit");
            exitBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    exitBtnActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(377, 377, 377)
                    .addComponent(againBtn)
                    .addGap(93, 93, 93)
                    .addComponent(exitBtn)
                    .addContainerGap(382, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(againBtn)
                        .addComponent(exitBtn))
                    .addContainerGap(38, Short.MAX_VALUE))
            );
        }// </editor-fold>                        

        private void againBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        }                                        

        private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
            // TODO add your handling code here:
            System.exit(0);
        }                                       


        // Variables declaration - do not modify                     
        private javax.swing.JButton againBtn;
        private javax.swing.JButton exitBtn;
        // End of variables declaration                   
    }
    class OneBtn extends javax.swing.JPanel{
    	
        public OneBtn() {
            initComponents();
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            enterBtn = new javax.swing.JButton();

            enterBtn.setText("Enter");
            enterBtn.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    enterBtnActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(480, Short.MAX_VALUE)
                    .addComponent(enterBtn)
                    .addGap(455, 455, 455))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(enterBtn)
                    .addContainerGap(38, Short.MAX_VALUE))
            );
        }// </editor-fold>                        

        private void enterBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
            if(enterBtn.getText().equals("Enter")){
                enterBtn.setText("Start");
                settingCard.changeCard("pos");
            }
            else if(enterBtn.getText().equals("Start")){
                layout.show(contentPanel,"exp");
                btncard.changeCard("chk");
                Point p = settingCard.posPanel.current;
                setexplore(p);
            }
        }                                        

    	
        private javax.swing.JButton enterBtn;

    }
    class BtnCard extends javax.swing.JPanel {
        CardLayout blayout = new CardLayout();
        public ExpBtn chk = new ExpBtn();
        public OneBtn btn1 = new OneBtn();
        public TwoBtn btn2 = new TwoBtn();
        
        public BtnCard() {
            initComponents();
            createCard();
        }

        private void createCard(){
            setLayout(blayout);
            add(btn1, "btn1");
            add(chk,"chk");
            add(btn2, "btn2");
            blayout.show(this, "btn1");
        }
        public void changeCard(String s){
            blayout.show(this,s);
        }
        
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
            );
        }// </editor-fold>                        

               
    }

}
