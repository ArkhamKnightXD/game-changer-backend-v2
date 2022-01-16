package knight.arkham.game.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.game.entities.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1")
@RestController
public class VideoGameController {

    private final VideoGameService videoGameService;

    public VideoGameController(VideoGameService videoGameService) {
        this.videoGameService = videoGameService;
    }


    @GetMapping("/video-games/pagination/{pageSize}/{sortIdentifier}/{isAscending}")
    @Operation(summary = "Get All Video Games With Pagination", description = "Consigue la lista de todos los videojuegos con paginacion")
    public ResponseEntity<Page<VideoGame>> getAllVideoGamesWithPagination(@PathVariable int pageSize, @PathVariable String sortIdentifier, @PathVariable boolean isAscending) {

        return new ResponseEntity<>(videoGameService.getAllVideoGamesWithPagination(pageSize, sortIdentifier, isAscending), HttpStatus.OK);
    }


    @GetMapping("/video-games")
    @Operation(summary = "Get All Video Games", description = "Consigue la lista de todos los videojuegos")
    public ResponseEntity<List<VideoGame>> getAllVideoGames() {

        return new ResponseEntity<>(videoGameService.getAllVideoGames(), HttpStatus.OK);
    }


    @GetMapping("/video-games/{videoGameId}")
    @Operation(summary = "Get A Video Game By Id", description = "Retorna un videojuego con el id correspondiente")
    public ResponseEntity<VideoGame> getVideoGameById(@PathVariable long videoGameId) {

        var actualVideoGame = videoGameService.getVideoGameById(videoGameId);

        if (actualVideoGame != null)
            return new ResponseEntity<>(actualVideoGame, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping("/video-games")
    @Operation(summary = "Save Video Game", description = "Crear videojuego")
    public ResponseEntity<List<VideoGame>> saveVideoGame(@RequestBody VideoGame videoGameToSave) {

        var videoGames= videoGameService.saveVideoGame(videoGameToSave);

        return new ResponseEntity<>(videoGames, HttpStatus.OK);
    }


    @PutMapping("/video-games")
    @Operation(summary = "Update Video Game", description = "Actualiza el videojuego enviado")
    public ResponseEntity<List<VideoGame>> updateVideoGame(@RequestBody VideoGame updatedVideoGame) {

        var videoGames = videoGameService.updateVideoGame(updatedVideoGame);

        return new ResponseEntity<>(videoGames, HttpStatus.OK);
    }


    @DeleteMapping("/video-games/{videoGameId}")
    @Operation(summary = "Delete A Video Game By Id", description = "Elimina un videojuego con el id correspondiente")
    public ResponseEntity<List<VideoGame>> deleteVideoGameById(@PathVariable long videoGameId) {

        videoGameService.deleteVideoGameById(videoGameId);

        return new ResponseEntity<>(videoGameService.getAllVideoGames(), HttpStatus.OK);
    }
}
