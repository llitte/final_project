package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.db.AppDatabase;
import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswer;
import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswerList;
import mongkhonsin.atsadawut.didyouknow.util.AppExecutors;

public class StartGameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTextView;
    private Button[] mChoiceButton = new Button[4];
    private QuestionAndAnswerList questionAndAnswerList = new QuestionAndAnswerList();
    private QuestionAndAnswer[] questionAndAnswers;
    private int count = 0, score = 0;
    private String userId, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Intent i = getIntent();
        category = i.getStringExtra("category");
        userId = i.getStringExtra("userId");

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
        questionTextView.setText(questionAndAnswers[count].question);
        mChoiceButton[0].setText(questionAndAnswers[count].choice1);
        mChoiceButton[1].setText(questionAndAnswers[count].choice2);
        mChoiceButton[2].setText(questionAndAnswers[count].choice3);
        mChoiceButton[3].setText(questionAndAnswers[count].choice4);
    }
    public void onClick(View view){
        Button userAnswerButton = findViewById(view.getId());
        String userAnswer = userAnswerButton.getText().toString();
        if(userAnswer.equals(questionAndAnswers[count].correctAnswer))
            score++;
        count++;
        if(count < questionAndAnswers.length)
            newQuestion();
        else{
            final AppExecutors executors = new AppExecutors();
            executors.diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    AppDatabase db = AppDatabase.getInstance(StartGameActivity.this);
                    switch (category){
                        case "general":
                            if(score > db.userDao().getUserById(userId).generalCategoryScore)
                                db.userDao().updateGeneralScore(userId, score);
                            break;
                        case "food":
                            if(score > db.userDao().getUserById(userId).foodCategoryScore)
                                db.userDao().updateFoodScore(userId, score);
                            break;
                        case "animal":
                            if(score > db.userDao().getUserById(userId).animalCategoryScore)
                                db.userDao().updateAnimalScore(userId, score);
                            break;
                        case "artist":
                            if(score > db.userDao().getUserById(userId).artistCategoryScore)
                                db.userDao().updateArtistScore(userId, score);
                            break;
                    }
                }
            });
            executors.mainThread().execute(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            });

        }
    }
}