package dex.gu.launch.viewpage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import dex.gu.launch.app_launch.MainActivity;
import dex.gu.launch.app_launch.R;

public class ContentFragment extends Fragment {

    private int[] bgRes={R.mipmap.launching_01,R.mipmap.launching_02,R.mipmap.launching_03};
    private Button button;
    private RelativeLayout relativeLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,null);
        relativeLayout = view.findViewById(R.id.rl);
        button = view.findViewById(R.id.btn_join);

        int index = getArguments().getInt("index");
        relativeLayout.setBackgroundResource(bgRes[index]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        button.setVisibility(index==2?View.VISIBLE:View.GONE);
        return view;
    }
}
