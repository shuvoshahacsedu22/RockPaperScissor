package com.example.shuvo.rockpaperscissor;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.Menu;
import android.widget.TextView;

import com.example.shuvo.rockpaperscissor.MainActivity;

import static com.example.shuvo.rockpaperscissor.R.*;

public class MainActivity extends Activity implements OnClickListener {

    public enum Option {
        ROCK, PAPER, SCISSORS
    }

    public enum Result {
        WIN, LOSS, DRAW
    }

    public static boolean play;
    public static int round = 0;
    public static int playerScore = 0;
    public static int androidScore = 0;
    public static Option userSelection;
    public static Result gameResult;
    TextView textview2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textview2 = (TextView) findViewById(id.textView2);
        Button buttonRock = (Button) findViewById(id.buttonRock);
        Button buttonpaper = (Button) findViewById(id.buttonPaper);
        Button buttonScissors = (Button) findViewById(id.buttonScissors);
        ImageButton buttonHome = (ImageButton) findViewById(id.imageButtonHome);

        // Set click listening event for all buttons.
        buttonRock.setOnClickListener(this);
        buttonpaper.setOnClickListener(this);
        buttonScissors.setOnClickListener(this);
        buttonHome.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        ImageView imageView = (ImageView) findViewById(id.imageViewAnswerUser);
        play = true;

        switch (v.getId()) {
            case id.buttonRock:
                userSelection = Option.ROCK;
                imageView.setImageResource(drawable.rock);
                round++;
                if(round>=20)
                {

                    int a;
                    if(androidScore>playerScore) a=1;else if(androidScore<playerScore)a=2;else a=3;
                    androidScore=playerScore=round=0;
                    Intent in=new Intent(MainActivity.this, SecondActivity.class);in.putExtra("winner",a);
                    startActivity(in);
                }
                break;
            case id.buttonPaper:
                userSelection = Option.PAPER;
                imageView.setImageResource(drawable.paper);
                round++;
                if(round>=20)
                {
                    int a;

                    if(androidScore>playerScore) a=1;else if(androidScore<playerScore)a=2;else a=3;
                    androidScore=playerScore=round=0;
                    Intent in=new Intent(MainActivity.this, SecondActivity.class);in.putExtra("winner",a);
                    startActivity(in);
                }
                break;
            case id.buttonScissors:
                userSelection = Option.SCISSORS;
                imageView.setImageResource(drawable.scissor);
                round++;
                if(round>=20)
                {
                    int a;
                    if(androidScore>playerScore) a=1;else if(androidScore<playerScore)a=2;else a=3;
                    androidScore=playerScore=round=0;
                    Intent in=new Intent(MainActivity.this, SecondActivity.class);in.putExtra("winner",a);
                    startActivity(in);
                }
                break;
            case id.imageButtonHome:
                play = false;
                break;


        }

        if (play) {
            play();
            showResults();

        }
    }


    private void showResults() {
        textview2.setText("Round: "+round+"\nYour Score: "+playerScore+"\nAndroid Score: "+androidScore);

            play = false;
    }

    private void play() {
        // Generates a random play.
        int rand =  ((int)(Math.random() * 10)) % 3;
        Option androidSelection = null;
        ImageView imageView = (ImageView) findViewById(id.ImageViewAnswerAndroid);

        // Sets the right image according to random selection.
        switch (rand) {
            case 0:
                androidSelection = Option.ROCK;
                imageView.setImageResource(drawable.rock);

                break;
            case 1:
                androidSelection = Option.PAPER;
                imageView.setImageResource(drawable.paper);
                break;
            case 2:
                androidSelection = Option.SCISSORS;
                imageView.setImageResource(drawable.scissor);
                break;
        }
        // Determine game result according to user selection and Android selection.
        if(androidSelection == userSelection) {
            {gameResult = Result.DRAW;}
        }
        else if(androidSelection == Option.ROCK && userSelection == Option.SCISSORS) {
            {androidScore++;gameResult = Result.LOSS;}
        }
        else if(androidSelection == Option.PAPER && userSelection == Option.ROCK) {
            {androidScore++;gameResult = Result.LOSS;}
        }
        else if(androidSelection == Option.SCISSORS && userSelection == Option.PAPER) {
            {androidScore++;gameResult = Result.LOSS;}
        } else {
            gameResult = Result.WIN;
            playerScore++;
        }
    }
}
