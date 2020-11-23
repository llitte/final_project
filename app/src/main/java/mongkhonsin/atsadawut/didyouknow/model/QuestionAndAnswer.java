package mongkhonsin.atsadawut.didyouknow.model;

public class QuestionAndAnswer {

    public String question, choice1, choice2 ,choice3, choice4, correctAnswer;

    public QuestionAndAnswer(String question, String choice1, String choice2, String choice3, String choice4, String correctAnswer) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.correctAnswer = correctAnswer;
    }
}
