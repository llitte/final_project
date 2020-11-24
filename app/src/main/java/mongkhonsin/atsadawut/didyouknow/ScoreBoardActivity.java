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

    private TextView Id, generalScoreTextView, foodScoreTextView, artistScoreTextView, animalScoreTextView;
    private String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        Intent i = getIntent();
        userId = i.getStringExtra("userId");

        Id = findViewById(R.id.user_id_text_view);

        generalScoreTextView = findViewById(R.id.general_score_text_view);
        foodScoreTextView = findViewById(R.id.food_score_text_view);
        artistScoreTextView = findViewById(R.id.artist_score_text_view);
        animalScoreTextView = findViewById(R.id.animal_score_text_view);

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(ScoreBoardActivity.this);
                User user1 = db.userDao().getUserById(userId);
                Id.setText("" + user1.userName);

                //db.userDao().updateAnimalScore(userId, count);
                //animalScoreTextView.setText("" + db.userDao().getUserById(userId).animalCategoryScore);
            }
        });
        executors.mainThread().execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}