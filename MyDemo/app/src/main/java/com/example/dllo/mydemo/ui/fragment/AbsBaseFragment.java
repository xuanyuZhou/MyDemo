package com.example.dllo.mydemo.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.mydemo.ui.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/7/11.
 */
public abstract class AbsBaseFragment extends Fragment {

    protected Context context;
    // getActivity 或者 getContext
    // 你要去找别人要

    /**
     * 当Activity和Fragment关联时会被调用
     * 传入一个Context给你使用
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(),container,false);
    }

    /**
     * 抽象方法 设置布局
     * @return
     */
    protected abstract int setLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 调用
        initView();
    }

    /**
     * 初始化组件
     */
    protected abstract void initView();

    /**
     * 简化findViewById
     */
    protected <T extends View>T byView(int resId) {
        return (T) getView().findViewById(resId);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 初始化数据
        initDatas();
    }

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    protected void goTo(Context from,Class<? extends AbsBaseActivity> to) {
        Intent intent = new Intent(from,to);
        from.startActivity(intent);
    }

}
