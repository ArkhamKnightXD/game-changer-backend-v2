package knight.arkham.game.controllers;

import io.swagger.v3.oas.annotations.Operation;
import knight.arkham.game.entities.VideoGame;
import knight.arkham.game.services.VideoGameService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/games/")
@RestController
public class VideoGameController {

    private final VideoGameService videoGameService;

    public VideoGameController(VideoGameService videoGameService) {
        this.videoGameService = videoGameService;
    }


    @GetMapping("pagination/{pageSize}/{sortIdentifier}/{isAscending}")
    @Operation(summary = "Get All Video Games With Pagination", description = "Consigue la lista de todos los videojuegos con paginación")
    public ResponseEntity<Page<VideoGame>> getAllVideoGamesWithPagination(@PathVariable int pageSize, @PathVariable String sortIdentifier, @PathVariable boolean isAscending) {

        return new ResponseEntity<>(videoGameService.getAllWithPagination(pageSize, sortIdentifier, isAscending), HttpStatus.OK);
    }


    @GetMapping
    @Operation(summary = "Get All Video Games", description = "Consigue la lista de todos los videojuegos")
    public ResponseEntity<List<VideoGame>> getAllVideoGames() {

        return new ResponseEntity<>(videoGameService.getAll(), HttpStatus.OK);
    }


    @GetMapping("{videoGameId}")
    @Operation(summary = "Get A Video Game By Id", description = "Retorna un videojuego con el id correspondiente")
    public ResponseEntity<VideoGame> getVideoGameById(@PathVariable long videoGameId) {

        var actualVideoGame = videoGameService.getById(videoGameId);

        if (actualVideoGame != null)
            return new ResponseEntity<>(actualVideoGame, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @PostMapping
    @Operation(summary = "Save Video Game", description = "Crear videojuego")
    public ResponseEntity<List<VideoGame>> saveVideoGame(@RequestBody VideoGame videoGameToSave) {

        var videoGames= videoGameService.save(videoGameToSave);

        return new ResponseEntity<>(videoGames, HttpStatus.OK);
    }


    @PutMapping
    @Operation(summary = "Update Video Game", description = "Actualiza el videojuego enviado")
    public ResponseEntity<List<VideoGame>> updateVideoGame(@RequestBody VideoGame updatedVideoGame) {

        var videoGames = videoGameService.update(updatedVideoGame);

        return new ResponseEntity<>(videoGames, HttpStatus.OK);
    }


    @DeleteMapping("{videoGameId}")
    @Operation(summary = "Delete A Video Game By Id", description = "Elimina un videojuego con el id correspondiente")
    public ResponseEntity<List<VideoGame>> deleteVideoGameById(@PathVariable long videoGameId) {

        videoGameService.deleteById(videoGameId);

        return new ResponseEntity<>(videoGameService.getAll(), HttpStatus.OK);
    }
}
