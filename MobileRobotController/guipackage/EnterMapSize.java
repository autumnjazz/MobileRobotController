package guipackage;

import java.awt.*;
import javax.swing.*;

public class EnterMapSize extends JPanel{
    private MainFrame mf;
	public EnterMapSize(MainFrame mf) {
		this.mf = mf;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JLabel info1 = new JLabel("Enter map size");
		p1.add(info1);
		
		JLabel row = new JLabel("row: ");
		JTextField rowtxt = new JTextField(3);
		p2.add(row); p2.add(rowtxt);
		JLabel col = new JLabel("col: ");
		JTextField coltxt = new JTextField(3);
		p2.add(col); p2.add(coltxt);
		
		
		JButton button = new JButton("Enter");
		p3.add(button);
		
		setLayout(new GridLayout(3,1));
		add(p1); add(p2); add(p3);
		
		
	}
    
}