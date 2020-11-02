package Assessment;
//Song.java
/*This program is a java Object that is meant to be a part of the Album object
* It is programmed to take in the following parameters:
* Title, Artist, Genre, Duration of Song(in seconds) and the Release Year.
* It will then output them in a single line with '  ' divisors between each parameter*/

public class Song {
    private static int trackID = 0;
    private int trackNumber;
    private String title;
    private String artist;
    private String genre;
    private int duration;
    private int releaseYear;

    //5-argument constructor

    public Song(String title, String artist, String genre, int duration, int releaseYear) {
        setTitle(title);
        setArtist(artist);
        setGenre(genre);
        setDuration(duration);
        setReleaseYear(releaseYear);
        setTrackNumber();
    }

    //Setters and Getters
    public int getTrackNumber() {
        return trackNumber;
    }

    private void setTrackNumber() {
        trackID++;
        this.trackNumber = trackID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    //Modified toString()
    @Override
    public String toString() {
        return "Track Number: " + getTrackNumber() + "  Title: " + getTitle() + "  Artist: " + getArtist() + "  Genre: " + getGenre() + "  Release Year: " + getReleaseYear() + "  Duration: " + getDuration() + "s";
    }
}
