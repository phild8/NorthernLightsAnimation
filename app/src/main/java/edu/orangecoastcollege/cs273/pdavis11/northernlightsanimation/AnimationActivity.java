package edu.orangecoastcollege.cs273.pdavis11.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * The controler - Loads the user interface and allows the user to select buttons that will start
 * various animations, such as: shake, rotate, frame, and blink.
 */
public class AnimationActivity extends AppCompatActivity {

    // AnimationDrawable = used for frame animations
    private AnimationDrawable frameAnim; // Null
    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;
    private Animation blinkAnim;

    private ImageView lightsImageView;

    /**
     * Loads the northern lights imagaview to the screen and sets the activity animation content.
     * @param savedInstanceState Loads a saved preference if there is one.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * Loads different northern lights pictures that and cycles through them.
     * @param view Button click that starts the frame animation.
     */
    public void toggleFrameAnim(View view){
        // Hasn't been initialized yet
        if (frameAnim == null){
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }
        // if frameAnim is running, stop it
        if (frameAnim.isRunning())
            frameAnim.stop();
        else // else start it
            frameAnim.start();
    }

    /**
     * Rotates the animation in clockwise pattern 5 times, unless the user ends it.
     * @param view The button click that starts or ends the rotation.
     */
    public void toggleRotateAnim(View view){
        // Hasn't been initialized yet
        if (rotateAnim == null)
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

        // if it hasn't started or it has ended, then start it
        if (!rotateAnim.hasStarted() | rotateAnim.hasEnded())
            lightsImageView.startAnimation(rotateAnim);
        else{
            lightsImageView.clearAnimation();
        }
    }

    /**
     * Move the image to left offscreen and then to the right offscreen and then back to the center.
     * @param view The button click that begins the movement.
     */
    public void toggleShakeAnim(View view) {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);
    }

    /**
     * Fades the picture in and out two separate times
     * @param view The button click that begins the fading.
     */
    public void toggleCustomAnim(View view){
        customAnim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);
        lightsImageView.startAnimation(customAnim);
    }

    /**
     * Blinks the picture of the northern lights.
     * @param view The button click that starts the blinking.
     */
    public void toggleBlinkAnim(View view){
        if (blinkAnim == null)
            blinkAnim = AnimationUtils.loadAnimation(this, R.anim.blink_anim);

        if (!blinkAnim.hasStarted() | blinkAnim.hasEnded())
            lightsImageView.startAnimation(blinkAnim);
        else
            lightsImageView.clearAnimation();
    }

}
