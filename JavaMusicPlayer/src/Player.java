import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Player {
	
	static JFrame frame;
	private static Clip clip;
	private static boolean isPaused;
	private static boolean isLooping;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		frame = new JFrame("Music-Player");
		frame.setSize(600,150);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitApp();
			}
		});
		
		Font font = new Font("Franklin Gothic Medium",Font.ITALIC,15);
		
		JTextField display = new JTextField();
		display.setEditable(false);
		display.setFont(font);
		display.setBackground(Color.WHITE);
		display.setBounds(15, 25, 300, 25);
		frame.add(display);
		
		
		JButton chooseFile = new JButton("Choose");
		chooseFile.setFocusable(false);
		chooseFile.setFont(font);
		chooseFile.setBounds(320, 25, 100, 30);
		chooseFile.addActionListener(new ActionListener() {

			  public void actionPerformed(ActionEvent e) {
	                JFileChooser fileChooser = new JFileChooser();
	                FileNameExtensionFilter filter = new FileNameExtensionFilter("Wav Files", "wav");
	                fileChooser.setFileFilter(filter);
	                int userAction = fileChooser.showOpenDialog(null);
	                File selectedFile = fileChooser.getSelectedFile();

	                if (userAction == JFileChooser.APPROVE_OPTION && selectedFile != null) {
	                    display.setText(selectedFile.getAbsolutePath());
	                }
	                else {
	                	JOptionPane.showMessageDialog(null, "No File Selected");
						display.setText("No File Selected");
	                }
	            }
	        });
	        frame.add(chooseFile);
	        
		
		JButton play = new JButton("Play");	
		play.setFocusable(false);
		play.setBounds(430, 25, 100, 30);
	
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playMusic();
			}

			
			private void playMusic() {
				// TODO Auto-generated method stub
				
				if(clip != null && clip.isRunning()) {
					clip.stop();
				}
				
				try
				{
					File file = new File(display.getText());
					AudioInputStream audio = AudioSystem.getAudioInputStream(file);
					
					clip = AudioSystem.getClip();
					clip.open(audio);
					
					if(isLooping) {
						clip.loop(Clip.LOOP_CONTINUOUSLY);					
						}
					
					clip.start();
				}
				catch (FileNotFoundException e) {
				    JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage() + ". Please use the Choose button to select a file.");
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
			}
			
		});
		frame.add(play);
		
		
		
		JButton pause = new JButton("Pause");
		pause.setFocusable(false);
		pause.setBounds(320, 70, 100, 30);
		pause.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pauseMusic();
			}

			private void pauseMusic() {
				// TODO Auto-generated method stub
				
					if(clip != null && clip.isRunning()) {
						clip.stop();
						isPaused = true;
						pause.setText("Resume");
					}
					else if(clip != null && isPaused) {
					
						clip.start();
						
						if(isLooping) {
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
					
					isPaused = false;
					pause.setText("Pause");
				}			
		});
		frame.add(pause);
		
		
		JButton loop = new JButton("Loop");
		loop.setFocusable(false);
		loop.setBounds(430, 70, 100, 30);
		loop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loopMusic();
			}

			private void loopMusic() {
				// TODO Auto-generated method stub
				
				try {
				isLooping =  !isLooping;
				if(isLooping) {
					loop.setText("UnLoop");
					
					if(clip.isRunning()) {
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
					
				}
				else {
					loop.setText("Loop");
					if(clip.isRunning()) {
						clip.loop(0);
					}
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage() + ". Please use the Choose button to select a file.");
			}
			}
			
			
		});
		frame.add(loop);
		
		
		
		frame.setVisible(true);
	}
	

	public static void exitApp() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		
	}




	
	
	
}
