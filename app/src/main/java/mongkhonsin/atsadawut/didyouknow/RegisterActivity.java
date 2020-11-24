package mongkhonsin.atsadawut.didyouknow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import mongkhonsin.atsadawut.didyouknow.db.AppDatabase;
import mongkhonsin.atsadawut.didyouknow.model.User;
import mongkhonsin.atsadawut.didyouknow.util.AppExecutors;

public class RegisterActivity extends AppCompatActivity {

    private EditText idRegisterEditText, usernameRegisterEditText, passwordRegisterEditText, rePasswordRegisterEditText;
    private String idRegisterStr = "", usernameRegisterStr = "", passwordRegisterStr = "", rePasswordRegisterStr = "";
    private Button createAccountButton;
    private TextView warningRegisterTextView;
    private Boolean idAlreadyUsed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idRegisterEditText = findViewById(R.id.id_register_edit_text);
        usernameRegisterEditText = findViewById(R.id.username_register_edit_text);
        passwordRegisterEditText = findViewById(R.id.password_register_edit_text);
        rePasswordRegisterEditText = findViewById(R.id.re_password_register_edit_text);
        warningRegisterTextView = findViewById(R.id.warning_register_text_view);

        createAccountButton = findViewById(R.id.create_acc_button);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idRegisterStr = idRegisterEditText.getText().toString();
                usernameRegisterStr = usernameRegisterEditText.getText().toString();
                passwordRegisterStr = passwordRegisterEditText.getText().toString();
                rePasswordRegisterStr = rePasswordRegisterEditText.getText().toString();

                if (idRegisterStr.equals("") || usernameRegisterStr.equals("") || rePasswordRegisterStr.equals("") || passwordRegisterStr.equals("")){
                    warningRegisterTextView.setText("กรุณากรอกข้อมูลให้ครบ");
                }
                else if(!passwordRegisterStr.equals(rePasswordRegisterStr)){
                    warningRegisterTextView.setText("ขออภัย, พาสเวิร์ดไม่ตรงกัน");
                }
                else{
                    final User user = new User(0, idRegisterStr, usernameRegisterStr, passwordRegisterStr);
                    AppExecutors executors = new AppExecutors();
                    executors.diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            AppDatabase db = AppDatabase.getInstance(RegisterActivity.this);
                            User[] users = db.userDao().getAllUsers();
                            for (User u: users){
                                if(u.id.equals(idRegisterStr))
                                    idAlreadyUsed = true;
                            }
                            if(idAlreadyUsed){
                                warningRegisterTextView.setText("ขออภัย, ไอดีมีผู้ใช้งานแล้ว");
                                idAlreadyUsed = false;
                            }
                            else{
                                db.userDao().addUser(user);
                                finish();
                            }
                        }
                    });
                    executors.mainThread().execute(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                }
            }
        });

    }
}