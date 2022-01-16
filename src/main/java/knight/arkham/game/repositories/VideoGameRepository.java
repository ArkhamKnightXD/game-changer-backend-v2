package knight.arkham.game.repositories;

import knight.arkham.game.entities.VideoGame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    VideoGame findVideoGameById(Long id);

    @Override
    Page<VideoGame> findAll(Pageable pageable);
}
