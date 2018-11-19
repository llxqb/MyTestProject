package cn.freemud.app.xfsg.xfsgapp.mytestproject.activity;

import android.os.Bundle;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import cn.freemud.app.xfsg.xfsgapp.mytestproject.MainActivity;
import cn.freemud.app.xfsg.xfsgapp.mytestproject.R;
import cn.freemud.app.xfsg.xfsgapp.mytestproject.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        initData();
    }

    Button mBtn1;
    Button mBtn2;

    private void initView() {
        mBtn1 = findViewById(R.id.btn_1);
        mBtn2 = findViewById(R.id.btn_2);
    }

    private void initData() {
        RxView.clicks(mBtn1).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> mBtn1());
        RxView.clicks(mBtn2).throttleFirst(1, TimeUnit.SECONDS).subscribe(o -> mBtn2());
    }

    private void mBtn1() {
        MainActivity.start(this, MainActivity.class);
    }

    private void mBtn2() {
        PopWindowActivity.start(this, PopWindowActivity.class);
    }

}
