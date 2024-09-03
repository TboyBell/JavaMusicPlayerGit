Overview of my coding project JavaMusicPlayer.
Github link: https://github.com/TboyBell/JavaMusicPlayerGit.git

This project holds a special place in both my heart and portfolio, as it represents one of the first full-fledged applications I successfully built using Java. Through this journey, I learned invaluable lessons about programming and software development, which went far beyond simply just coding 
I made several key discoveries:

Problem-solving is as essential as technical knowledge. Coding is more than just writing correct syntax—it requires creative problem-solving, especially when tackling real-world development challenges.

Functionality over aesthetics. While building this project, I realized that the real measure of success isn't how visually appealing or complex the solution appears, but rather whether it serves its intended purpose efficiently and effectively.

Growth through learning. I came to understand that gaps in my knowledge don’t indicate a lack of intelligence, all it means is that I am yet to full understand the concept, and require some assistance.


I learnt this lessons and so much more, as I worked on this music player. 
When I later felt that my skills had evolved, I revisited the project to refine and enhance it, ultimately producing the version you see today (though there are still a few minor bugs). 
The improvements reflect my growth as a developer and the continuous learning that drives me forward.


Lets get into the code:

I start the code by declaring my JFrame as static because I will be using it beyond just the main method. I also declare a static Clip object and a boolean variable that will be used later.

"I used private because originally I built this project with multiple classes."


static JFrame frame;
	private static Clip clip;
	private static boolean isPaused;
	private static boolean isLooping;


Within my main method I began defining the attributes of my JFrame.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		frame = new JFrame("Music-Player");
		frame.setSize(600,150);
		frame.setResizable(false);
		frame.setLayout(null); // I find it easier to use a null layout and manually position everything.

    // This is a pretty complicated closing operation and comparatively slower,
    // but the reason I use this is because I once built a program
    // where I needed to enter a new window and close the previous one,
    // and this was the method that came up.
    // I continue to do this as a little challenge to see if I can remember the code completely.
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitApp();
			}
		});
		
        // This is what the exitapp method does.
        public static void exitApp() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		
	}


// I created my Font object in advance and configured it to make applying fonts to my components much easier.
Font font = new Font("Franklin Gothic Medium",Font.ITALIC,15);
		
    // The JTextField has been the most impactful JComponent I've learned recently.
    // Understanding how to create a field that can display text on the GUI
    // and allow for user input has been crucial to my projects.
    // It’s a simple piece of code, but it has enabled me to take on more complex projects.
		JTextField display = new JTextField();
		display.setEditable(false);
		display.setFont(font);
		display.setBackground(Color.WHITE);
		display.setBounds(15, 25, 300, 25);
		frame.add(display);
		
		// Here, I defined the attributes of the file chooser for users
        // to select the music they want to play.
		JButton chooseFile = new JButton("Choose");
		chooseFile.setFocusable(false);
		chooseFile.setFont(font);
		chooseFile.setBounds(320, 25, 100, 30);
		chooseFile.addActionListener(new ActionListener() {

			  public void actionPerformed(ActionEvent e) {
	                JFileChooser fileChooser = new JFileChooser();
                            // This filter ensures that the chooser only selects WAV files.
	                FileNameExtensionFilter filter = new FileNameExtensionFilter("Wav Files", "wav");
	                fileChooser.setFileFilter(filter);

                    // 'userAction' stores the result of the file chooser's action,
                     // either approved or canceled.
                     // 'selectedFile' is a File object that stores the chosen file,
                     // allowing us to do things like display its path in the JTextField.
	                int userAction = fileChooser.showOpenDialog(null);
	                File selectedFile = fileChooser.getSelectedFile();

	                if (userAction == JFileChooser.APPROVE_OPTION && selectedFile != null) {
	                    display.setText(selectedFile.getAbsolutePath());
	                }
                    // Error handling.
	                else {
	                	JOptionPane.showMessageDialog(null, "No File Selected");
						display.setText("No File Selected");
	                }
	            }
	        });
	        frame.add(chooseFile);
	        

Now the complicated areas in the code.

