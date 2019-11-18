package igal.m.triviac;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.database.FirebaseDatabase;
import android.media.MediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
public class SignUp extends AppCompatActivity implements View.OnClickListener
{
    private EditText editTextName, editTextEmail, editTextPhoneNumber, editTextPassword;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);
            databaseUsers = FirebaseDatabase.getInstance();//
            firebaseAuth = FirebaseAuth.getInstance();
            editTextName = findViewById(R.id.editTextName);
            editTextEmail = findViewById(R.id.editTextEmail);
            editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
            editTextPassword = findViewById(R.id.editTextPassword);
            findViewById(R.id.Login_from_SignUp).setOnClickListener(this);
            findViewById(R.id.btnRegister).setOnClickListener(this);
    }
//  butten onclick from signup to Login
        @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
        @Override
        public void onClick (View v)
        {
            switch (v.getId()) {
                case R.id.Login_from_SignUp:
                    startActivity(new Intent(this, Login.class));
                    break;
                case R.id.btnRegister:
                    userRegister(); //func register user
                    break;
            }
        }
        @Override
        protected void onStart ()
        {
            super.onStart();
            if (firebaseAuth.getCurrentUser() != null) {
            }
        }
        @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
        private void userRegister ()
        {
            final String name = editTextName.getText().toString().trim();
            final String email = editTextEmail.getText().toString().trim();
            final String phone_number = editTextPhoneNumber.getText().toString().trim();
            final String password = editTextPassword.getText().toString().trim();
            // check user name
            if (name.isEmpty())
            {
                editTextEmail.setError("נדרש להכניס שם");
                editTextEmail.requestFocus();
            }
            if (email.isEmpty())
            {
                editTextEmail.setError("נדרש להכניס אימייל");
                editTextEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                editTextEmail.setError("הכנס בבקשה אימייל נכון");
                editTextEmail.requestFocus();
                return;
            }
            // check phone number
            if (phone_number.isEmpty())
            {
                editTextEmail.setError("נדרש אימייל");
                editTextEmail.requestFocus();
                return;
            }
            if (phone_number.length() < 10 || phone_number.length() > 11)
            {
                editTextPhoneNumber.setError("הכנס מספר טלפון נכון בעל 10 תווים");
                editTextPhoneNumber.requestFocus();
                return;
            }
            // check user password
            if (password.isEmpty())
            {
                editTextEmail.setError("נדרש להכניס סיסמה");
                editTextEmail.requestFocus();
                return;
            }

            if (password.length() < 6)
            {
                editTextPassword.setError("סיסמה צריכה להיות מינימום 6 תווים");
                editTextEmail.requestFocus();
                return;
            }
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                    {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful())
                            {
                                // save to the firebase
                                Users user = new Users( name, email, phone_number );
                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(), "User added to database", Toast.LENGTH_SHORT).show();

                                        } else {
                                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                                Toast.makeText(getApplicationContext(), "נרשמתם בהצלחה!", Toast.LENGTH_SHORT).show();
                                Intent temp = new Intent(SignUp.this, Login.class);
                                startActivity(temp);
                                finish(); // work 22.5.19

                            } else {
                                if (task.getException() instanceof FirebaseAuthActionCodeException) {
                                    Toast.makeText(getApplicationContext(), "משתמש זה נרשם כבר במערכת", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });
        }




    }
