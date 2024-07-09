import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class FrontEnd implements ActionListener {

    JFrame frame = new JFrame(); // For the Frame
    JButton page = new JButton("ReadMe");
    JButton playButton = new JButton();
    ArrayList<String> list = new ArrayList<>();
  
    
    FrontEnd() {

        frame.setLayout(new BorderLayout());
        
        
        page.addActionListener(this);

        // Code for Java Title
        JLabel title = new JLabel("Java Music Player");
        title.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 40));
        title.setBorder(new CompoundBorder(
                new BevelBorder(BevelBorder.RAISED),
                new EmptyBorder(10, 10, 10, 10)
        ));

        page.setFont(new Font("Franklin Gothic Medium", Font.ITALIC, 20));
        page.setFocusable(false);

        JPanel panel = new JPanel();
        panel.add(title);
        panel.add(page);
        frame.add(panel, BorderLayout.PAGE_START);

        // Music List
        list.add("Harry-Belafonte-Jump-in-the-Line.wav");
        list.add("Pheelz_Buju_BNXN_-_Finesse.wav");
        list.add("Post-Malone-Swae-Lee-Sunflower-Instrumental-Prod.-By-Carter-Lang-Louis-Bell.wav");
        list.add("Redbone-Instrumental.wav");
        list.add("Kendrick-Lamar-how-much-a-dollar-cost-(HipHopKit.com).wav");
        list.add("JID-feat-Denzel-Curry-Bruuuh-Remix-(HipHopKit.com).wav");
        list.add("03DeadWrong.wav");
        list.add("21_Savage_-_a_lot_FlexyOkay.com.wav");
        list.add("Baby-Keem-16-(HipHopKit.com).wav");
        list.add("Baby-Keem-ORANGE-SODA-(HipHopKit.com).wav");


        JList<String> temp = new JList<>(list.toArray(new String[0]));
        JScrollPane pane = new JScrollPane(temp);
        JPanel scroll = new JPanel(new BorderLayout());
        scroll.add(pane, BorderLayout.CENTER);
        frame.add(scroll, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setPreferredSize(new Dimension(500, 50));

        playButton.setBounds(200, 0, 100, 50);
        

        ImageIcon image = new ImageIcon("images.png");
        Image img = image.getImage();
        Image imag = img.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        image = new ImageIcon(imag);
        playButton.setIcon(image);

        buttonPanel.add(playButton);

        playButton.addActionListener(this);
        

        frame.add(buttonPanel, BorderLayout.PAGE_END);

        
        
        
        
        
        
        
        frame.setTitle("Music-Player");
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });

        frame.setVisible(true);
    }
    
    
    
    

    private void exitApplication() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.dispose();
    }

    
    public Clip playMusic(String music) {
        try {
            File file = new File(music);
            if (file.exists()) {
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
                return clip;
            } else {
                System.out.println("Can't Find File");
            }
        } catch (Exception e) {
            System.out.println("Can't Play File: " + e.getMessage());
        }
        return null;
    }

    
    public void actionPerformed(ActionEvent e) {
    
    	if(e.getSource()==playButton) {
    		
    		try {
    			for(int i = 0; i < list.size(); i++) {
    				System.out.println("Playing "+ list.get(i));
    				 Clip currentClip = playMusic(list.get(i));
    				while(currentClip.getMicrosecondLength() != currentClip.getMicrosecondPosition()) {
    					
    				}
    			}
    		}
    		catch(Exception e1){
    			System.out.println("File Not Found "+e1.getMessage());
    		}
    	}
    
    	
    	
    	
    }
    
    
    
    
    
    
    
    
}
