package com.example.animatonss;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView animationIV;
    private Button startBtn;
    private Button pauseBtn;
    private Button backBtn;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_activity);

        ConstraintLayout rootLayout = findViewById(R.id.root_layout);


        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        rootLayout.startAnimation(shakeAnimation);

        animationIV = findViewById(R.id.anim);
        startBtn = findViewById(R.id.strBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        backBtn = findViewById(R.id.backBtn);

        frameAnimation = (AnimationDrawable) animationIV.getDrawable();

        // Load animations
        Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);

        startBtn.setOnClickListener(v -> {
            v.startAnimation(buttonClickAnimation);
            if (!frameAnimation.isRunning()){
                frameAnimation.start();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            v.startAnimation(buttonClickAnimation);
            if (frameAnimation.isRunning()){
                frameAnimation.stop();
            }
        });

        backBtn.setOnClickListener(v -> {
            v.startAnimation(buttonClickAnimation);
            finish();
        });
    }
}
