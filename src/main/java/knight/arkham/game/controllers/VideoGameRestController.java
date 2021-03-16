package knight.arkham.game.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.game.models.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class VideoGameRestController {

    final VideoGameService videoGameService;

    public VideoGameRestController(VideoGameService videoGameService) {
        this.videoGameService = videoGameService;
    }


    @GetMapping("/games")
    @Operation(summary = "Get All Video Games", description = "Consigue la lista de todos los videojuegos")
    public ResponseEntity<List<VideoGame>> createClasses() {

        List<VideoGame> videoGameList = videoGameService.getAllVideoGames();

        return new ResponseEntity<>(videoGameList, HttpStatus.OK);
    }
}
