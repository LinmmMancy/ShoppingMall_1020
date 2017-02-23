package com.mancy.shoppingmall_1020.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mancy.shoppingmall_1020.R;
import com.mancy.shoppingmall_1020.home.bean.HomeBean;

import java.util.List;

/**
 * Created by Mancy on 2017/2/23.
 */


public class HomeAdapter extends RecyclerView.Adapter {


    /**
     * 六种类型
     */
    /**
     * 横幅广告-要从0开
     */
    public static final int BANNER = 0;
    /**
     * 频道
     */
    public static final int CHANNEL = 1;

    /**
     * 活动
     */
    public static final int ACT = 2;

    /**
     * 秒杀
     */
    public static final int SECKILL = 3;
    /**
     * 推荐
     */
    public static final int RECOMMEND = 4;
    /**
     * 热卖
     */
    public static final int HOT = 5;
    private final Context context;
    private final HomeBean.ResultBean result;
    /**
     * 用他加载布局
     */
    private final LayoutInflater inflater;
    /**
     * 当前类型
     */
    public int currentType = BANNER;


    public HomeAdapter(Context context, HomeBean.ResultBean result) {
        this.context = context;
        this.result = result;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            currentType = BANNER;
        } else if (position == CHANNEL) {
            currentType = CHANNEL;
        } else if (position == ACT) {
            currentType = ACT;
        } else if (position == SECKILL) {
            currentType = SECKILL;
        } else if (position == RECOMMEND) {
            currentType = RECOMMEND;
        } else if (position == HOT) {
            currentType = HOT;
        }

        return currentType;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        // 当前的类型

        if (viewType == BANNER) {

            return new BannerViewHolder(context, inflater.inflate(R.layout.banner_viewpager, null));

        } else if (viewType == CHANNEL) {

        } else if (viewType == ACT) {

        } else if (viewType == SECKILL) {

        } else if (viewType == RECOMMEND) {

        } else if (viewType == HOT) {

        }


        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        //  绑定数据

        if (getItemViewType(position) == BANNER) {
            BannerViewHolder viewHolder = (BannerViewHolder) holder;

            viewHolder.setData(result.getBanner_info());

        } else if (getItemViewType(position) == CHANNEL) {

        } else if (getItemViewType(position) == ACT) {

        } else if (getItemViewType(position) == SECKILL) {

        } else if (getItemViewType(position) == RECOMMEND) {

        } else if (getItemViewType(position) == CHANNEL) {

        } else if (getItemViewType(position) == HOT) {

        }

    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;

        private final Context context;

        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;

            title = (TextView) itemView.findViewById(R.id.title);

        }

        public void setData(List<HomeBean.ResultBean.BannerInfoBean> banner_info) {
            title.setText("w w w w w w w w ");
        }
    }


}