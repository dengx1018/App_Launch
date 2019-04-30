package dex.gu.launch.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class MyScorllView extends ScrollView {
    private OnScrollChangedListener onScrollChangedListener;
    public MyScorllView(Context context) {
        super(context);
    }

    public MyScorllView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollChangedListener !=null ){
            onScrollChangedListener.onScrollChange(t,oldt);
        }
    }

    public OnScrollChangedListener getOnScrollChangedListener() {
        return onScrollChangedListener;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public interface OnScrollChangedListener{
        public void onScrollChange(int top,int oldtop);
    }
}
