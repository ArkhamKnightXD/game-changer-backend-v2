package knight.arkham.game;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import knight.arkham.game.models.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Game-Changer-V2", version = "1.0", description = "API de la aplicacion game-changer-v2"))
public class GameChangerV2Application {

    public static void main(String[] args) {
        SpringApplication.run(GameChangerV2Application.class, args);
    }


    private void openIndexPage() {

        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:88/swagger.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Bean
    public CommandLineRunner startup(VideoGameService videoGameService) {
        return args -> {

//            List<VideoGame> videoGameList = new ArrayList<>();
//
//            Date date = new Date();
//
//            VideoGame videoGame = new VideoGame("Naruto Ultimate Ninja","Bandai Namco",date,"2D Fighting", 1200000,"Single-player, multiplayer",8.5f,1500,"naruto.jpg",5);
//
//            VideoGame videoGame2 = new VideoGame("Naruto Ultimate Ninja 2","Bandai Namco",date,"2D Fighting", 1400000,"Single-player, multiplayer",9.5f,1300,"naruto2.jpg",5);
//
//            VideoGame videoGame3 = new VideoGame("Naruto Ultimate Ninja 3","Bandai Namco",date,"2D Fighting", 1500000,"Single-player, multiplayer",7,1250,"naruto3.jpg",5);
//
//            VideoGame videoGame4 = new VideoGame("Naruto Ultimate Ninja 4","Bandai Namco",date,"2D Fighting", 2000000,"Single-player, multiplayer",9,1800,"naruto4.jpg",3);
//
//            VideoGame videoGame5 = new VideoGame("Naruto Ultimate Ninja 5","Bandai Namco",date,"2D Fighting", 1800000,"Single-player, multiplayer",9.6f,2350,"naruto5.jpg",5);
//
//            VideoGame videoGame6 = new VideoGame("God of War II","Santa Monica Studio",date,"Hack And Slash", 4600000,"Single-player",9.8f,2100,"god of war 2.jpg",4);
//
//            VideoGame videoGame7 = new VideoGame("God of War","Santa Monica Studio",date,"Hack And Slash", 5000000,"Single-player",9.9f,2000,"god of war.jpg",4);
//
//            VideoGame videoGame8 = new VideoGame("Kingdom Hearts","Square Enix",date,"JRPG", 4800000,"Single-player",9.7f,2200,"kh.jpg",5);
//
//            VideoGame videoGame9 = new VideoGame("Kingdom Hearts II","Square Enix",date,"JRPG", 4000000,"Single-player",9.5f,1550,"kh 2.jpg",5);
//
//            videoGameList.add(videoGame);
//            videoGameList.add(videoGame2);
//            videoGameList.add(videoGame3);
//            videoGameList.add(videoGame4);
//            videoGameList.add(videoGame5);
//            videoGameList.add(videoGame6);
//            videoGameList.add(videoGame7);
//            videoGameList.add(videoGame8);
//            videoGameList.add(videoGame9);
//
//            videoGameService.saveAllVideoGames(videoGameList);

            openIndexPage();
        };
    }
}
