package guipackage;
import java.awt.*;
import javax.swing.*;
public class ViewPresentResult extends JPanel{
	private MapBoard mb;
	private Notification noti;
	public ViewPresentResult(MapBoard mb, Notification noti) { 
		this.mb = mb; this.noti = noti;
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		
		JLabel info1 = new JLabel("Robot moves to (next) from (now)"); //TODO
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(mb);
		
		left.setLayout(new GridLayout(2,1,0,0));
		left.add(info1); left.add(scroll); 
		left.setPreferredSize(new Dimension(200,300));
		
		JPanel p = new JPanel();
		p.add(left); p.add(noti);

		JCheckBox c = new JCheckBox("show map");
		add(p); add(c);
	}
}
