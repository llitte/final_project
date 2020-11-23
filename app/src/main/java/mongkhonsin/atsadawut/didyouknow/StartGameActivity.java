package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswer;

public class StartGameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[] mChoiceButton = new Button[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Intent i = getIntent();
        String category = i.getStringExtra("category");
        mChoiceButton[0] = findViewById(R.id.choice1_button);
        mChoiceButton[1] = findViewById(R.id.choice2_button);
        mChoiceButton[2] = findViewById(R.id.choice3_button);
        mChoiceButton[3] = findViewById(R.id.choice4_button);
        for(int index = 0; index < 4; index++){
            mChoiceButton[index].setOnClickListener(this);
        }
        QuestionAndAnswer[] animalCategoryList = {
                // 1
                new QuestionAndAnswer(
                        "สัตว์เลี้ยงลูกด้วยนมที่อยู่ในน้ำ คือข้อใด",
                        "ปลาหมึก",
                        "ปลาโลมา",
                        "ปลากระเบน",
                        "ปลาไหล",
                        "ปลาโลมา"),
                // 2
                new QuestionAndAnswer(
                        "สัตว์ในข้อใดจัดเป็นสัตว์เลือดอุ่นทั้งหมด",
                        "เสือ จระเข้",
                        "วัว กบ",
                        "กระรอก เต่า",
                        "ชะนี นกยูง",
                        "ชะนี นกยูง"),
                // 3
                new QuestionAndAnswer(
                        "ข้อใดไม่ใช่สัตว์เลี้ยงลูกด้วยนม",
                        "แมว",
                        "กิ่งก่า",
                        "ค้างคาว",
                        "ปลาพะยูน",
                        "กิ่งก่า"),
                // 4
                new QuestionAndAnswer(
                        "สัตว์ชนิดใดไม่จัดอยู่ในพวกสัตว์ปีก",
                        "นกแก้ว",
                        "ค้างคาว",
                        "นกขุนทอง",
                        "นกกระจอกเทศ",
                        "ค้างคาว"),
                // 5
                new QuestionAndAnswer(
                        "ข้อใดที่เป็นลักษณะเหมือนกับของสัตว์ครึ่งน้ำครึ่งบกและสัตว์เลื้อยคลาน",
                        "การเคลื่อนที่",
                        "ลักษณะผิวหนัง",
                        "ไข่มีเปลือกหุ้มแข็ง",
                        "อุณหภูมร่างกาย",
                        "อุณหภูมร่างกาย")
        };

    }
    public void onClick(View view){
        Button b = findViewById(view.getId());
        AlertDialog.Builder a = new AlertDialog.Builder(StartGameActivity.this);
        a.setMessage("AAAAA");
        a.setNegativeButton("No", null);
        a.show();
    }
}