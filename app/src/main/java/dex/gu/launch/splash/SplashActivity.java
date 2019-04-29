package dex.gu.launch.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dex.gu.launch.app_launch.MainActivity;
import dex.gu.launch.app_launch.R;

public class SplashActivity extends AppCompatActivity {

    private static final Long WAIT_TIME = 5000L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },WAIT_TIME);
    }
}
