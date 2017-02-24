package com.mancy.shoppingmall_1020.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mancy.shoppingmall_1020.R;
import com.mancy.shoppingmall_1020.home.bean.HomeBean;
import com.mancy.shoppingmall_1020.utils.Constants;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.transformer.BackgroundToForegroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    // 要显示类型数量的开关
    @Override
    public int getItemCount() {
        return 2;
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

            return new ChannelViewHolder(context, inflater.inflate(R.layout.channel_item, null));


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

            ChannelViewHolder ChannelViewHodler = (ChannelViewHolder) holder;

            ChannelViewHodler.setData(result.getChannel_info());

        } else if (getItemViewType(position) == ACT) {

        } else if (getItemViewType(position) == SECKILL) {

        } else if (getItemViewType(position) == RECOMMEND) {

        } else if (getItemViewType(position) == CHANNEL) {

        } else if (getItemViewType(position) == HOT) {

        }

    }


    //  第二类型的item  分类型  开头 ↓

    class ChannelViewHolder extends RecyclerView.ViewHolder {


        private final Context context;
        @BindView(R.id.gv_channel)
        GridView gvChannel;

        ChannelAdapter channelAdapter;


        public ChannelViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            ButterKnife.bind(this, itemView);

        }

        public void setData(List<HomeBean.ResultBean.ChannelInfoBean> channel_info) {
            channelAdapter = new ChannelAdapter(context, channel_info);
            //将gridView 设置 适配器

            gvChannel.setAdapter(channelAdapter);


            gvChannel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(context, "position==" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }


    }
    //  第二类型的item  分类型   结尾  ↑


    // 轮播图  开头  ↓
    class BannerViewHolder extends RecyclerView.ViewHolder {
//        private TextView title;

        private final Context context;

        private Banner banner;

        public BannerViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;

            banner = (Banner) itemView.findViewById(R.id.banner);



       /*     title = (TextView) itemView.findViewById(R.id.title);*/

        }

        public void setData(List<HomeBean.ResultBean.BannerInfoBean> banner_info) {
//            title.setText("w w w w w w w w ");

            //1.得到数据
            //2.设置Banner的数据

            List<String> images = new ArrayList<>();
            for (int i = 0; i < banner_info.size(); i++) {

                //一个个添加到images 里边

                images.add(Constants.BASE_URL_IMAGE + banner_info.get(i).getImage());

            }

            //简单使用

            banner.setImages(images)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            Glide.with(context)
                                    .load(path)
                                    .crossFade()
                                    .into(imageView);
                        }
                    }).start();

            //设置样式

            banner.setBannerAnimation(BackgroundToForegroundTransformer.class);


            //3.设置Banner的点击事件

            banner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {

                    int realPosition = position - 1;
                    Toast.makeText(context, "realPosition===" + realPosition, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
// 轮播图  结尾    ↑

}