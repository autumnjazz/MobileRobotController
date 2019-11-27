package guipackage;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame{
	private CardLayout cards = new CardLayout();
	
	public MainFrame() {
		setSize(600,400);
		setTitle("Mobile Robot Controll Moniter");
		setResizable(false);
		setLayout(cards);
		
		MapBoard mb = new MapBoard(10, 10);
		Notification nf = new Notification(mb);
		add(new ViewPresentResult(mb,nf));
		add(nf);
		setVisible(true);
		
	}
	
	public void changePanel() {
		cards.next(this.getContentPane());
	}
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}
