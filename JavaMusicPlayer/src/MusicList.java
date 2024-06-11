import java.util.ArrayList;

import javax.swing.JButton;

public class MusicList {


	// Array To Hold Music.
 ArrayList<String> musicFolder = new ArrayList<>();

 // Button For User To Access Music
 JButton setMusic = new JButton();
 
	MusicList() {
		
		
	    
	    // For Adding Music
	    this.setmusicFolder(musicFolder);
	    
	    
	}
	
	public ArrayList<String> getmusicFolder() {
		return musicFolder;
		
	}
	public void setmusicFolder(ArrayList<String> musicFolder) {
		this.musicFolder=musicFolder;
		
	}
	
}
