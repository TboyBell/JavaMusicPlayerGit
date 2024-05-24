import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class FrontEnd implements ActionListener{

	JFrame frame = new JFrame(); // For the Frame
	JPanel ppic = new JPanel();  // For the panel that holds the picture.
	JPanel pplay = new JPanel(); // For the panel that holds the play button. 
	
	// Play buttons.
	JButton button = new JButton(); 
	JButton newPage = new JButton("Playlist");
	JButton reload = new JButton();
	
	
	
	// Class that Holds Music Files. See MusicList.Java
	MusicList musiclist = new MusicList();
	
	
	
	// Play Music Code 1.
	public Clip playMusic(String music) {
        File file = new File(music);
        if (!file.exists()) {
            System.err.println("File not found: " + music);
            return null;
        }

        try (AudioInputStream audio = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
           // clip.loop(Clip.LOOP_CONTINUOUSLY);;
            /*clip.addLineListener(event -> {
                if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP)
                    clip.close(); // Close the clip when it stops playing
            });*/
            return clip;
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.err.println("Error playing " + music + ": " + e.getMessage());
        }
		return null;
    }
	
	
	
	
	
	
	
	FrontEnd() {
		
	    
		// This Body Of Code Contains Functions For The Music Picture/Name.
		
		ppic.setBounds(350, 0, 250, 250);
		JLabel label1 = new JLabel();
		label1.setText("Feelz GOOD");
		label1.setVerticalTextPosition(JLabel.BOTTOM);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setFont(new Font("Arial Black",Font.ITALIC,20));
		label1.setForeground(Color.RED);
		
		// This Block Of Code Scales the Picture To Perfect Height.
		ImageIcon icon = new ImageIcon("guitar.png");
		Image img = icon.getImage();
		Image newi = img.getScaledInstance(250, 200,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newi);
		label1.setIcon(icon);
		label1.setIconTextGap(-35);
		ppic.add(label1);
		//-----------------------------------------------------------
		
			
		
		
		
		
		// This Body Of Code Contains Functions For The Play Buttons.
		
		pplay.setLayout(null); // Set layout to null to use absolute positioning
		pplay.setBounds(200, 270, 550, 150);
		pplay.setBackground(Color.PINK);  
		pplay.setBorder(BorderFactory.createRaisedBevelBorder());;

		
		ImageIcon icon1 = new ImageIcon("images.png");
		Image image = icon1.getImage(); // transform it 
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		icon1 = new ImageIcon(newimg);  // transform it back
		
		button.setIcon(icon1);
		button.addActionListener(this);
		button.setBounds(200, 30, 150, 75); 
		pplay.add(button);
		
		//----------------------------------------------------------------------------------------
		
		
		
		
		
		
		// This Is The Button For A New Page
		newPage.setBounds(150, 150, 100, 75);
		newPage.setBorder(BorderFactory.createBevelBorder(0));
		newPage.addActionListener(this);
		frame.add(newPage);
		//-----------------------------------------------------
		
		
		
		
		
		// This Body Of Code Contains Functions For The Reload Picture.
		
		reload.setBounds(750, 150, 85, 75);
		reload.setBorder(BorderFactory.createBevelBorder(0));
		ImageIcon icon2 = new ImageIcon("img.png");
		Image image1 = icon2.getImage();
		Image newimg1 = image1.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		
		icon2 = new ImageIcon(newimg1);		
		reload.setIcon(icon2);
		reload.addActionListener(this);
		//-----------------------------------------------------------------------------------
		
		
		
		// This Body Of Code Contains Functions For The Frame It Self.
		frame.add(reload);	
		frame.add(ppic);
		frame.add(pplay);
		
		// Preferences
		
		frame.setLayout(null);
		frame.setTitle("MusicPlayer");
		frame.setSize(1000,500);
		frame.setResizable(false);
		
		
		
		
		
		// Closing Function
		

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent WindowEvent) {
				exitApplication();
			}
		
		}
		
				);
		
		
	
	
		frame.setVisible(true);
	
	//----------------------------------------------------------------------------------------------
		
	}
	
	
	
	
	
	// METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS METHODS
	
	
	
	// Continuation Of Closing Functions.
	public void exitApplication() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
	}
	
	
	
	// Actions/ Tasks Code.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==button) {

			// Action For Play Music.
	        for(int i = 0; i < musiclist.musicFolder.size(); i++) {
	        	System.out.println("Playing" + musiclist.musicFolder.get(i));
	        	Clip currentClip = playMusic(musiclist.musicFolder.get(i));
	        	while(currentClip.getMicrosecondLength() != currentClip.getMicrosecondPosition()) {
	        		
	        	}
	        	
	        }
	        
		}
		
		// Action For New Page.
		else if(e.getSource()==newPage) {
			frame.dispose();
    		NewPage page = new NewPage();
    		
    	}
		
		// Action For Reload Page.
		else if(e.getSource()==reload) {
			frame.dispose();
			FrontEnd fe = new FrontEnd();
		}
	}
	
	
	
	
	
	
	
	
	
	
	}

	
