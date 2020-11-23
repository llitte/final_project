package mongkhonsin.atsadawut.didyouknow.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import mongkhonsin.atsadawut.didyouknow.model.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    User[] getAllUsers();

    @Query("SELECT * FROM users WHERE id LIKE :id")
    User getUserById(String id);

    @Insert
    void addUser(User... users);

    @Delete
    void deleteUser(User user);
}