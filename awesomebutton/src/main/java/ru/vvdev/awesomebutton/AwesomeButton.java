package ru.vvdev.awesomebutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by alexanderklimov on 6/3/18.
 */

public class AwesomeButton extends LinearLayout {

    CardView nullView;
    CardView firstView;
    CardView secondView;
    RelativeLayout button;
    CardView buttonView;
    TextView textView;
    int backColor,backColor1,backColor2,backColor3;
    String text;

    public AwesomeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }


    private void init(AttributeSet attrs) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.view_button_layout,this);
        button=v.findViewById(R.id.button);
        nullView=v.findViewById(R.id.null_outline);
        buttonView=v.findViewById(R.id.button_view);
        secondView=v.findViewById(R.id.second_outline);
        firstView=v.findViewById(R.id.first_outline);
        textView=v.findViewById(R.id.text);
        button.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                            animateDown();
                        break;
                        case MotionEvent.ACTION_UP:
                            animateUp();
                        break;
                }
                return true;
            }
        });

        nullView.animate().alpha(0.0f).start();
        secondView.animate().alpha(0.0f).start();
        firstView.animate().alpha(0.0f).start();

        setStyle(attrs);

    }

    private void setStyle(AttributeSet attrs){
        TypedArray arr = getContext().obtainStyledAttributes(attrs,R.styleable.awesome_button);
        backColor=arr.getColor(R.styleable.awesome_button_background_view,getResources().getColor(R.color.colorPrimary));
        backColor1=arr.getColor(R.styleable.awesome_button_background_first_view,getResources().getColor(R.color.colorPrimary));
        backColor2=arr.getColor(R.styleable.awesome_button_background_second_view,getResources().getColor(R.color.colorPrimary));
        backColor3=arr.getColor(R.styleable.awesome_button_background_third_view,getResources().getColor(R.color.colorPrimary));
        if(backColor1==getResources().getColor(R.color.colorPrimary))
            backColor1= backColor;
        if(backColor2==getResources().getColor(R.color.colorPrimary))
            backColor2= backColor;
        if(backColor3==getResources().getColor(R.color.colorPrimary))
            backColor3= backColor;

        text=arr.getString(R.styleable.awesome_button_text_view);
        buttonView.setCardBackgroundColor(backColor);
        secondView.setCardBackgroundColor(backColor1);
        firstView.setCardBackgroundColor(backColor2);
        nullView.setCardBackgroundColor(backColor3);

        textView.setText(text);


    }

    public void animateUp(){
        nullView.animate().alpha(0.0f).setDuration(50).start();
        secondView.animate().alpha(0.0f).setDuration(200).start();
        firstView.animate().alpha(0.0f).setDuration(100).start();
    }

    public void animateDown(){
        secondView.setVisibility(VISIBLE);
        firstView.setVisibility(VISIBLE);
        nullView.setVisibility(VISIBLE);
        secondView.animate().alpha(0.3f).setDuration(100).start();
        firstView.animate().alpha(0.2f).setDuration(150).start();
        nullView.animate().alpha(0.1f).setDuration(300).start();

    }

    public void setText(String text){
        textView.setText(text);
    }

    public void setBackground(int color){
        buttonView.setCardBackgroundColor(color);
        secondView.setCardBackgroundColor(color);
        firstView.setCardBackgroundColor(color);
        nullView.setCardBackgroundColor(color);
    }
    public void setBackground(String color){
       setBackground(Color.parseColor(color));
    }



}
