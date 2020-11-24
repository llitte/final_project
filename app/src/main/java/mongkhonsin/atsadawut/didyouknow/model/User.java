package mongkhonsin.atsadawut.didyouknow.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public final int userIdInDatabase;

    @ColumnInfo(name = "id")
    public final String id;

    @ColumnInfo(name = "username")
    public final String userName;

    @ColumnInfo(name = "password")
    public final String password;

    public int generalCategoryScore;
    public int animalCategoryScore;
    public int artistCategoryScore;
    public int foodCategoryScore;

    public User(int userIdInDatabase, String id, String userName, String password) {
        this.userIdInDatabase = userIdInDatabase;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.generalCategoryScore = 0;
        this.animalCategoryScore = 0;
        this.artistCategoryScore = 0;
        this.foodCategoryScore = 0;
    }
}
