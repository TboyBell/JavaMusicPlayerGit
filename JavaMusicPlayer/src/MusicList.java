import java.util.ArrayList;

import javax.swing.JButton;

public class MusicList {


	// Array To Hold Music.
 ArrayList<String> musicFolder = new ArrayList<>();

 // Button For User To Access Music
 JButton setMusic = new JButton();
 
	MusicList() {
		
		musicFolder.add("Harry-Belafonte-Jump-in-the-Line.wav");
		musicFolder.add("Pheelz_Buju_BNXN_-_Finesse.wav");
		musicFolder.add("Post-Malone-Swae-Lee-Sunflower-Instrumental-Prod.-By-Carter-Lang-Louis-Bell.wav");
		musicFolder.add("Redbone-Instrumental.wav");
		musicFolder.add("Kendrick-Lamar-how-much-a-dollar-cost-(HipHopKit.com).wav");
		musicFolder.add("JID-feat-Denzel-Curry-Bruuuh-Remix-(HipHopKit.com).wav");
		musicFolder.add("03DeadWrong.wav");
	    musicFolder.add("21_Savage_-_a_lot_FlexyOkay.com.wav");
	    musicFolder.add("Baby-Keem-16-(HipHopKit.com).wav");
	    musicFolder.add("Baby-Keem-ORANGE-SODA-(HipHopKit.com).wav");
	    
	    
	    this.setmusicFolder(musicFolder);
	    
	    
	}
	
	public ArrayList<String> getmusicFolder() {
		return musicFolder;
		
	}
	public void setmusicFolder(ArrayList<String> musicFolder) {
		this.musicFolder=musicFolder;
		
	}
	
}
