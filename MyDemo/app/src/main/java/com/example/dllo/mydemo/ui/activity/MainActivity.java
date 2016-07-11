package com.example.dllo.mydemo.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dllo.mydemo.R;

public class MainActivity extends AbsBaseActivity implements View.OnClickListener {
private TextView mainTv;
    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainTv = (TextView) findViewById(R.id.main_tv);
    }

    @Override
    protected void setListeners() {
        mainTv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_tv:
                //goTo(this,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","小轩轩");
                bundle.putInt("number",123123);
                goTo(this,SecondActivity.class,bundle);
            break;
        }
    }

}
