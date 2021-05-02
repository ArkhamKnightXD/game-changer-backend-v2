package knight.arkham.game.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.game.models.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class VideoGameRestController {

    final VideoGameService videoGameService;

    public VideoGameRestController(VideoGameService videoGameService) {
        this.videoGameService = videoGameService;
    }


    @GetMapping("/video-games")
    @Operation(summary = "Get All Video Games", description = "Consigue la lista de todos los videojuegos")
    public ResponseEntity<List<VideoGame>> getAllVideoGames() {

        List<VideoGame> videoGameList = videoGameService.getAllVideoGames();

        return new ResponseEntity<>(videoGameList, HttpStatus.OK);
    }


    @GetMapping("/get-video-game-by/{videoGameId}")
    @Operation(summary = "Get A Video Game By Id", description = "Retorna un videojuego con el id correspondiente")
    public ResponseEntity<VideoGame> getVideoGameById(@PathVariable long videoGameId) {

        VideoGame videoGameToGet = videoGameService.getVideoGameById(videoGameId);

        return new ResponseEntity<>(videoGameToGet, HttpStatus.OK);
    }


    @PostMapping("/save-video-game")
    @Operation(summary = "Save Video Game", description = "Guarda El videojuego enviado")
    public ResponseEntity<String> saveVideoGame(@RequestBody VideoGame videoGameToSave) {

        videoGameService.saveVideoGame(videoGameToSave);

        return new ResponseEntity<>("Video Game Saved", HttpStatus.OK);
    }


    @PutMapping("/update-video-game")
    @Operation(summary = "Save Video Game", description = "Guarda El videojuego enviado")
    public ResponseEntity<String> updateVideoGame(@RequestBody VideoGame updatedVideoGame) {

        videoGameService.updateVideoGame(updatedVideoGame);

        return new ResponseEntity<>("Video Game Updated", HttpStatus.OK);
    }


    @DeleteMapping("/delete-video-game-by/{videoGameId}")
    @Operation(summary = "Get A Video Game By Id", description = "Elimina un videojuego con el id correspondiente")
    public ResponseEntity<String> deleteVideoGameById(@PathVariable long videoGameId) {

        videoGameService.deleteVideoGameById(videoGameId);

        return new ResponseEntity<>("Video Game Deleted", HttpStatus.OK);
    }
}
