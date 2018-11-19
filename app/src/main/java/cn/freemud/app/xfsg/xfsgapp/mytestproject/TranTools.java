package cn.freemud.app.xfsg.xfsgapp.mytestproject;

import android.content.Context;

/**
 * Created by llxqb on 2018/11/8.
 */

public class TranTools {


    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
