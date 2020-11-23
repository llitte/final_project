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
    private QuestionAndAnswerList questionAndAnswerList = new QuestionAndAnswerList();
    private QuestionAndAnswer[] questionAndAnswers;
    private int item = 0 ;

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
        switch (category){
            case "general":
                questionAndAnswers = questionAndAnswerList.generalCategoryList;
                break;
            case "food":
                questionAndAnswers = questionAndAnswerList.foodCategoryList;
                break;
            case "animal":
                questionAndAnswers = questionAndAnswerList.animalCategoryList;
                break;
            case "artist":
                questionAndAnswers = questionAndAnswerList.artistCategoryList;
                break;
        }
        newQuestion();

    }
    public void newQuestion(){
        questionTextView.setText(questionAndAnswers[item].question);
        mChoiceButton[0].setText(questionAndAnswers[item].choice1);
        mChoiceButton[1].setText(questionAndAnswers[item].choice2);
        mChoiceButton[2].setText(questionAndAnswers[item].choice3);
        mChoiceButton[3].setText(questionAndAnswers[item].choice4);
    }
    public void onClick(View view){
        Button b = findViewById(view.getId());
        String str = b.getText().toString();
        AlertDialog.Builder a = new AlertDialog.Builder(StartGameActivity.this);
        a.setMessage(str);
        a.setNegativeButton("No", null);
        a.show();
        item++;
        if(item < questionAndAnswers.length)
            newQuestion();
    }
}