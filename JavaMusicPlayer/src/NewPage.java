import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	// Frame, Panel, Label, Button.

	JFrame frame = new JFrame();
	JButton Back = new JButton("Back");
	JLabel title = new JLabel("PlayList Java");
	JPanel list = new JPanel();
	JButton refresh = new JButton();
	
	NewPage() {
		
		// Code For Back Button.
		Back.setBounds(0, 0, 75, 75);
		Back.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		Back.setBorder(BorderFactory.createBevelBorder(0));
		Back.addActionListener(this);
		frame.add(Back);
		//---------------------------------------------------------------
		
		
		// Code For Title Display.
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
		
		//-----------------------------------------------------------------------------------
		
	
	
		// Refresh Button.
		refresh.setBounds(350, 200, 85, 75);
		refresh.setBorder(BorderFactory.createBevelBorder(0));
		refresh.setFocusable(false);
		ImageIcon icon2 = new ImageIcon("img.png");
		Image image1 = icon2.getImage();
		Image newimg1 = image1.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(newimg1);
				
		refresh.setIcon(icon2);
		refresh.addActionListener(this);
		frame.add(refresh);
		
		//--------------------------------------------------------------------------------------
		
		
		
		//list is a JPanel.
		// Block of Code For List.
		list.setBounds(0, 100, 250, 250);
		list.setLayout(new BorderLayout());
		list.setBorder(BorderFactory.createSoftBevelBorder(0));
		

		// Array that holds the music path,
		// To put in JList.
		ArrayList<String> item = new ArrayList<>();
		item.add("Harry-Belafonte-Jump-in-the-Line.wav");
		item.add("Pheelz_Buju_BNXN_-_Finesse.wav");
		item.add("Post-Malone-Swae-Lee-Sunflower-Instrumental-Prod.-By-Carter-Lang-Louis-Bell.wav");
		item.add("Redbone-Instrumental.wav");
		item.add("Kendrick-Lamar-how-much-a-dollar-cost-(HipHopKit.com).wav");
		item.add("JID-feat-Denzel-Curry-Bruuuh-Remix-(HipHopKit.com).wav");
		item.add("03DeadWrong.wav");
	    item.add("21_Savage_-_a_lot_FlexyOkay.com.wav");
	    item.add("Baby-Keem-16-(HipHopKit.com).wav");
	    item.add("Baby-Keem-ORANGE-SODA-(HipHopKit.com).wav");
	    
		
		JList <String> itemList = new JList<String>(item.toArray(new String[0]));		
		
	    JScrollPane pane = new JScrollPane(itemList);
		list.add(pane); // Should Use (BorderLayout.(North, South, West, East));
		
		
		
		/* Here are some other examples of components that can be placed inside a JScrollPane:
		 * JTable: A component used to display data in a tabular format.
		 * JTextArea: A multi-line area for displaying plain text.
		 * JTree: A component that displays a tree structure.
		 * JPanel: A generic container for other components.
		 * JScrollPane: You can even nest scroll panes inside each other,
		 *  to create more complex scrollable layouts.*/
		
		
		//--------------------------------------------------------------------------------------------

		
		
		
		
		
		
		// Frame Functions.
		
		frame.add(list);
		
		frame.setSize(500, 500);
		frame.setTitle("Playlist");
		frame.setLayout(null);
	
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent WindowEvent) {
				exitApplication();
			}

			
			
		} );
		
		frame.setVisible(true);
		
		//-------------------------------------------------------------------------------------
		
	}
		
	
	
		
	// METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS	
	
	
	// Extension Of Closing Functions.
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
		else if(e.getSource()==refresh) {
			frame.dispose();
			NewPage np = new NewPage();
		}
	}
}
