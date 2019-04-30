package dex.gu.launch.scrollview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import dex.gu.launch.app_launch.MainActivity;
import dex.gu.launch.app_launch.R;
import dex.gu.launch.scrollview.MyScorllView.OnScrollChangedListener;

public class ScrollViewActivity extends Activity {

    private LinearLayout llanim;
    private MyScorllView scorllView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        llanim = findViewById(R.id.ll_anim);
        scorllView = findViewById(R.id.scrollview);
        button = findViewById(R.id.btn_join);
        llanim.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollViewActivity.this,MainActivity.class));
            }
        });
        scorllView.setOnScrollChangedListener(new OnScrollChangedListener() {
            @Override
            public void onScrollChange(int top, int oldtop) {
                if(top>oldtop){//上滑
                    Animation anim = AnimationUtils.loadAnimation(
                            ScrollViewActivity.this,R.anim.show
                    );
                    llanim.setVisibility(View.VISIBLE);
                    llanim.startAnimation(anim);
                }else {//下滑
                    Animation anim = AnimationUtils.loadAnimation(
                            ScrollViewActivity.this,R.anim.close
                    );
                    llanim.setVisibility(View.INVISIBLE);
                    llanim.startAnimation(anim);
                }
            }
        });
    }
}
