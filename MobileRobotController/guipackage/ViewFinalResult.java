package guipackage;
import java.awt.*;
import javax.swing.*;
public class ViewFinalResult extends JPanel{
	private MainFrame mf;
	private MapBoard mb;
	public ViewFinalResult(MainFrame mf, MapBoard mb) { //state can be "blob" "pos" "fin"
		this.mf = mf; this.mb = mb;
		JPanel p1 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		JLabel info = new JLabel("Finished Exploration."); //TODO
		p1.add(info);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(mb);
		
		p3.setLayout(new BorderLayout());
		p3.add(scroll, BorderLayout.CENTER);
		
		JButton b1 = new JButton("do again");
		JButton b2 = new JButton("exit");
		p4.add(b1); p4.add(b2);
		
		setLayout(new GridLayout(3,1));
		add(p1); add(p3); add(p4);
	}
}
