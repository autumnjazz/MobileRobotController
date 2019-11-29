package guipackage;

import java.awt.CardLayout;
import guipackage.alert.*;
import guipackage.component.*;
import guipackage.exploring.*;
import guipackage.settings.*;


public class MainFrame extends javax.swing.JFrame {
    
	public int col; public int row;
	
    FinAlert finalert;
    
    CardLayout layout = new CardLayout();
    ExploringCard exploringCard;
    SettingsCard settingCard;
    FinResult result;
    
    CardLayout btnlayout = new CardLayout();
    BtnCard btncard = new BtnCard();
    
    public MainFrame() {
        sizeInput();
        initComponents();
        createCard(row,col);
        createBtn();
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

    public void createCard(int r, int c){
        settingCard = new SettingsCard(r, c);
        exploringCard = new ExploringCard(r, c);
        result = new FinResult(r, c);
        contentPanel.setLayout(layout);
        contentPanel.add(settingCard,"set");
        contentPanel.add(exploringCard,"exp");
        contentPanel.add(result,"result");
        layout.show(contentPanel,"set");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPanel = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mobiel Robot Monitor");
        setLocationRelativeTo(null);  

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
                new MainFrame().setVisible(true);
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

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
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
    class OneBtn extends javax.swing.JPanel {

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
