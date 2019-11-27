package guipackage;
import java.awt.*;
import javax.swing.*;
public class EnterBlobs extends JPanel{
	private MainFrame mf;
	private MapBoard mb;
	public EnterBlobs(MainFrame mf, MapBoard mb) { //state can be "blob" "pos" "fin"
		this.mf = mf; this.mb = mb;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel info = new JLabel("Map size: 5 x 5"); //TODO
		p1.add(info);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton hb = new JRadioButton("Hazard Blob");
		JRadioButton pb = new JRadioButton("Predefined Blob");
		group.add(hb); group.add(pb);
		p2.setLayout(new GridLayout(0,1)); p2.add(hb); p2.add(pb);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(mb);
		
		p3.setLayout(new BorderLayout());
		p3.add(scroll, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.EAST);
		
		JButton b = new JButton("Enter");
		p4.add(b);
		
		setLayout(new GridLayout(3,1));
		add(p1); add(p3); add(p4);
		
	}
}
