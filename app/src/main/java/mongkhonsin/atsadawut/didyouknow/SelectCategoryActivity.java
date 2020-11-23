package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.util.AppExecutors;

public class SelectCategoryActivity extends AppCompatActivity {

    private Button generalCategoryButton;
    private Button foodCategoryButton;
    private Button artistCategoryButton;
    private Button animalCategoryButton;
    private Button scoreButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        Intent i = getIntent();
        final String userId = i.getStringExtra("userId");

        generalCategoryButton = findViewById(R.id.general_category_button);
        generalCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToStartGame("general");
            }
        });

        foodCategoryButton = findViewById(R.id.food_category_button);
        foodCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToStartGame("food");
            }
        });

        artistCategoryButton = findViewById(R.id.artist_category_button);
        artistCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToStartGame("artist");
            }
        });

        animalCategoryButton = findViewById(R.id.animal_category_button);
        animalCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToStartGame("animal");
            }
        });

        scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectCategoryActivity.this, ScoreBoardActivity.class);
                i.putExtra("userId", userId);
                startActivity(i);
            }
        });

    }
    public void intentToStartGame(String category){
        Intent i = new Intent(SelectCategoryActivity.this, StartGameActivity.class);
        i.putExtra("category", category);
        startActivity(i);
    }
}