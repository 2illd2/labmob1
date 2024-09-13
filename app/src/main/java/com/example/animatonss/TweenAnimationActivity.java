package com.example.animatonss;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TweenAnimationActivity extends AppCompatActivity {
    private ImageView img;
    private Button startButton;
    private Button pauseButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_activity);
        ConstraintLayout rootLayout = findViewById(R.id.root_layout);


        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        rootLayout.startAnimation(shakeAnimation);

        img = findViewById(R.id.img_blink);
        startButton = findViewById(R.id.start_tween);
        pauseButton = findViewById(R.id.pause_tween);
        backButton = findViewById(R.id.back_tween);


        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);
        Animation buttonClickAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click_animation);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation);
                img.startAnimation(blinkAnimation);
            }
        });

        // Stop animation
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation);
                img.clearAnimation();
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(buttonClickAnimation);
                finish();
            }
        });
    }
}
