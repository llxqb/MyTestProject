package cn.freemud.app.xfsg.xfsgapp.mytestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.freemud.app.xfsg.xfsgapp.mytestproject.base.BaseActivity;

public class MainActivity extends BaseActivity implements TakeawayRightAdapter.onDataChangeListener {

    String[] orderName = {"状态1", "状态2", "状态3", "状态4"};
    List<Order> orderList = new ArrayList<>();
    RecyclerView mRecyclerViewLeft, mRecyclerViewRight;
    TakeawayRightAdapter takeawayRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initRecycler();
    }

    private void initView() {
        for (int i = 0; i < orderName.length; i++) {
            Order order = new Order();
            order.name = orderName[i];
            orderList.add(order);
        }
        mRecyclerViewLeft = findViewById(R.id.recyclerView_left);
        mRecyclerViewRight = findViewById(R.id.recyclerView_right);
    }

    private void initRecycler() {
        takeawayRightAdapter = new TakeawayRightAdapter(orderList, this, this);
        mRecyclerViewRight.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewRight.setAdapter(takeawayRightAdapter);
        takeawayRightAdapter = new TakeawayRightAdapter(orderList, this, this);
        mRecyclerViewLeft.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewLeft.setAdapter(takeawayRightAdapter);
    }

    @Override
    public void rightDataChange() {

    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
