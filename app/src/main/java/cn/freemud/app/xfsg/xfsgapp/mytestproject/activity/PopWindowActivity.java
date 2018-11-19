package cn.freemud.app.xfsg.xfsgapp.mytestproject.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.freemud.app.xfsg.xfsgapp.mytestproject.R;
import cn.freemud.app.xfsg.xfsgapp.mytestproject.base.BaseActivity;

public class PopWindowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);

        initView();
        initData();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

    }
    private void initData() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pop_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_1:
                Toast.makeText(this, "我是第一个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_2:
                Toast.makeText(this, "我是第二个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_3:
                Toast.makeText(this, "我是第三个", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_4:
                Toast.makeText(this, "我是第四个", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
