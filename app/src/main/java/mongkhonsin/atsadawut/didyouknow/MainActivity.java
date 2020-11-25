package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.db.AppDatabase;
import mongkhonsin.atsadawut.didyouknow.model.User;
import mongkhonsin.atsadawut.didyouknow.util.AppExecutors;

public class MainActivity extends AppCompatActivity {

    private EditText idEditText, passwordEditText;
    private String id, password;
    private Button loginButton, registerButton;
    private TextView warningTextView;
    private User[] usersClone;
    private Boolean accountHaveInDatabase = false;

    @Override
    protected void onResume() {
        super.onResume();

        // เรียกใช้ฐานข้อมูล
        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                accountHaveInDatabase = false;
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                //final User[] users = db.userDao().getAllUsers();
                usersClone = db.userDao().getAllUsers();
                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        setEmptyText();
                    }
                });
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerButton = findViewById(R.id.register_button);
        loginButton = findViewById(R.id.login_button);
        idEditText = findViewById(R.id.id_login_edit_text);
        passwordEditText = findViewById(R.id.password_login_edit_text);
        warningTextView = findViewById(R.id.warning_login_text_view);

        // ปุ่ม ล็อกอิน
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = idEditText.getText().toString();
                password = passwordEditText.getText().toString();

                // ตรวจสอบช่องกรอก id และ password ก่อน login
                if(id.equals("") || password.equals(""))
                    warningTextView.setText("กรุณากรอก ไอดีและ พาสเวิร์ด");
                else {
                    if(usersClone.length == 0)
                        warningTextView.setText("เกิดข้อผิดพลาด กรุณาลองอีกครั้ง");
                    else{
                        for(User u: usersClone){
                            if(id.equals(u.id) && password.equals(u.password))
                                accountHaveInDatabase = true;
                        }
                        if(!accountHaveInDatabase){
                            warningTextView.setText("เกิดข้อผิดพลาด กรุณาลองอีกครั้ง");
                        }
                        else{
                            // ตรวจสอบแล้วว่า id และ password ถูกต้อง ทำการไปหน้าเมนูเกม พร้อมส่ง id ของ user
                            Intent i = new Intent(MainActivity.this, MenuActivity.class);
                            i.putExtra("userId", id);
                            startActivity(i);
                        }
                    }
                }
            }
        });

        // ปุ่ม ลงทะเบียน
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ไปหน้าลงทะเบียน
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }
    public void setEmptyText(){
        warningTextView.setText("");
        idEditText.setText("");
        passwordEditText.setText("");
    }
}