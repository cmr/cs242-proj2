package brickettes;

import java.io.*;
import java.util.*;

public class SongCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<String, Collection<SongBean>> genre_map = new HashMap<>();


    public SongCollection() {
    }

    /**
     * De-serialize a SongCollection from a file.
     *
     * @param filename Name of file to de-serialize from
     * @return The SongCollection that was serialized.
     */
    public static SongCollection loadFromFile(String filename) {
        try {
            // FileInputStream is a binary reader
            FileInputStream fs = new FileInputStream(filename);
            // ObjectInputStream will parse objects from an InputStream
            SongCollection sc;
            try (ObjectInputStream os = new ObjectInputStream(fs)) {
                sc = (SongCollection) os.readObject();
            }

            return sc;

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + filename);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Serialize this SongCollection to a file.
     *
     * @param filename Name of file to serialize to.
     */
    public void saveToFile(String filename) {
        try {
            FileOutputStream fs = new FileOutputStream(filename);
            try (ObjectOutputStream os = new ObjectOutputStream(fs)) {
                os.writeObject(this);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + filename);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Add a given song to a genre.
     *
     * @param genre Genre to add the song to.
     * @param song Song to add
     */
    public void addSongToGenre(String genre, SongBean song) {
        if (genre_map.containsKey(genre)) {
            genre_map.get(genre).add(song);
        } else {
            Collection<SongBean> s = new HashSet<>();
            s.add(song);
            genre_map.put(genre, s);
        }
    }

    public void addGenre(String genre){
            Collection<SongBean> s = new HashSet<>();
           genre_map.put(genre, s);
    }

    /**
     * Get the songs for a given genre.
     *
     * @param genre Genre to get songs for.
     * @return Collection of songs. Mutating this will not modify the
     * SongCollection.
     */
    public Collection<SongBean> getSongsForGenre(String genre) {
        return new HashSet<>(genre_map.get(genre));
    }


    /**
     * Get the genres the collection contains.
     *
     * @return Collection of genre names.
     */
    public Collection<String> getGenres() {
        return new HashSet<>(genre_map.keySet());
    }
}
