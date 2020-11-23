package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswer;
import mongkhonsin.atsadawut.didyouknow.model.QuestionAndAnswerList;

public class StartGameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Intent i = getIntent();
        String category = i.getStringExtra("category");
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
}