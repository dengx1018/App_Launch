package dex.gu.launch.viewpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import dex.gu.launch.app_launch.R;

public class ViewPageActivity extends FragmentActivity {

    private ViewPager viewPager;
    private LinearLayout indicator;

    private PagerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);
        viewPager = findViewById(R.id.viewPage);
        indicator = findViewById(R.id.indicator);

        for (int i = 0; i<3;i++){
            ContentFragment fragment = new ContentFragment();
            Bundle bundle = new Bundle();
            Log.w( " fragments",fragments.size()+"" );
            bundle.putInt("index",i);
            fragment.setArguments(bundle);
            Log.e( "onCreate: indexxxxx",i+"" );
            fragments.add(fragment);
            Log.e(" fragments",fragments.size()+"" );

        }
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        //adapter = new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int index, float v, int i1) {
                for (int i=0;i<fragments.size();i++){
                    indicator.getChildAt(i).setBackgroundResource(i==index?R.drawable.dot_focus:R.drawable.dot_normal);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        initindicator();
    }
    private void initindicator(){
        int width = (int)TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,10f,
                getResources().getDisplayMetrics());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,width);
        lp.rightMargin = 2*width;
        for (int i=0;i<fragments.size();i++){
            View view = new View(this);
            view.setId(i);
            view.setBackgroundResource(i==0?R.drawable.dot_focus:R.drawable.dot_normal);
            view.setLayoutParams(lp);
            indicator.addView(view,i);
        }
    }
}
