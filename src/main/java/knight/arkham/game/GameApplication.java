package knight.arkham.game;

import knight.arkham.game.enums.Genre;
import knight.arkham.game.models.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup(VideoGameService videoGameService) {
        return args -> {

            List<VideoGame> videoGameList = new ArrayList<>();

            var date = new Date();

            var videoGame1 = new VideoGame("Naruto Ultimate Ninja","Bandai Namco",date, Genre.Fighting, 1200000,"Single-player, multiplayer",85,1500,"naruto.jpg",5);
            var videoGame2 = new VideoGame("Naruto Ultimate Ninja 2","Bandai Namco",date,Genre.Fighting, 1400000,"Single-player, multiplayer",95,1300,"naruto2.jpg",5);
            var videoGame3 = new VideoGame("Naruto Ultimate Ninja 3","Bandai Namco",date,Genre.Fighting, 1500000,"Single-player, multiplayer",80,1250,"naruto3.jpg",5);
            var videoGame4 = new VideoGame("Naruto Ultimate Ninja 4","Bandai Namco",date,Genre.Fighting, 2000000,"Single-player, multiplayer",90,1800,"naruto4.jpg",3);
            var videoGame5 = new VideoGame("Naruto Ultimate Ninja 5","Bandai Namco",date,Genre.Fighting, 1800000,"Single-player, multiplayer",96,2350,"naruto5.jpg",5);
            var videoGame6 = new VideoGame("God of War II","Santa Monica Studio",date,Genre.Hack, 4600000,"Single-player",98,2100,"god of war 2.jpg",4);
            var videoGame7 = new VideoGame("God of War","Santa Monica Studio",date,Genre.Hack, 5000000,"Single-player",99,2000,"god of war.jpg",4);
            var videoGame8 = new VideoGame("Kingdom Hearts","Square Enix",date,Genre.JRPG, 4800000,"Single-player",97,2200,"kh.jpg",5);
            var videoGame9 = new VideoGame("Kingdom Hearts II","Square Enix",date,Genre.JRPG, 4000000,"Single-player",95,1550,"kh 2.jpg",5);

            videoGameList.add(videoGame1);
            videoGameList.add(videoGame2);
            videoGameList.add(videoGame3);
            videoGameList.add(videoGame4);
            videoGameList.add(videoGame5);
            videoGameList.add(videoGame6);
            videoGameList.add(videoGame7);
            videoGameList.add(videoGame8);
            videoGameList.add(videoGame9);

            videoGameService.saveAllVideoGames(videoGameList);
        };
    }
}
