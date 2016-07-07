// あいさつ課題
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

    // 現在時刻を取得
    Calendar calendar = Calendar.getInstance();
    int hour2 = calendar.get(Calendar.HOUR_OF_DAY);
    int minute2 = calendar.get(Calendar.MINUTE);

    int hour3;
    int minute3;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TimePickerDialog表示＆設定ボタン
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // あいさつ表示ボタン
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

    }


    // ボタンなどを押したときの処理
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button1) {
            TimePickerDialog();
        } else if (v.getId() == R.id.button2) {

            TextView textView = (TextView) findViewById(R.id.textView);
            //textView.setText(hour3 + ":" + minute3);

            if (hour3 >= 2 && hour3 < 10) {
                textView.setText("おはよう");
            } else if (hour3 >= 10 && hour3 < 18) {
                textView.setText("こんにちは");
            } else
                textView.setText("こんばんは");
            }
        }


    private void TimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        //                // 設定 ボタンクリック時の処理
                                        hour3 = hourOfDay;
                                       minute3 = minute;
                    }
                },
                hour2, // 初期値（時間）
                minute2,  // 初期値（分）
                true);
        timePickerDialog.show();

    }

}