package cn.freemud.app.xfsg.xfsgapp.mytestproject;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;

/**
 * Created by li.liu on 2018/11/8.
 */

public class TakeawayRightAdapter extends RecyclerView.Adapter<TakeawayRightAdapter.MyHolder> {
    private  int b_w;

    private onDataChangeListener mOnDataChangeListener = null;
    private List<Order> infos;
    private Context mContext;

    private int clickPos;


    public TakeawayRightAdapter(List<Order> infos, onDataChangeListener onDataChangeListener, Context context) {
        this.mContext = context;
        this.mOnDataChangeListener = onDataChangeListener;
        this.infos = infos;
        b_w = TranTools.dip2px(context,80);
    }

    public interface onDataChangeListener {
        void rightDataChange();

        void onItemClick(View view, int position);

    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(
                mContext).inflate(R.layout.takeaway_order_state_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Order bean = infos.get(position);
        holder.name.setText(bean.name);
        holder.root.setTag(position);

        if(position==0){
            ValueAnimator animator = ValueAnimator.ofInt(0, 50);
            animator.setDuration(500);
            holder.name.setTextColor(Color.RED);
            animator.addUpdateListener(animation -> {
                int v = (int) animation.getAnimatedValue();
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)holder.rlRight .getLayoutParams();
                params.width = b_w+ TranTools.dip2px(mContext,v);
                holder.rlRight.setLayoutParams(params);
            });
            animator.start();
        }
        holder.root.setOnClickListener(view -> {
//            mOnDataChangeListener.onItemClick(holder.itemView,position);
            if(position!=clickPos){
                clickPos = (int) view.getTag();
                ValueAnimator animator = ValueAnimator.ofInt(0, 50);
                animator.setDuration(500);
                holder.name.setTextColor(Color.RED);
                animator.addUpdateListener(animation -> {
                    int v = (int) animation.getAnimatedValue();
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)holder.rlRight .getLayoutParams();
                    //params.leftMargin = magrin;
                    //params.rightMargin = magrin;
                    params.width = b_w+ TranTools.dip2px(mContext,v);
                    holder.rlRight.setLayoutParams(params);
                });
                animator.start();
                notifyDataSetChanged();
            }
        });

        if(position!=clickPos){
            LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams)holder.rlRight .getLayoutParams();
            ValueAnimator animator = ValueAnimator.ofInt(params1.width, b_w);
            animator.setDuration(500);
            animator.addUpdateListener(animation -> {
                int v = (int) animation.getAnimatedValue();
                LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams)holder.rlRight .getLayoutParams();
                params2.width = v;
                holder.rlRight.setLayoutParams(params2);
            });
            animator.start();
        }

    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        LinearLayout root;
        RelativeLayout rlRight;

        MyHolder(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.order_state_item_root);
            name = itemView.findViewById(R.id.order_state_name);
            rlRight = itemView.findViewById(R.id.order_state_rl);
        }
    }
}
