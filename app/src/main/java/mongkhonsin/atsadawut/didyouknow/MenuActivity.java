package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button playButton, howToPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i = getIntent();
        final String userId = i.getStringExtra("userId");

        playButton = findViewById(R.id.back_button);
        howToPlayButton = findViewById(R.id.how_to_play_button);

        // ปุ่ม เล่นเกม
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้า เลือกหมวด เพื่อเล่นเกม พร้อมส่ง id ของ user
                Intent i = new Intent(MenuActivity.this, SelectCategoryActivity.class);
                i.putExtra("userId", userId);
                startActivity(i);
            }
        });

        // ปุ่ม วิธีการเล่น
        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปยังหน้า บอกวิธีการเล่น
                Intent i = new Intent(MenuActivity.this, HowToPlayActivity.class);
                startActivity(i);
            }
        });
    }
}