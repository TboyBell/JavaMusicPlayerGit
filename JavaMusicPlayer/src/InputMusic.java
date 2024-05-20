import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InputMusic implements ActionListener {

	
	JButton setmusic = new JButton();
	MusicList list = new MusicList();
	
	InputMusic() {
		setmusic.setText("Add+");
		setmusic.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==setmusic) {
			list.setmusicFolder(null);
		}
		
	}
}
