package com.mancy.shoppingmall_1020.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mancy.shoppingmall_1020.R;
import com.mancy.shoppingmall_1020.home.bean.HomeBean;
import com.mancy.shoppingmall_1020.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mancy on 2017/2/24.
 */

public class ChannelAdapter extends BaseAdapter {

    private final Context context;
    private final List<HomeBean.ResultBean.ChannelInfoBean> datas;

    public ChannelAdapter(Context context, List<HomeBean.ResultBean.ChannelInfoBean> rssult) {

        this.context = context;
        this.datas = rssult;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;


        if (convertView == null) {


            convertView = View.inflate(context, R.layout.item_channel, null);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);


        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        // 根据为位置得到相应 的数据
        HomeBean.ResultBean.ChannelInfoBean channelInfoBean = datas.get(position);

        viewHolder.tvChannel.setText(channelInfoBean.getChannel_name());


        // 请求图片

        Glide.with(context)
                // 获取图片的地址
                .load(Constants.BASE_URL_IMAGE + channelInfoBean.getImage())
                .crossFade()

                // 将图片设置进去
                .into(viewHolder.ivChannel);

        return convertView;

    }


    class ViewHolder {
        @BindView(R.id.iv_channel)
        ImageView ivChannel;
        @BindView(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
