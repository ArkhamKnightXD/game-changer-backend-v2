package knight.arkham.game.services;

import knight.arkham.game.models.VideoGame;
import knight.arkham.game.repositories.VideoGameRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoGameService {

    final VideoGameRepository videoGameRepository;

    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }


    public List<VideoGame> getAllVideoGames() {

        return videoGameRepository.findAll();
    }


    public VideoGame getVideoGameById(long videoGameId) {

        return videoGameRepository.findVideoGameById(videoGameId);
    }


    public void saveVideoGame(VideoGame videoGameToSave) {

        videoGameRepository.save(videoGameToSave);
    }


    public void updateVideoGame(VideoGame updatedVideoGame) {

        VideoGame originalVideoGame = videoGameRepository.findVideoGameById(updatedVideoGame.getId());

        originalVideoGame.setGameModes(updatedVideoGame.getGameModes());
        originalVideoGame.setDeveloper(updatedVideoGame.getDeveloper());
        originalVideoGame.setGenre(updatedVideoGame.getGenre());

        videoGameRepository.save(originalVideoGame);
    }


    public void saveAllVideoGames(List<VideoGame> videoGamesToSave) {

        videoGameRepository.saveAll(videoGamesToSave);
    }


    public void deleteVideoGameById(long videoGameId){

        videoGameRepository.deleteById(videoGameId);
    }
}
