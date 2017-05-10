package com.example.administrator.black_white_keys;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/10.
 */
/*
* 对话框样式
 */
public class Box_Dialog extends Dialog{
    private TextView tv_score;
    private Button btn_finish;
    private Button btn_restart;
    private View mRootView;
    public Box_Dialog(Context context) {
        this(context,0);
    }

    public Box_Dialog(Context context, int themeResId) {
        super(context, themeResId);
        mRootView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main,null);
        tv_score = (TextView) mRootView.findViewById(R.id.tv_score);
        btn_finish = (Button) mRootView.findViewById(R.id.choose_btn_finish);
        btn_restart = (Button) mRootView.findViewById(R.id.choose_btn_restart);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(mRootView);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCanceledOnTouchOutside(false);
    }
    public void setScore(String score){
        if(tv_score!=null){
            tv_score.setText(score);
        }
    }
    private void setFinishClickListener(View.OnClickListener onClickListener){
        if(btn_finish!=null){
            btn_finish.setOnClickListener(onClickListener);
        }
    }
    private void setRestartClickListener(View.OnClickListener onClickListener){
        if(btn_restart!=null){
            btn_restart.setOnClickListener(onClickListener);
        }
    }
    public static class Builder {
        private Box_Dialog mAlertScoreDialog;
        public Builder(Context context){
            mAlertScoreDialog = new Box_Dialog(context);
        }
        public Builder setScore(String score){
            mAlertScoreDialog.setScore(score);
            return this;
        }
        public Builder setFinishClickListener(View.OnClickListener onClickListener){
            mAlertScoreDialog.setFinishClickListener(onClickListener);
            return this;
        }
        public Builder setRestartClickListener(View.OnClickListener onClickListener){
            mAlertScoreDialog.setRestartClickListener(onClickListener);
            return this;
        }
        public Box_Dialog builder(){
            return mAlertScoreDialog;
        }
    }
}
