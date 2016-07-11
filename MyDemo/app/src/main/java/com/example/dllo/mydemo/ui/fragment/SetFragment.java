package com.example.dllo.mydemo.ui.fragment;

import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.mydemo.R;
import com.example.dllo.mydemo.ui.activity.SecondActivity;

/**
 * Created by dllo on 16/7/11.
 */
public class SetFragment extends AbsBaseFragment {
    private TextView textView;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        textView = byView(R.id.main_tv);
        Toast.makeText(context, "__", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initDatas() {
        goTo(context, SecondActivity.class);
    }
}
