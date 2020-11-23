package mongkhonsin.atsadawut.didyouknow.model;

public class QuestionAndAnswer {

    public String question, answer1, answer2 ,answer3, answer4, correctAnswer;

    public QuestionAndAnswer(String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }
}
