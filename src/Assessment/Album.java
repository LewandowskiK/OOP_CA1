package Assessment;
//Album.java
/*This program is a Java object coded to resemble an Album.
* It will take in the following parameters:
* Name of Album, The array of Songs in the album, the Producer and the Release Year.
* It is programmed to output in a neat tabular format to be appended to a JTextArea.
* It also contains four user defined functions to do the following:
* 1. Display the Number of Tracks in the Album
* 2. Display the Time it would take for all the songs to play in seconds
* 3. To play a specific track from the album and specify if the track number is invalid
* 4. Randomly shuffle the song array and output it in a neat JOptionPane message dialog*/

import javax.swing.*;

public class Album {
    private String name;
    private Song[] tracks;
    private String producer;
    private int releaseYear;

    //4-argument Constructor
    public Album(String name, Song[] tracks, String producer, int releaseYear) {
        setName(name);
        setTracks(tracks);
        setProducer(producer);
        setReleaseYear(releaseYear);
    }

    //Setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.equals(""))
            this.name = name;
        else
            this.name = "No name specified";
    }

    public Song[] getTracks() {
        return tracks;
    }

    public void setTracks(Song[] tracks) {
        this.tracks = tracks;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    //User Defined functions

    public int getNumberOfTracks(){
        return getTracks().length;
    }

    public int getPlayingTime(){
        int totalTime = 0;
        for(Song song:getTracks())
            totalTime+=song.getDuration();
        return totalTime;
    }

    public void playTrack(int songID){
        if(songID>0&&songID<=getNumberOfTracks())
            JOptionPane.showMessageDialog(null,"Now playing track - Details as follows:\n\n" + getTracks()[songID-1],"Playing Track",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"An Invalid track number was supplied!","Bad Track Number",JOptionPane.ERROR_MESSAGE);
    }
    public void shuffle(){
        //A boolean array to see if the current song is already used
        boolean[] alreadyUsed = new boolean[getNumberOfTracks()];
        Song[] shuffledSongs = new Song[5];
        int randomSongID;
        for(int i = 0;i < shuffledSongs.length; i++){
            //Math.random generates 0,1,2,3 or 4 for each index in the songs

            randomSongID = (int)(Math.random() * 5);

            /*if the song is already used it will simply increment the number rather
            *than generate a new one since it could take a while, depending on chance,
            *to randomly generate each ID, This could be omitted but it could increase
            * computation time on random so I felt like putting it in here*/
            while (alreadyUsed[randomSongID]){
                if(randomSongID<4)
                    randomSongID++;
                else
                    randomSongID-=4;
                /*randomSongID = (int)(Math.random() * 5) could be used instead of
                * the if else statement but as explained above i did it this way */
            }
            alreadyUsed[randomSongID] = true;
            shuffledSongs[i] = getTracks()[randomSongID];
        }
        //Due to randomness the shuffled playlist could be the same as the
        // not shuffled one. This happened to me on my first test :^)

        String output = "Shuffled playlist is as follows:\n\n ";

        for (Song song: shuffledSongs)
            output += song + "\n";

        JOptionPane.showMessageDialog(null,output,"Shuffled Playlist",JOptionPane.INFORMATION_MESSAGE);
    }

    //Modified toString()

    @Override
    public String toString() {
        String output = "Name: " + getName() + "\n\nProducer: " + getProducer() + "\n\nRelease Year: " + getReleaseYear() + "\n\nNumber of tracks: " + getNumberOfTracks() + "\n\nTotal Playing time: " + getPlayingTime() + " seconds\n\n\t\tAlbum Tracks\n\n" + String.format("%-15s%-30s%-20s","Track Number","Title","Artist") + "\n\n";

        for (Song song : getTracks())
            output += String.format("%-15d%-30s%-20s",song.getTrackNumber(),song.getTitle(),song.getArtist()) + "\n\n";

        return output;
    }
}
