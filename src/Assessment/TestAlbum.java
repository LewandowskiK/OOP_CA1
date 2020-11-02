package Assessment;
//TestAlbum.java
/*This program will test the Song and Album objects by calling them in various
* scenarios to ensure that the setters and getters function properly and that
* the user defined functions output as planned*/

import javax.swing.*;
import java.awt.*;

public class TestAlbum {
    public static void main(String[] args) {
        JTextArea textArea = new JTextArea();
        Font font = new Font("monospaced",Font.PLAIN,12);
        textArea.setFont(font);
        textArea.setSize(65,25);

        Song song1 = new Song("Sugar Baby Love", "Rubettes", "Pop", 136, 1977);
        Song song2 = new Song("Living on a Prayer", "Bon Jovi", "Rock", 184, 1985);
        Song song3 = new Song("Blue Suede Shoes", "Elvis Presley", "Pop", 157, 1963);
        Song song4 = new Song("Someone Like You", "Adele", "Pop", 223, 2013);
        Song song5 = new Song("House of Fun", "Madness", "Pop", 178, 1984);

        Song[] tracks = new Song[]{song1,song2,song3,song4,song5};

        Album album = new Album("Now that’s what I call music 98",tracks,"Universal Music", 2016);

        textArea.append(album.toString());

        JOptionPane.showMessageDialog(null,textArea,"Album Information",JOptionPane.INFORMATION_MESSAGE);

        album.playTrack(Integer.parseInt(JOptionPane.showInputDialog("Which track number would you like to play?")));

        album.shuffle();

        System.exit(0);
    }
}
