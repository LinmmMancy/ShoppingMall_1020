package com.mancy.shoppingmall_1020;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class WelcomeActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startMianActivity();


            }
        }, 2000);


    }

    private void startMianActivity() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));

        //关闭当前页面

        finish();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            startMianActivity();

            return true;
        }


        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacksAndMessages(null);


    }
}
