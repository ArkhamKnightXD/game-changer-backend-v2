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


    public void saveVideoGame(VideoGame videoGameToSave) {

        videoGameRepository.save(videoGameToSave);
    }
}
