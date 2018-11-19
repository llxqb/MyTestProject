package cn.freemud.app.xfsg.xfsgapp.mytestproject.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by llxqb on 2018/11/19.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static  void start(Context context,Class c){
        Intent intent = new Intent(context,c);
        context.startActivity(intent);
    }
}
