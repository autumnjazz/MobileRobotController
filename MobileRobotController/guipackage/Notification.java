package guipackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Notification extends JPanel{
	private MapBoard mb;
	public Notification(MapBoard mb) { 
		this.mb = mb;
		JLabel info = new JLabel("Notifications");
		JTextArea noti = new JTextArea(15,10);
		JScrollPane scroll = new JScrollPane(noti);
		noti.setEditable(false);
		add(info); add(scroll);
		setLayout(new GridLayout(2,1));
		setPreferredSize(new Dimension(200,300));
		setBackground(Color.pink);
		
	}
}
