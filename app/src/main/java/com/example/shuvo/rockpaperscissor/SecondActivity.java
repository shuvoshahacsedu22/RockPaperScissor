package com.example.shuvo.rockpaperscissor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textview = (TextView) findViewById(R.id.textView4);
        Button butt=(Button)findViewById(R.id.buttonExit);
        butt.setOnClickListener((View.OnClickListener) this);
        int n = 0;

        Intent in=getIntent();
        n=in.getIntExtra("winner",n);
        if(n==1) textview.setText("You Lost!");
        else if(n==2) textview.setText("You are the ultimate Winner");
        else textview.setText("Match Drawn!");
        textview.setTextColor(Color.RED);
    }


    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonExit:
                finish();
                break;

        }
    }

}
