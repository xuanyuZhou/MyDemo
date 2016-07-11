package com.example.dllo.mydemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by dllo on 16/7/11.
 * 抽象的Activity基类
 * 在此类中规定了整个应用的业务流程及界面效果
 * <p/>
 * 写基类的目的:
 * 1. 规定项目整体界面风格
 * 2. 简化代码, 将那些繁琐的代码省略 (setContentView,findViewById,newIntent,this.class)
 * 扩展: 注解 ButterKnife插件
 */
public abstract class AbsBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在setContentView上方 去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,// 设置宽和高都是全屏
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 加入一些进入退出的动画


        // 绑定布局(使用setLayout抽象方法绑定布局)
        setContentView(setLayout());
        // 订制流程
        // 1. 初始化组件
        initViews();
        // 2. 设置监听
        setListeners();
        // 3. 初始化数据
        initDatas();


    }

    /**
     * 设置xml布局文件
     * (protected修饰: 子类和同包可访问)
     * (返回值为int : 因为xml文件R.layout是int类型)
     *
     * @return layout布局文件 例如 : eg.R.layout.activity_main;
     */
    protected abstract int setLayout();

    /**
     * 初始化组件
     */
    protected abstract void initViews();

    /**
     * 设置监听
     */
    protected abstract void setListeners();

    /**
     * 初始化数据
     */
    protected abstract void initDatas();

    /**
     * 简化findViewById
     * T 泛型: 泛指一系列类型 T指的是View的子类
     */
    protected <T extends View> T byView(int resId) {
        T t = (T) findViewById(resId);
        return t;
    }

    /**
     * 简化intent跳转
     *
     * @param from intent 里的XX.this
     * @param to   intent里的xx.class  ?号为什么类 要求为基类的子类
     *             这里的限制条件是: 要是我们写的基类的子类
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to) {
        Intent intent = new Intent(from, to);
        startActivity(intent);
    }

//        protected void goTo(String action, String uri){
//        Intent intent = new Intent(action);
//        intent.setData(Uri.parse(uri));
//        startActivity(intent);
//
//    }

    /**
     * 带值跳转
     * @param from
     * @param to
     * @param values Bundle类型的值 (是一个轻量级存储数据的类,存储的形式key-value)
     */
    protected void goTo(Context from, Class<? extends AbsBaseActivity> to, Bundle values) {
        Intent intent = new Intent(from,to);
        intent.putExtras(values); // 用Bundle传值 打包  传值们
        startActivity(intent);
    }


}
