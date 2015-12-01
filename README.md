# Public-Stream-Rip
Instructions and resources necessary to edit, compile, and run scripts to download an audio stream in one hour increments.  Meant primarily for use in radio.


# About
This is the source code for two cooperating scripts, StreamRipper and StreamRipManager.  Both of these scripts are written in java and are meant to be run from the command prompt.  These scripts should work on any OS with Java, but have not been tested on anything but Windows and javac version 1.8.
Java is necessary to run these scripts and a Java compiler is necessary to compile the code into a runnable format
StreamRipper rips the stream into hour long segments, cutting the first hour short as to start on the hour from then on.
StreamRipMangager is not required for StreamRipper to work, but it is a convenient tool which deletes files created by the StreamRipper after they are two weeks old.


# Modifying the Source Code
In order for these scripts to function there are several spots in the source code which must be filled in with information specific to the stream you wish to rip, the computer you are running on, and some other simple information.  You can modify these files with a text editor of your choosing.

MODIFYING StreamRipper.java
    There are 2 spots you must modify in StreamRipper.java and 1 spot that you need to change if you are ripping something other than an mp3 file
    
    Line 68: enter the complete URL of the stream you wish to rip from in place of YOUR_STREAM_URL_HERE (leave the url in quotation marks).The URL of the desired stream might be found within a file such as a .m3u file, which you can access by opening the file in a text editor.
    
    Line 80: (optional) change .mp3 to the desired file format (leave in quotation marks)
    
    Line 85: enter the address of the directory (folder) where you would like the files to be written in place of YOUR_DIRECTORY_HERE (again leaving this in quotation marks).
    
MODIFIYING StreamRipManager.java 
    There is only 1 spot you must modify in StreamRipManager.java
    
    Line 25: enter the address of the directory (folder) you used in StreamRipper.java in place of YOUR_DIRECTORY_HERE (leaving this in quotation marks).
    
    
# Compiling and Running the Scripts

You must have a java compiler installed in order to compile the source code into runnable applications.  This can be downloaded for free by searching for "JDK Download"
There are many resources available for instruction on how to compile these files, but here are basic instructions on how to compile this code.

    Using the command prompt or a similar terminal application, navigate to the directory where the source code is located.  Enter the following to compile the code (after modifying of course):
    
        javac StreamRipper.java
        
        javac StreamRipManager.java
        
    Then enter the following to run the scripts:
    
        java StreamRipper
        
        java StreamRipManager
        
    You will need to use two separate command prompt instances (windows) to run both scripts.  To stop either script just exit the command prompt window that the script in question is running from.
