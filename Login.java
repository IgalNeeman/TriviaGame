package igal.m.triviac;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
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
import android.media.MediaPlayer;

public class Login extends AppCompatActivity implements View.OnClickListener {

    // private TextView forgotPassword;
    private FirebaseAuth mAuth;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.edit_text_email);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);

        mAuth = FirebaseAuth.getInstance();
        //The getInstance() method of java.security.Provider class is used to return a Signature object that implements the specified signature algorithm.

        findViewById(R.id.SignUp_from_Login).setOnClickListener(this);
        findViewById(R.id.playagin).setOnClickListener(this);
        findViewById(R.id.ForgotPassword).setOnClickListener(this);


        if (player == null) {
            player = MediaPlayer.create(this, R.raw.vs); //sound ba knisa la mishak 1
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

    }


    //  butten onclick from Login to signup
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SignUp_from_Login:
                startActivity(new Intent(Login.this, SignUp.class));
                break;

            case R.id.playagin:
                userLogin();
                break;

            case R.id.ForgotPassword:
                startActivity(new Intent(this, ResetPassword.class));
                break;
        }
    }

    MediaPlayer player;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private void userLogin() {


            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            // check user email
            if (email.isEmpty()) {
                editTextEmail.setError("נדרש להכניס אימייל");
                editTextEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail.setError("האימייל לא נכון");
                editTextEmail.requestFocus();
                return;
            }

            // check user password
            if (password.isEmpty()) {
                editTextEmail.setError("דרושה סיסמה");
                editTextEmail.requestFocus();
                return;
            }
            if (password.length() < 6) {
                editTextPassword.setError("סיסמה תקינה יכולה להיות מינימום 6 תווים");
                editTextEmail.requestFocus();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {


                        Intent intent = new Intent(Login.this, QuizActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
//

                        editTextEmail.getText().clear();
                        editTextPassword.getText().clear();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }



    }
