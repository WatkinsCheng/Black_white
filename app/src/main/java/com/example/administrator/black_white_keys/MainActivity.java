package com.example.administrator.black_white_keys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private CountDownView mCountDownView;
    private KeysSuerfaceView mKeysSuerfaceView;
    private RelativeLayout mGray;
    private Box_Dialog mBox_Dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mKeysSuerfaceView = (KeysSuerfaceView) findViewById(R.id.keysSuerfaceView);
        mCountDownView = (CountDownView) findViewById(R.id.countTextView);
        mGray = (RelativeLayout) findViewById(R.id.Gray);
        mCountDownView.setData(Arrays.asList("3","2","1","开始"));
        mCountDownView.init();
        mCountDownView.setCountDownListener(new CountDownView.CountDownListener() {
            @Override
            public void finish() {
                mGray.setVisibility(View.GONE);
                mKeysSuerfaceView.setZOrderOnTop(true);
                mKeysSuerfaceView.startGame();
            }
        });

        mBox_Dialog = new Box_Dialog.Builder(MainActivity.this)
                .setFinishClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("DEMO","点击点击");
                        finish();
                        mBox_Dialog.dismiss();
                    }
                })
                .setRestartClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mBox_Dialog.dismiss();
                        mKeysSuerfaceView.restart();
                        mGray.setVisibility(View.VISIBLE);
                        mCountDownView.init();

                    }
                })
                .builder();


        mKeysSuerfaceView.setGameListener(new KeysSuerfaceView.GameListener() {
            @Override
            public void gameEnd(final  String number) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("DEMO","number == "+number);
                        if(mBox_Dialog!=null){
                            mBox_Dialog.setScore(number);
                            mBox_Dialog.show();
                        }

                    }
                });

            }
        });
    }
}