// First, we have the 'Play' button.
// I configured it and set its bounds on the frame.
// Then, I added an ActionListener and created a method called `playMusic()` below.
JButton play = new JButton("Play");	
		play.setFocusable(false);
		play.setBounds(430, 25, 100, 30);
	
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				playMusic();
            }

            // This method is responsible for actually playing the music.
			private void playMusic() {
				// TODO Auto-generated method stub
				
                // This ensure that what ever clip is playing is stopped before we continue.
				if(clip != null && clip.isRunning()) {
					clip.stop();
				}
				
                // I surround the main play function with try/catch blocks for error handling.

				try
				{  
                    //I Access the file to play music,
                    // by getting the text directly from the 'display field.
                    //Our selectedFile' object is within a method scope, making it a local variable.
                    // I then use 'AudioInputStream', 'AudioSystem', and 'Clip' objects
                    // to read the file and play it.
					File file = new File(display.getText());
					AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			
                // Initialize the clip to begin playing.
					clip = AudioSystem.getClip();
					clip.open(audio);
					
                    //I use an if statement to check if looping is activated.
                    // If yes, the clip will loop continuously until 'isLooping' is false.
					if(isLooping) {
						clip.loop(Clip.LOOP_CONTINUOUSLY);					
						}
					
					clip.start();

				} //Erorr Handling.
				catch (FileNotFoundException e) {
				    JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage() + ". Please use the Choose button to select a file.");
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
			}
			
		});
		frame.add(play);


        Next up is the pause button.
        
        // Like the other components in this code,
        // I initialized the 'Pause' button and set the necessary attributes.
        JButton pause = new JButton("Pause");	
		pause.setFocusable(false);
		pause.setBounds(320, 70, 100, 30);
		pause.addActionListener(new ActionListener() {
			
            // I added an ActionListener and created a method called 'pauseMusic',
            // which configures the button's behavior when it is pressed.
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pauseMusic();
			}

            // But wait...
            // It gets interesting!
            // When I finished building the program, I encountered a bug I couldn't fix,
            // Originally, I planned for the pause button to change its text 
            //to "Resume" and pause the music when pressed.
            // Then, when the button, now labeled "Resume", was pressed, 
            //the music was supposed to continue playing,
            // and the text would change back to "Pause".
            // Unfortunately, it didn't work as expected, and I didn't get around to fixing it.
            // As I write this, I've decided to investigate what went wrong and have found the issue.


            // I will display the previous code in quotation marks to explain what I changed.
			private void pauseMusic() {
				// TODO Auto-generated method stub

                // Here, the logic is as intended:
                // If the clip is not null and is running:
                // - Stop the clip.
                // - Set the boolean variable 'isPaused' to true.
                // - Change the pause button text to "Resume".
					if(clip != null && clip.isRunning()) {
						clip.stop();
						isPaused = true;
						pause.setText("Resume");
					}

                    Broken Code :
                    "else if(clip != null && isPaused = false) {
					
						clip.start();
						
						if(isLooping) {
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
					
					isPaused = false;
					pause.setText("Pause");
				}"
                
                    // Here is where the issue arises:
                    // 1) The 'isPaused = false;' statement is outside the else-if clause,
                    //    which means that every time the original if statement is true,
                    //    'isPaused' is set to false as the code continues executing.
                    //    So when the else-if clause was supposed to handle both conditions—
                    //    restarting the clip and setting 'isPaused' to false—
                    //    'isPaused' was already set to false, so the code never runs as intended.

                    // 2) Additionally, the following code:
                    //    "pause.setText("Pause");
                    //     if (isLooping) {
                    //         clip.loop(Clip.LOOP_CONTINUOUSLY); }"
                    //    was also outside the else-if clause,
                    //    which prevented the button text from changing to "Resume" and caused it to immediately change back to "Pause".
                    
                    //    The 'isLooping' clause was also outside the else-if statement,
                    //    so any ongoing loop would continue as expected.
                    

					else if(clip != null && isPaused == true) {
					
						clip.start();
						isPaused = false;
						pause.setText("Pause");
                        if(isLooping) {
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
					
					
				}			
		});
		frame.add(pause);

        Finally You Have Our Looping.



        // As usal i initialized the 'Pause' button and set the necessary attributes.
        // Then added my actionlsistener and created a method called 'loopMusic()'.
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
                // Toggle the value of 'isLooping'.
                // If 'isLooping' is true, it will be set to false.
                // If 'isLooping' is false, it will be set to true.
				isLooping =  !isLooping;

                // Use 'Clip.LOOP_CONTINUOUSLY' to loop the clip continuously when pressed.
                // Use 'clip.loop(0)' to stop the looping.
				if(clip != null && isLooping) {
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
			} // And Error Handling Again.
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage() + ". Please use the Choose button to select a file.");
			}
			}
			
			
		});
		frame.add(loop);
		

		frame.setVisible(true);



In conclusion, I hope this brief overview has effectively demonstrated my technical abilities in programming,
my growth as a developer, and showcased the lessons I’ve learned about problem-solving, functionality,
and continuous improvement. This project has served as a foundation for my continued development and
reminds me that coding is an evolving process and a exciting journey. 

With each new project, I try my best to carry forward the knowledge gained here, always striving to
create software that is not just functional but meaningful. 

This music player, though not perfect....Yet. Is a reflection of that journey, one of
progress, persistence, and a dedication to learning.

Thank You,
Yours Sincerely,
Oluwatomi Bell.

P.S The app is also on github if you would rather run that version.