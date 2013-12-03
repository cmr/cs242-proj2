package brickettes;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /*
        SongCollection sc = new SongCollection();
        sc.addSongToGenre("Alternative", new SongBean());
        sc.saveToFile("songs.db");
        System.out.println("DONE");
        */
    }
}
