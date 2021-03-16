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

            VideoGame videoGame = new VideoGame();

            videoGame.setName("Naruto");
            videoGame.setGenre("Fighting game");

            videoGameService.saveVideoGame(videoGame);

            openIndexPage();
        };
    }
}
