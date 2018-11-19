package cn.freemud.app.xfsg.xfsgapp.mytestproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import cn.freemud.app.xfsg.xfsgapp.mytestproject.adapter.BtnChangePageAdapter;

public class BtnChangePageActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerView;
    List<Integer> mList = new ArrayList<>();
    int totalScroll;
    int rvHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_change_page);

        initView();
        initData();
    }


    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        Button prePage = findViewById(R.id.pre_page);
        prePage.setOnClickListener(this);
        Button nextPage = findViewById(R.id.next_page);
        nextPage.setOnClickListener(this);
        BtnChangePageAdapter btnChangePageAdapter = new BtnChangePageAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this) {
                                           @Override
                                           public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
                                               Log.i("dddd", "Height = " + mRecyclerView.getHeight());
                                           }
                                       }
        );
        mRecyclerView.setAdapter(btnChangePageAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalScroll += dy;
                Log.i("dddd", "total = " + totalScroll);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 6; i++) {
            mList.add(i);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                rvHeight = mRecyclerView.getHeight();
                Log.i("dddd", "rvHeight = " + rvHeight);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pre_page:
                if (mRecyclerView.canScrollVertically(-1)) {
                    mRecyclerView.smoothScrollBy(0, -rvHeight);
                } else {
                    Toast.makeText(this, "已經是頂部了", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.next_page:
                //mRecyclerView.scrollBy(0,rvHeight);
                if (mRecyclerView.canScrollVertically(1)) {
                    mRecyclerView.smoothScrollBy(0, rvHeight);
                } else {
                    Toast.makeText(this, "已經是底部了", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
