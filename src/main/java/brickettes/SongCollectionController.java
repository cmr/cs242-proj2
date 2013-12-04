/**
 * @author the brickettes (Corey Richardson and Adam kimball)
 * This class actually creates a SongCollection, and modifies it as it goes.
 */

package brickettes;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Collection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongCollectionController {

    private final SongCollection songCollection = SongCollection.loadFromFile("songs.db");

    @RequestMapping("/")
    public @ResponseBody
    String index() throws IOException {
        return new String(Files.readAllBytes(Paths.get("index.html")));
    }

    @RequestMapping("/all_genres")
    public @ResponseBody
    Collection<String> getGenres() {
        return songCollection.getGenres();
    }

    @RequestMapping("/get_songs")
    public @ResponseBody
    Collection<SongBean> getSongs(@RequestParam(value = "genre") String genre
    ) {
        return songCollection.getSongsForGenre(genre);
    }

    @RequestMapping(value = "/add_genre", method = RequestMethod.POST)
    public @ResponseBody
    void addGenre(@RequestParam(value = "genre") String genre
    ) {
        songCollection.addGenre(genre);
    }

    @RequestMapping(value = "/add_song", method = RequestMethod.POST)
    public @ResponseBody
    void addSong(@RequestParam(value = "genre") String genre,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "artist") String artist,
            @RequestParam(value = "duration") double duration,
            @RequestParam(value = "audioFiletype") String audioFiletype,
            @RequestParam(value = "audioFilename") String audioFilename
    ) {

        songCollection.addSongToGenre(genre,
                new SongBean(title, artist, duration, audioFiletype, audioFilename)
        );
        songCollection.saveToFile("songs.db");
    }
}
