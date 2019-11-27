package guipackage;
import java.awt.*;
import javax.swing.*;
public class EnterPos extends JPanel{
	private MainFrame mf;
	private MapBoard mb;
	public EnterPos(MainFrame mf, MapBoard mb) { //state can be "blob" "pos" "fin"
		this.mf = mf; this.mb = mb;
		JPanel p1 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel info1 = new JLabel("Map size: 5 x 5"); //TODO
		JLabel info2 = new JLabel("Choose start position."); //TODO
		p1.setLayout(new GridLayout(0,1));
		p1.add(info1); p1.add(info2);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(mb);
		
		p3.setLayout(new BorderLayout());
		p3.add(scroll, BorderLayout.CENTER);
		
		JButton b = new JButton("Start");
		p4.add(b);
		
		setLayout(new GridLayout(3,1));
		add(p1); add(p3); add(p4);
	}
}
