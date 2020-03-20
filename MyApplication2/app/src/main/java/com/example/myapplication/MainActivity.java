package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.util.EventLog;
import android.util.Log;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button change = findViewById(R.id.change);
        Button bigger = findViewById(R.id.bigger);
        Button recover = findViewById(R.id.recover);
        RadioGroup color = findViewById(R.id.color);
        final RadioButton red = findViewById(R.id.red);
        final RadioButton black = findViewById(R.id.black);
        final TextView show =findViewById(R.id.show);
        final EditText input = findViewById(R.id.input);
        final float textsize = show.getTextSize();

        show.setTextSize(TypedValue.COMPLEX_UNIT_PX,textsize);
        input.setTextSize(TypedValue.COMPLEX_UNIT_PX,textsize);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText(input.getText());
                Log.d(TAG, "修改文字为："+input.getText());
            }
        });

        bigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float size = textsize * 2;
                show.setTextSize(TypedValue.COMPLEX_UNIT_PX,size);
                Log.d(TAG,"放大");
            }
        });

        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setTextSize(TypedValue.COMPLEX_UNIT_PX,textsize);
                Log.d(TAG,"还原");
            }
        });

        color.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(red.getId() == checkedId){
                    show.setTextColor(Color.RED);
                    Log.d(TAG,"设置颜色为红色");
                }
                if (black.getId() == checkedId){
                    show.setTextColor(Color.BLACK);
                    Log.d(TAG,"设置颜色为黑色");
                }
            }
        });

    }
}
