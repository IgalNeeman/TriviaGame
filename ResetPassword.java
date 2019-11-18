package igal.m.triviac;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private TextView SignUp_from_ResetPassword;
    private EditText Email;
    private Button ResetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);


        Email = (EditText) findViewById(R.id.editTextEmailResetPassword);
        ResetPassword = (Button) findViewById(R.id.btnResetPassword);
        firebaseAuth = FirebaseAuth.getInstance();
        SignUp_from_ResetPassword = findViewById(R.id.SignUp_from_ResetPassword);

        SignUp_from_ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.SignUp_from_ResetPassword:
                        startActivity(new Intent(ResetPassword.this, SignUp.class));
                        break;
                }
            }
        });

        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                String useremail = Email.getText().toString().trim();

                if (useremail.isEmpty()) {
                    Toast.makeText(ResetPassword.this, "אנא הכניסו את האימייל שנרשמתם איתו", Toast.LENGTH_SHORT).show();

                } else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetPassword.this, "הסיסמה אופסה ונישלחה לאימייל", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ResetPassword.this, Login.class));
                            } else {
                                Toast.makeText(ResetPassword.this, "Error in sending password reset email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

}