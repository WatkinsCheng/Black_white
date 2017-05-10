package com.example.administrator.black_white_keys;

import android.graphics.Color;
import android.graphics.RectF;

public class Block {
    public static final int standard = 0;
    public static final int active= 1;
    public static final int error= 2;
    public static final int visited = 3;
    private int[] mBgColors = new int[]{Color.WHITE,Color.BLACK,Color.RED,0xFFD2D2D2};
    private int mState = standard;
    private float mHeight;
    private float mWidth;
    private float mBorderSize;
    private RectF mRectF;
    public Block(float height,float width, float borderSize, RectF rectF) {
        this.mHeight = height;
        this.mWidth = width;
        this.mBorderSize = borderSize;
        this.mRectF = rectF;
    }
    /**
     * 判断是否被点击
     */
    public boolean  isClickRange(float x,float y){
        boolean flag = false;
        if(null!=mRectF ) {
            if (x > mRectF.left && x < mRectF.right-mBorderSize && y > mRectF.top && y < mRectF.bottom-mBorderSize) {
                flag = true;
            }
        }
        return flag;
    }
    public int getBgColor(){
        return mBgColors[mState];
    }
    public void toggleVisited(){
        mState = visited;
    }
    public void toggleError(){
        mState = error;
    }
    public boolean isActive(){
        return mState == active;
    }
    public boolean isStandard(){
        return mState == standard;
    }

    public int[] getBgColors() {
        return mBgColors;
    }

    public void setBgColors(int[] bgColors) {
        mBgColors = bgColors;
    }

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        mState = state;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(float height) {
        mHeight = height;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(float width) {
        mWidth = width;
    }

    public float getBorderSize() {
        return mBorderSize;
    }

    public void setBorderSize(float borderSize) {
        mBorderSize = borderSize;
    }

    public RectF getRectF() {
        return mRectF;
    }

    public void setRectF(RectF rectF) {
        mRectF = rectF;
    }
}