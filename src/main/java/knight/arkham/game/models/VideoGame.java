package knight.arkham.game.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class VideoGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String developer;
    private Date releasedDate;
    private String genre;
    private int unitsSold;
    private String gameModes;
    private float rating;
    private float sellPrice;
    private String image;
    private int stock;
}
