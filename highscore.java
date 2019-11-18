package igal.m.triviac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class highscore extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        int totalscore = QuestionLibrary.getLenght();

        //recive the score from last activity by intent

        TextView highscore = findViewById(R.id.highscore);
        TextView yourscore = findViewById(R.id.yourscore);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        yourscore.setText("הניקוד שלך:" + score );
        //use shared prefrrnce to save the best score
        SharedPreferences myprof = getPreferences(MODE_PRIVATE);
        int myhighscore = myprof.getInt("highscore",0);
        if(myhighscore>=score)
            highscore.setText("הניקוד שלך:" + myhighscore);
            else
        {
            highscore.setText("מקסימום נקודות במשחק:" +totalscore);
            SharedPreferences.Editor editor = myprof.edit();
            editor.putInt("HighScore",score);
            editor.commit();
            //commit() returns true if the save works, false otherwise.
        }

    }

    public void tryagain(View view) {
          Intent intent = new Intent(highscore.this, QuizActivity.class);
        startActivity(intent);
    }
}
