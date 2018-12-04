# CPSC-233
Programming in Java

﻿TIC-TAC-TOE


This program is an interactive board game, with both a text-based version and a
GUI-based version included. Tic-tac-toe involves two players, X and O, taking
turns marking spaces in a 3 by 3 grid. In order to win the game, the player must
place three of their marks in a horizontal, vertical, or diagonal line. This
program includes a player-versus-player mode, as well as a player-versus-computer
mode, with 5 increasingly difficult levels of AI.


________________________________________________________________________________


GETTING STARTED


Pre-requisites


In order to run and/or test this program, you will need a working installation
of the Java SE Development Kit 10. It is available for all major operating systems.


You can download it here:
http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html


Download the relevant executable file and run it. Follow the onscreen steps to
install Java on your computer. Once that is done, you can start using the program.




Running Tic-Tac-Toe


In order to run this program, first download the .zip file containing the source
code and unzip its contents into a new folder.


Then, navigate to your operating system's console (Command Prompt for Windows
and Terminal for MacOS) and navigate to the new folder's location. You must
compile the source code to be able to run it.


To do so, navigate to each folder with .java files and type


javac *.java


and press ENTER to compile the program files.


You may then type


java Application


and press ENTER to run the program.


NOTE: Both the GUI version and the text-based version use the 'Application' class
to run their respective programs. Make sure you are in the proper folder for
each version.
________________________________________________________________________________


PLAYING THE GAME


GUI Version


When the program is run, you will be greeted with the main menu. Two buttons
will be available; "PVP" and "PVE".


PVP
Click "PVP" to open the dialogue for the player-versus-player mode. Click the
"OK" button to begin the game.


The 3x3 grid presented may be immediately interacted with. Players may click on
unoccupied spaces to leave their mark. The first player will always be 'O', and
the second will always be 'X'. The first to create a line of 3 of their marks wins.
Neither player being able to will result in a tie. Press "OK" on the Game Over
dialogue to return to the main menu.


PVE
Click "PVE" to open the submenu for the player-versus-computer mode. There, you
may select from the game's five difficulty levels. Click on a level to open its
dialogue, and press "OK" to begin.


NOTE: Upon first playthrough, only Level 1 will be unlocked. You must beat a level
to unlock its subsequent difficulty level.


The 3x3 grid presented may be immediately interacted with. Players may click on
unoccupied spaces to leave their mark. The first player will always be 'O', and
the AI will always be 'X'. When the player enters their move, the AI will immediately
respond with their move. The first to create a line of 3 of their marks wins. Neither
player being able to will result in a tie. Press "OK" on the Game Over dialogue
to return to the main menu.




Text-based Version


When the program is run, you will be greeted with a text-prompt in the main menu.
Enter "1" to play PVP and "2" to play PVE.


PVP
The 3x3 grid presented may be immediately interacted with. Players may enter a
value from 0-8 to mark unoccupied spaces. If the space is full or if the input
is invalid, the player will be prompt to reenter their move. The first player
will always be 'O', and the second will always be 'X'. The first to create a
line of 3 of their marks wins. Neither player being able to will result in a tie.
When the game is finished, the winner will be declared and you will be automatically
brought back to the main menu.


PVE
Choosing "PVE" will prompt the level selection menu for AI difficulty. There, you
may input a number from 0-4 to choose from the game's five difficulty levels.
Once a difficulty is selected, press ENTER to start the game.


NOTE: Upon first playthrough, only Level 1 will be unlocked. You must beat a level
to unlock its subsequent difficulty level.


The 3x3 grid presented may be immediately interacted with. Players may enter a
value from 0-8 to mark unoccupied spaces. If the space is full or if the input
is invalid, the player will be prompt to reenter their move. The human player
will always be 'O', and the AI player will always be 'X'. The first to create a
line of 3 of their marks wins. Neither player being able to will result in a tie.
When the game is finished, the winner will be declared and you will be automatically
brought back to the main menu.


________________________________________________________________________________


STEPS TO USE J-UINT TESTING


1. Create a new folder.
2. Put junit-4.12.jar and hamcrest-core-1.3.jar in this folder.
3. Copy the test code with possible supporting files in this same folder.
4. Place source code files in the same folder.
5. Compile the code and the test code using the command: (replace : to ; on windows)
   javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
6. Run the test using the command: (replace : to ; on windows)
   java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore <test class>


NOTE: Replace <test class> with ‘AITest’ or ‘BoardTest’.


_______________________________________________________________________________


AUTHORS


-Abraham Beauferris
-Adam Beauferris
-Ahmed Zahran
-Anas Alawa
-Maichael Wang
