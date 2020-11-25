package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.db.AppDatabase;
import mongkhonsin.atsadawut.didyouknow.model.User;
import mongkhonsin.atsadawut.didyouknow.util.AppExecutors;

public class ScoreBoardActivity extends AppCompatActivity {

    private TextView IdTextView, generalScoreTextView, foodScoreTextView, artistScoreTextView, animalScoreTextView;
    private String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        Intent i = getIntent();
        userId = i.getStringExtra("userId");

        IdTextView = findViewById(R.id.user_id_text_view);
        generalScoreTextView = findViewById(R.id.general_score_text_view);
        foodScoreTextView = findViewById(R.id.food_score_text_view);
        artistScoreTextView = findViewById(R.id.artist_score_text_view);
        animalScoreTextView = findViewById(R.id.animal_score_text_view);

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {

                // เรียกใช้ฐานข้อมูล เพือ แสดงคะแนน ของผู้เล่น โดยใช้ id ของ user
                AppDatabase db = AppDatabase.getInstance(ScoreBoardActivity.this);
                IdTextView.setText("ชื่อ : " + db.userDao().getUserById(userId).userName);
                animalScoreTextView.setText("" + db.userDao().getUserById(userId).animalCategoryScore);
                foodScoreTextView.setText("" + db.userDao().getUserById(userId).foodCategoryScore);
                artistScoreTextView.setText("" + db.userDao().getUserById(userId).artistCategoryScore);
                generalScoreTextView.setText("" + db.userDao().getUserById(userId).generalCategoryScore);
            }
        });
        executors.mainThread().execute(new Runnable() {
            @Override
            public void run() {
                ///***
            }
        });
    }
}