/**
 * Class: Playlist.java
 * Purpose: Compiling and printing a playlist
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    public static final String ANSI_RESET = "\u001B[0m"; // end string for ansi color
    public static final String ANSI_RED = "\u001B[31m"; // string for red text

    public static void main(String[] args) {

        int addingSongs; // variable for determining if user wants to continue adding songs

        int playlistDuration = 0; // variable for keeping a total duration of the playlist as songs are added

        ArrayList<String> playlist = new ArrayList<String>(); // create arraylist for storing song objects for each entered song

        Scanner sc = new Scanner(System.in); // create scanner for user song input

        System.out.println("Welcome to playlist maker 5000 - Spotify for cool kids");

        // This do while loop will prompt the user to enter a song
        // and store it in the arraylist until the user enters 0
        do {
            System.out.println("Please enter one by one: song, artist, duration in seconds\n"); // request user input

            Song song = new Song(sc.nextLine(), sc.nextLine(),sc.nextInt()); // create object with user input

            playlistDuration += song.getDuration(); // add song duration to total duration

            String name = song.toString(); // get combined string from the three inputs

            playlist.add(name); // add the combined string

            System.out.printf("Thanks for adding %s\n\n", name.split("\\((?:.(?!\\())+$")[0]); // print out song and artist

            System.out.printf("Have more songs to add? %s1%s for yes and %s0%s for no.\n", // ask user if they're done adding songs
                              ANSI_RED, ANSI_RESET, ANSI_RED, ANSI_RESET);
            addingSongs = sc.nextInt(); // store input from user
            sc.nextLine(); // go to next line in prep for next loop
        } while (addingSongs == 1); // check if user wants to continue before looping again

        System.out.println("\nHere's your playlist:\n");

        // Iterate through the playlist arraylist, printing them out one by one
        for (int i = 0; i < playlist.size(); i++){
            System.out.printf("%d. %s\n", i+1, playlist.get(i));
        }

        System.out.printf("\nYour playlist is a total of %sm %ss", playlistDuration / 60, playlistDuration % 60); // calculate the playlist duration in minutes and print it out

    }
}


/*

**TEST VALUES**

You Learn
Alanis Morrissette
300
1
Killing in the Name
Rage Against the Machine
400
1
Train in Vain (Stand by Me)
The Clash
200
1
Heroes
David Bowie
300
1
The Black Hawk War, or, How to Demolish an Entire Civilization and Still Feel Good About Yourself in the Morning, or, We Apologize for the Inconvenience but You're Going to Have to Leave Now, or, 'I Have Fought the Big Knives and Will Continue to Fight Them Until They Are Off Our Lands'
Sufjan Stevens
800
1
Several Species of Small Furry Animals Gathered Together in a Cave and Grooving with a Pict
Pink Floyd
100
1
Androgynous
The Replacements
200

^^^Make sure to include one line of space at the end or just press enter once you paste^^^
 */