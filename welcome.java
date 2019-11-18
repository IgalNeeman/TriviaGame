package igal.m.triviac;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.media.MediaPlayer;

public class welcome extends AppCompatActivity {

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.vs); //sound ba knisa la mishak 1
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

        player.start();


    }

    public void firstimebtn(View view) {
        player= null;

        if (player == null) {
            player = MediaPlayer.create(this, R.raw.continue1);//sound comtinue 2 with join to game
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });
        }

        player.start();

        Intent mySuperIntent = new Intent(welcome.this, SignUp.class);
        startActivity(mySuperIntent);
    }
}



