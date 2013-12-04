/**
 * @Author: The Brickettes (Corey Richardson and Adam Kimball)
 * This is the base application. It allows you to deploy spring applications as .jars. It will generate the database file
 * if it does not already exist.
 */

package brickettes;

import java.io.File;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        File f = new File("songs.db");
        if(f.exists()){
            SpringApplication.run(Application.class, args);
        }
        else{
            SongCollection sc = new SongCollection();
            sc.addSongToGenre("Alternative", new SongBean());
            sc.saveToFile("songs.db");
            System.out.println("DONE");
            SpringApplication.run(Application.class, args);
        }
    }
}
