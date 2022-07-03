package com.example.catchwitcher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;
    TextView timeText, scoreText;
    ImageView[] array1;
    Handler handler;
    Runnable runnable;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timeText = findViewById(R.id.timeText);
        scoreText=findViewById(R.id.scoreText);
        imageView1 = findViewById(R.id.imageView12);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        imageView4 =findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 =findViewById(R.id.imageView9);


        array1 = new ImageView[]{imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
        new CountDownTimer(10000, 1000) {

            @Override
            public void onTick(long l) {

                timeText  .setText("TIME: " + l / 1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("TIME OFF!!");
                handler.removeCallbacks(runnable);
                for (ImageView image:array1){
                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert =new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Restart");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent =getIntent();
                        finish();
                        startActivity(intent);


                    }
                }).show();
            }
        }.start();



    }

    public void asdas(View view) {
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView image:array1){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random =new Random();
                int i=random.nextInt(9);
                array1[i].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,30000);
            }
        };
        handler.post(runnable);


        score++;
        scoreText.setText("SCORE: " + score);
    }


}



