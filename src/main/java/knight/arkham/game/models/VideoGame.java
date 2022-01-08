package knight.arkham.game.models;

import knight.arkham.game.enums.Genre;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class VideoGame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String developer;
    private Date releasedDate;
    private Genre genre;
    private int unitsSold;
    private String gameModes;
    private int rating;
    private float sellPrice;
    private String image;
    private int stock;

    //dejo este constructor pues si defino el allArgsconstructor de lombok me da error ya que pide el id y aqui no pido id ni quiero hacerlo
    public VideoGame(String name, String developer, Date releasedDate, Genre genre, int unitsSold, String gameModes, int rating, float sellPrice, String image, int stock) {
        this.name = name;
        this.developer = developer;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.unitsSold = unitsSold;
        this.gameModes = gameModes;
        this.rating = rating;
        this.sellPrice = sellPrice;
        this.image = image;
        this.stock = stock;
    }
}
