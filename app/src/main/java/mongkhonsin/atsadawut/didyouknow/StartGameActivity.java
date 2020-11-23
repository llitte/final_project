package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswer;
import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswerList;

public class StartGameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private Button[] mChoiceButton = new Button[4];
    private QuestionAndAnswerList questionAndAnswer = new QuestionAndAnswerList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Intent i = getIntent();
        String category = i.getStringExtra("category");

        questionTextView = findViewById(R.id.question_text_view);
        mChoiceButton[0] = findViewById(R.id.choice1_button);
        mChoiceButton[1] = findViewById(R.id.choice2_button);
        mChoiceButton[2] = findViewById(R.id.choice3_button);
        mChoiceButton[3] = findViewById(R.id.choice4_button);
        for(int index = 0; index < 4; index++){
            mChoiceButton[index].setOnClickListener(this);
        }
        QuestionAndAnswer[] animalCategoryList = questionAndAnswer.animalCategoryList;
        questionTextView.setText(animalCategoryList[0].question);

    }
    public void onClick(View view){
        Button b = findViewById(view.getId());
        AlertDialog.Builder a = new AlertDialog.Builder(StartGameActivity.this);
        a.setMessage("AAAAA");
        a.setNegativeButton("No", null);
        a.show();
    }
}