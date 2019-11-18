package igal.m.triviac;
        import android.app.Notification;
        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.media.MediaPlayer;
        import android.widget.Chronometer;
        import android.os.SystemClock;
        import com.polyak.iconswitch.IconSwitch;

public class QuizActivity extends AppCompatActivity {

    MediaPlayer player; //shela tova
    MediaPlayer player2; //SOUND OF THE GAME! 31.8,19

    MediaPlayer player3; //mngina shel azra HELP
    MediaPlayer player4; //END OF GAME

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running ;    //TIMER

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    public TextView mScoreView;
    private TextView mQuestionView;
    public Button mButtonChoice1;
    public Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);

        //updateQuestion();

        player2= null;

        if (player2 == null) {
            player2 = MediaPlayer.create(this, R.raw.sound);//sound comtinue 2 with join to game
            player2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

        player2.start();


        updateQuestion();

        player4= null;

        if (player4 == null) {
            player4 = MediaPlayer.create(this, R.raw.end);//sound comtinue 2 with join to game
            player4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

    //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer) {


                    if (player == null) {
                        player = MediaPlayer.create(QuizActivity.this, R.raw.helpme); //sound ba rand for good sheala tova!! :)
                        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                            }
                        });
                    }

                    player.start(); // SOUND GOOD ANSER

                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "תשובה נכונה", Toast.LENGTH_SHORT).show();
                    resetChronometer();



                }
                else
                {
                        Toast.makeText(QuizActivity.this, "טעות", Toast.LENGTH_SHORT).show();
                    resetChronometer();

                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer) {
                    player.start();

                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "תשובה נכונה", Toast.LENGTH_SHORT).show();
                    resetChronometer();

                } else {

                    Toast.makeText(QuizActivity.this, "טעות", Toast.LENGTH_SHORT).show();
                    resetChronometer();

                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer) {
                    player.start();

                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizActivity.this, "תשובה נכונה", Toast.LENGTH_SHORT).show();
                    resetChronometer();


                } else {


                    Toast.makeText(QuizActivity.this, "טעות", Toast.LENGTH_SHORT).show();
                    resetChronometer();

                    updateQuestion();
                }


            }
        });

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("זמן: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 60000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    {
                        Toast.makeText(QuizActivity.this, "נגמר הזמן!", Toast.LENGTH_SHORT).show();
                        resetChronometer();
                        updateQuestion();
                    }
                }
            }
        });
       // pauseChronometer();
        resetChronometer();
        startChronometer();


        IconSwitch iconSwitch = findViewById(R.id.icon_switch);
        iconSwitch.setCheckedChangeListener(new IconSwitch.CheckedChangeListener() {
            @Override
            public void onCheckChanged(IconSwitch.Checked current) {
                switch (current) {
                    case LEFT:
                        {
                        Toast.makeText(QuizActivity.this, "להשתיק מנגינה", Toast.LENGTH_SHORT).show();
                            stopPlayer();
                            break;
                    }
                    case RIGHT: //--> RIGHT SOUND on
                    {

                        Toast.makeText(QuizActivity.this, "להפעיל מנגינה", Toast.LENGTH_SHORT).show();

                        player2.start();

                        break;
                    }
                }
            }
        });
    }






        //End of Button Listener for Button3
    //public String playagain = "play again?";

    private void updateQuestion(){

        if(mQuestionNumber<mQuestionLibrary.getLenght())
        {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
            else
        {
            Toast.makeText(QuizActivity.this, "נגמרו השאלות!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, highscore.class);
            player4.start();
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    String helpbtn;
    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    public void helpbotton(View view) {

        player3=null;
        player3 = MediaPlayer.create(QuizActivity.this, R.raw.rank); //sound mangina reka shel ha mishak
        player3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });
        player3.start();

        helpbtn = mAnswer;
        Toast.makeText(QuizActivity.this, helpbtn , Toast.LENGTH_SHORT).show();


    }


    public void startChronometer() {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer() {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer() {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    private void stopPlayer() {
        if (player2 != null) {
            player2.pause();
            //player2 = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}

