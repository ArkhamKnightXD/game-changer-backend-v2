package knight.arkham.game.services;

import knight.arkham.game.entities.VideoGame;
import knight.arkham.game.repositories.VideoGameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoGameService {

    private final VideoGameRepository videoGameRepository;

    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }


    public Page<VideoGame> getAllWithPagination(int pageSize, String sortIdentifier, boolean isAscending) {

        Pageable paginationData;

        if (isAscending)
            paginationData = PageRequest.of(0, pageSize, Sort.by(sortIdentifier).ascending());

        else
            paginationData = PageRequest.of(0, pageSize, Sort.by(sortIdentifier).descending());

        return videoGameRepository.findAll(paginationData);
    }


    public List<VideoGame> getAll() {

        return videoGameRepository.findAll();
    }


    public VideoGame getById(long videoGameId) {

        return videoGameRepository.findVideoGameById(videoGameId);
    }


    public List<VideoGame> save(VideoGame videoGameToSave) {

        videoGameRepository.save(videoGameToSave);

        return videoGameRepository.findAll();
    }


    public void saveAll(List<VideoGame> videoGamesToSave) {

        videoGameRepository.saveAll(videoGamesToSave);
    }


    public List<VideoGame> update(VideoGame updatedVideoGame) {

        var actualVideoGame = videoGameRepository.findVideoGameById(updatedVideoGame.getId());

        actualVideoGame.setName(updatedVideoGame.getName());
        actualVideoGame.setGameModes(updatedVideoGame.getGameModes());
        actualVideoGame.setDeveloper(updatedVideoGame.getDeveloper());
        actualVideoGame.setGenre(updatedVideoGame.getGenre());
        actualVideoGame.setSellPrice(updatedVideoGame.getSellPrice());
        actualVideoGame.setStock(updatedVideoGame.getStock());

        videoGameRepository.save(actualVideoGame);

        return videoGameRepository.findAll();
    }


    public void deleteById(long videoGameId){

        try {

            videoGameRepository.deleteById(videoGameId);
        }catch (Exception exception){

            System.out.println(exception.getMessage());
        }
    }
}
