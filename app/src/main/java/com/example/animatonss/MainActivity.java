package com.example.animatonss;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animatonss.FrameAnimationActivity;
import com.example.animatonss.R;
import com.example.animatonss.TweenAnimationActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private Button frameAnimationButton;
    private Button tweenAnimationButton;
    private LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.root_layout);

        // анимация покачивания
        Animation shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake_animation);
        rootLayout.startAnimation(shakeAnimation);



        frameAnimationButton = findViewById(R.id.button_frame_animation);
        tweenAnimationButton = findViewById(R.id.button_tween_animation);


        frameAnimationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FrameAnimationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.ade_in, R.anim.ade_out);
        });

        tweenAnimationButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TweenAnimationActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);
        });
    }
}
