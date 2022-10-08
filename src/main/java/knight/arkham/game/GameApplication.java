package knight.arkham.game;

import knight.arkham.game.enums.Genre;
import knight.arkham.game.entities.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class GameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup(VideoGameService videoGameService) {
        return args -> {

            var videoGames = new ArrayList<VideoGame>();

            var date = new Date();

            var videoGame1 = new VideoGame("Naruto Ultimate Ninja","Bandai Namco",date, Genre.Fighting,
                    1200000,"Single-player, multiplayer",85,1500,"naruto.jpg",5);
            var videoGame2 = new VideoGame("Naruto Ultimate Ninja 2","Bandai Namco",date,Genre.Fighting,
                    1400000,"Single-player, multiplayer",95,1300,"naruto2.jpg",5);
            var videoGame3 = new VideoGame("Naruto Ultimate Ninja 3","Bandai Namco",date,Genre.Fighting,
                    1500000,"Single-player, multiplayer",80,1250,"naruto3.jpg",5);
            var videoGame4 = new VideoGame("Naruto Ultimate Ninja 4","Bandai Namco",date,Genre.Fighting,
                    2000000,"Single-player, multiplayer",90,1800,"naruto4.jpg",3);
            var videoGame5 = new VideoGame("Naruto Ultimate Ninja 5","Bandai Namco",date,Genre.Fighting,
                    1800000,"Single-player, multiplayer",96,2350,"naruto5.jpg",5);
            var videoGame6 = new VideoGame("God of War II","Santa Monica Studio",date,Genre.Hack,
                    4600000,"Single-player",98,2100,"god of war 2.jpg",4);
            var videoGame7 = new VideoGame("God of War","Santa Monica Studio",date,Genre.Action,
                    5000000,"Single-player",99,2000,"god of war.jpg",4);
            var videoGame8 = new VideoGame("Kingdom Hearts","Square Enix",date,Genre.RPG,
                    4800000,"Single-player",97,2200,"kh.jpg",5);
            var videoGame9 = new VideoGame("Kingdom Hearts II","Square Enix",date,Genre.JRPG,
                    4000000,"Single-player",95,1550,"kh 2.jpg",5);
            var videoGame10 = new VideoGame("NBA 2K12","Virtuos",date,Genre.Sport, 4000000,
                    "Single-player, multiplayer",95,1550, "nba-2k.jpg",5);
            var videoGame11 = new VideoGame("Need For Speed","EA",date,Genre.Racing, 4000000,
                    "Single-player, multiplayer",90,2000,"need.jpg",2);
            var videoGame12 = new VideoGame("Final Fantasy XII","Square Enix",date,Genre.Strategy,
                    4000000, "Single-player",93,2100,"FF.jpg",2);

            videoGames.add(videoGame1);
            videoGames.add(videoGame2);
            videoGames.add(videoGame3);
            videoGames.add(videoGame4);
            videoGames.add(videoGame5);
            videoGames.add(videoGame6);
            videoGames.add(videoGame7);
            videoGames.add(videoGame8);
            videoGames.add(videoGame9);
            videoGames.add(videoGame10);
            videoGames.add(videoGame11);
            videoGames.add(videoGame12);

            videoGameService.saveAll(videoGames);
        };
    }
}
