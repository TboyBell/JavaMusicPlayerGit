> Java Music Player Application

## Overview
This Java Music Player application is my first comprehensive project. It features a straightforward graphical user interface (GUI) for playing a selection of predefined music files.

The application utilizes Java Swing to build the GUI components and the Java Sound API for handling audio playback. It provides a user-friendly interface with a title, a display area for the music file path, and various controls for managing playback.

## Key Features
- **Graphical User Interface (GUI)**: Built using Java Swing, the application includes a windowed interface with interactive buttons, a display field, and file selection options.
- **Audio Playback**: Employs the Java Sound API to play .wav files.
- **Music File Selection**: Users can choose a .wav file using a file chooser dialog, with the selected file path displayed in the interface.
- **Playback Controls**: Includes buttons to play, pause, and loop music. The playback can be started, paused, or resumed, and the looping feature allows continuous playback.

## Code Overview

The code includes:
- **Frame Setup**: A JFrame to hold the GUI components, with basic configuration for size, layout, and close operations.
- **Display Area**: A JTextField to show the path of the selected music file.
- **File Selection**: A JButton that opens a JFileChooser for selecting .wav files, with the chosen file path displayed in the JTextField.
- **Playback Controls**: 
  - **Play Button**: Starts the playback of the selected file.
  - **Pause/Resume Button**: Toggles between pausing and resuming playback.
  - **Loop Button**: Toggles the looping of the music playback.
