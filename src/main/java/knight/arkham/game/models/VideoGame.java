package knight.arkham.game.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

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

    public VideoGame() {
    }

    public VideoGame(String name, String developer, Date releasedDate, String genre, int unitsSold, String gameModes, float rating, float sellPrice, String image, int stock) {
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public String getGameModes() {
        return gameModes;
    }

    public void setGameModes(String gameModes) {
        this.gameModes = gameModes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
