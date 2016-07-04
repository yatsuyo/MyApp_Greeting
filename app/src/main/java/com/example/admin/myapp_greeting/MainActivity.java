// 全て処理を扱う
package com.example.admin.myapp_greeting;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import android.app.Activity;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    EditText mEditText;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TimePickerDialog表示＆設定ボタン
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);


        // 現在時刻を取得
        Calendar calendar = Calendar.getInstance();
        int hour   = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);


        // 時間選択ダイアログの生成
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // 設定 ボタンクリック時の処理
                    }
                },
                hour,
                minute,
                true);

        // あいさつ表示ボタン
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        // あいさつ表示欄
        mTextView.setText(hour + ":" + minute);
        //mTextView = (TextView) findViewById(R.id.textView);
    }

    // ボタンなどを押したときの処理
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            TimePickerDialog();
            //hour = timePicker.getHour();
            //minute = TimePickerDialog.hourOfDay();
        } else if (v.getId() == R.id.button2) {
            //mTextView.setText(hour + ":" + minute);
            mTextView.setText(mEditText.getText().toString());
        }
    }

    private void TimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13, // 初期値（時間）
                6,  // 初期値（分）
                true);
        timePickerDialog.show();

    }



}