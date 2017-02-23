package com.mancy.shoppingmall_1020.home.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.mancy.shoppingmall_1020.R;
import com.mancy.shoppingmall_1020.base.BaseFragment;
import com.mancy.shoppingmall_1020.home.adapter.HomeAdapter;
import com.mancy.shoppingmall_1020.home.bean.HomeBean;
import com.mancy.shoppingmall_1020.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by Mancy on 2017/2/22.
 * <p>
 * 主页
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tv_search_home)
    TextView tvSearchHome;
    @BindView(R.id.tv_message_home)
    TextView tvMessageHome;
    @BindView(R.id.rv_home)
    android.support.v7.widget.RecyclerView rvHome;
    @BindView(R.id.ib_top)
    ImageButton ibTop;
    private TextView textView;

    private HomeAdapter adapter;


    @Override
    public View initView() {

        View view = View.inflate(mcontext, R.layout.fragment_home, null);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {
        super.initData();


        Log.e("TAG", "initData: 主页内容");


        getDataFromNet();
    }

    private void getDataFromNet() {

        OkHttpUtils
                .get()
                //联网地址
                .url(Constants.HOME_URL)
                .id(100)//http,
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "联网失败==" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "联网成功==");
                        processData(response);

                    }
                });
    }

    private void processData(String response) {
        ///三种解析方式   gson 解析     fastjson   手动解析


        HomeBean homeBean = JSON.parseObject(response, HomeBean.class);

        Log.e("TAG", "processData: " + homeBean.getResult().getHot_info().get(0).getName());


        adapter = new HomeAdapter(mcontext, homeBean.getResult());
        rvHome.setAdapter(adapter);

        // 设置 布局管理器

        rvHome.setLayoutManager(new LinearLayoutManager(mcontext, LinearLayoutManager.VERTICAL, false));
    }


    @OnClick({R.id.tv_search_home, R.id.tv_message_home, R.id.rv_home, R.id.ib_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search_home:
                Toast.makeText(mcontext, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_message_home:
                Toast.makeText(mcontext, "消息", Toast.LENGTH_SHORT).show();

                break;

            case R.id.ib_top:

                Toast.makeText(mcontext, "置顶", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
