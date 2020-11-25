package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.util.AppExecutors;

public class SelectCategoryActivity extends AppCompatActivity {

    private Button generalCategoryButton, foodCategoryButton, artistCategoryButton, animalCategoryButton, scoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        Intent i = getIntent();
        final String userId = i.getStringExtra("userId");

        // ปุ่ม หมวดความรู้ทั่วไป
        generalCategoryButton = findViewById(R.id.general_category_button);
        generalCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้าคำถามหมวดความรู้ทั่วไป พร้อมส่ง id ของ user
                intentToStartGame("general", userId);
            }
        });

        // ปุ่ม หมวดอาหาร
        foodCategoryButton = findViewById(R.id.food_category_button);
        foodCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้าคำถามหมวดอาหาร พร้อมส่ง id ของ user
                intentToStartGame("food", userId);
            }
        });

        // ปุ่ม หมวดศิลปะ
        artistCategoryButton = findViewById(R.id.artist_category_button);
        artistCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้าคำถามหมวดศิลปะ พร้อมส่ง id ของ user
                intentToStartGame("artist", userId);
            }
        });

        // ปุ่ม หมวดสัตว์
        animalCategoryButton = findViewById(R.id.animal_category_button);
        animalCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้าคำถามหมวดสัตว์ พร้อมส่ง id ของ user
                intentToStartGame("animal", userId);
            }
        });

        // ปุ่ม คะแนน
        scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้าคะแนนรวม พร้อมส่ง id ของ user
                Intent i = new Intent(SelectCategoryActivity.this, ScoreBoardActivity.class);
                i.putExtra("userId", userId);
                startActivity(i);
            }
        });
    }

    public void intentToStartGame(String category, String userId){
        Intent i = new Intent(SelectCategoryActivity.this, StartGameActivity.class);
        i.putExtra("category", category);
        i.putExtra("userId", userId);
        startActivity(i);
    }
}