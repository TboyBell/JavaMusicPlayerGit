import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class NewPage implements ActionListener {

	JFrame frame = new JFrame();
	JButton Back = new JButton("Back");
	JLabel title = new JLabel("PlayList Java");
	JPanel list = new JPanel();
	JButton ref = new JButton();
	
	NewPage() {
		
		Back.setBounds(0, 0, 75, 75);
		Back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Back.setBorder(BorderFactory.createBevelBorder(0));
		Back.addActionListener(this);
		frame.add(Back);
		
		
		
		
		
		
		title.setBounds(75, 0, 450, 50);
		title.setFont(new Font("Arial Black",Font.ITALIC,45));
		
		ImageIcon icon = new ImageIcon("image.png");
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_AREA_AVERAGING);
		icon = new ImageIcon(newimg);
		title.setIcon(icon);
		title.setIconTextGap(10);
		title.setHorizontalTextPosition(JLabel.LEFT);
		
		title.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frame.add(title);
		
		
		
		
		
		
		
		
		list.setLayout(new BorderLayout());
		list.setBounds(0, 100, 250, 250);
		list.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		

		MusicList List = new MusicList();
		JList <String> itemList = new JList<String>(List.musicFolder.toArray(new String[0]));
		JScrollPane pane = new JScrollPane(itemList);
		list.add(pane); // Should Use (BorderLayout.(North, South, West, East));
		
		frame.add(list);
		
		/* Here are some other examples of components that can be placed inside a JScrollPane:
		 * JTable: A component used to display data in a tabular format.
		 * JTextArea: A multi-line area for displaying plain text.
		 * JTree: A component that displays a tree structure.
		 * JPanel: A generic container for other components.
		 * JScrollPane: You can even nest scroll panes inside each other,
		 *  to create more complex scrollable layouts.*/
		
		
		
		
		InputMusic add = new InputMusic();
		add.setmusic.setBounds(350, 100, 100, 50);
		frame.add(add.setmusic);
		
		
		ref.setBounds(350, 200, 85, 75);
		ref.setBorder(BorderFactory.createBevelBorder(0));
		ref.setFocusable(false);
		ImageIcon icon2 = new ImageIcon("img.png");
		Image image1 = icon2.getImage();
		Image newimg1 = image1.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg1);
				
		ref.setIcon(icon2);
		ref.addActionListener(this);
		frame.add(ref);
		
		
		
		
		frame.setSize(500, 500);
		frame.setTitle("Playlist");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent WindowEvent) {
				exitApplication();
				
			}

			
		});
	}
	
	public void exitApplication() {
		frame.dispose();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Back) {
			frame.dispose();
			FrontEnd main = new FrontEnd();
		}
		else if(e.getSource()==ref) {
			frame.dispose();
			NewPage np = new NewPage();
		}
	}
}
