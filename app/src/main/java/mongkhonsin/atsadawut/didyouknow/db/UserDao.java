package mongkhonsin.atsadawut.didyouknow.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import mongkhonsin.atsadawut.didyouknow.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    User[] getAllUsers();

    @Query("SELECT * FROM users WHERE id LIKE :userId")
    User getUserById(String userId);

    @Insert
    void addUser(User... users);

    @Delete
    void deleteUser(User user);

    @Query("UPDATE users SET generalCategoryScore = :generalCategoryScore WHERE id = :userId")
    int updateGeneralScore(String userId, int generalCategoryScore);

    @Query("UPDATE users SET foodCategoryScore = :foodCategoryScore WHERE id = :userId")
    int updateFoodScore(String userId, int foodCategoryScore);

    @Query("UPDATE users SET animalCategoryScore = :animalCategoryScore WHERE id = :userId")
    int updateAnimalScore(String userId, int animalCategoryScore);

    @Query("UPDATE users SET artistCategoryScore = :artistCategoryScore WHERE id = :userId")
    int updateArtistScore(String userId, int artistCategoryScore);

}