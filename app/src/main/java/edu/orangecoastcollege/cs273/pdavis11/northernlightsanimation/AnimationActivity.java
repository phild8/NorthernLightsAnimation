package edu.orangecoastcollege.cs273.pdavis11.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    // AnimationDrawable = used for frame animations
    private AnimationDrawable frameAnim; // Null
    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View view){
        // Hasn't been initialized yet
        if (frameAnim == null){
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }
        // if frameAnim is running, stop it
        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
        // else start it
    }

    public void toggleRotateAnim(View view){
        // Hasn't been initialized yet
        if (rotateAnim == null) {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        // if it hasn't started or it has ended, then start it
        if (!rotateAnim.hasStarted() | rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim);
        }
        else{
            lightsImageView.clearAnimation();
        }
    }

    public void toggleShakeAnim(View view) {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);

    }

    public void toggleCustomAnim(View view){

    }


}
