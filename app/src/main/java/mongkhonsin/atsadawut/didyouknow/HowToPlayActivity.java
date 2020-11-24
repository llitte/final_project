package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HowToPlayActivity extends AppCompatActivity {

    private Button backButton;
    private TextView howToPlayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        howToPlayTextView = findViewById(R.id.how_to_play_text_view);
        howToPlayTextView.setText("วิธีการเล่น : กด เล่นเกม เพื่อเลือกหมวด คำถาม แล้วเลือกข้อที่ถูกที่สุด คำถาม มีทั้งหมด 5 ข้อ ในแต่ละหมวด");

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}