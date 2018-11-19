package cn.freemud.app.xfsg.xfsgapp.mytestproject.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by llxqb on 2018/11/19.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static  void start(Context context,Class c){
        Intent intent = new Intent(context,c);
        context.startActivity(intent);
    }
}
